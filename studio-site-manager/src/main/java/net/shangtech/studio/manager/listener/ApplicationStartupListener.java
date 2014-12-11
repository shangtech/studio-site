package net.shangtech.studio.manager.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

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
    }

}
