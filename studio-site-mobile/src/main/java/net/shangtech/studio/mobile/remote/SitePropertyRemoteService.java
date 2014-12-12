package net.shangtech.studio.mobile.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.servlet.ServletContext;

import net.shangtech.studio.remote.ISitePropertyRemoteService;
import net.shangtech.studio.util.SitePropertyUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SitePropertyRemoteService extends UnicastRemoteObject implements ISitePropertyRemoteService {
    
    public SitePropertyRemoteService(ServletContext sc) throws RemoteException{
    	super();
		this.servletContext = sc;
	}

	private static final long serialVersionUID = -8358699124941984965L;

	private static final Logger logger = LoggerFactory.getLogger(SitePropertyRemoteService.class);
	
	private ServletContext servletContext;
	
	@Override
    public void refreshSiteProperties() throws RemoteException {
	    logger.info("远程刷新站点properties方法被调用了");
	    SitePropertyUtils.refreshProperties(getServletContext());
    }

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
}
