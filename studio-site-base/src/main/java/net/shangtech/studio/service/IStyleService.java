package net.shangtech.studio.service;

import java.util.List;

import net.shangtech.framework.service.IBaseService;
import net.shangtech.studio.entity.Style;
import net.shangtech.studio.entity.WorksToStyle;

public interface IStyleService extends IBaseService<Style> {
	
	void removeWorksToStyle(Long works, Long style);
	
	void addWorksToStyle(Long works, Long style);
	
	List<WorksToStyle> findByWorks(Long works);
}
