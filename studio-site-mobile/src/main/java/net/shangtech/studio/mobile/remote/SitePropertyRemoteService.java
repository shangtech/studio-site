package net.shangtech.studio.mobile.remote;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.shangtech.studio.remote.ISitePropertyRemoteService;
import net.shangtech.studio.util.SitePropertyUtils;

public class SitePropertyRemoteService implements ISitePropertyRemoteService {

	private static final Logger logger = LoggerFactory.getLogger(SitePropertyRemoteService.class);
	
	private ServletContext servletContext;
	
	@Override
    public void refreshSiteProperties() {
	    logger.info("远程刷新站点properties方法被调用了");
	    SitePropertyUtils.refreshProperties(getServletContext());
    }
	
	public SitePropertyRemoteService(ServletContext sc){
		this.servletContext = sc;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
}
