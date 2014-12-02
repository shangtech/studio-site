package net.shangtech.studio.service;

import net.shangtech.framework.service.IBaseService;
import net.shangtech.studio.entity.Style;

public interface IStyleService extends IBaseService<Style> {
	
	void removeWorksToStyle(Long works, Long style);
	
	void addWorksToStyle(Long works, Long style);

}
