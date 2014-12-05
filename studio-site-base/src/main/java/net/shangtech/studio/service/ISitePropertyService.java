package net.shangtech.studio.service;

import java.util.List;

import net.shangtech.framework.service.IBaseService;
import net.shangtech.studio.entity.SiteProperty;

public interface ISitePropertyService extends IBaseService<SiteProperty> {
	void save(List<SiteProperty> list);
}
