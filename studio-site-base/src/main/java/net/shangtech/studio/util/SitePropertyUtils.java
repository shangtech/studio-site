package net.shangtech.studio.util;

import java.util.List;

import javax.servlet.ServletContext;

import net.shangtech.studio.entity.SiteProperty;
import net.shangtech.studio.service.ISitePropertyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SitePropertyUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(SitePropertyUtils.class);
	
	public static void refreshProperties(ServletContext sc){
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
	    ISitePropertyService propertyService = (ISitePropertyService) ctx.getBean(ISitePropertyService.class);
	    List<SiteProperty> properties = propertyService.findAll();
	    if(!CollectionUtils.isEmpty(properties)){
	    	properties.forEach(prop -> {
	    		sc.setAttribute(prop.getPropertyCode(), prop.getPropertyValue());
	    		logger.info("loading property [{}] = [{}]", prop.getPropertyCode(), prop.getPropertyValue());
	    	});
	    }
	}
	
}
