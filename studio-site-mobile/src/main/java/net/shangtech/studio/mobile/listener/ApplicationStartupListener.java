package net.shangtech.studio.mobile.listener;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.shangtech.studio.mobile.remote.SitePropertyRemoteService;
import net.shangtech.studio.remote.ISitePropertyRemoteService;
import net.shangtech.studio.util.SitePropertyUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationStartupListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationStartupListener.class);
	
	@Override
    public void contextDestroyed(ServletContextEvent arg0) {
	    // does nothing
    }

	@Override
    public void contextInitialized(ServletContextEvent sce) {
		logger.info("load propreties when app startup");
		SitePropertyUtils.refreshProperties(sce.getServletContext());
		try {
			ISitePropertyRemoteService service = new SitePropertyRemoteService(sce.getServletContext());
			LocateRegistry.createRegistry(8888);
	        Naming.rebind("rmi://127.0.0.1:8888/property-service", service);
        } catch (RemoteException | MalformedURLException e) {
	        logger.error("启动刷新站点属性远程调用接口失败", e);
	        throw new RuntimeException();
        }
    }
}
