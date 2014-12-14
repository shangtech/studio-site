package net.shangtech.studio.service;

import net.shangtech.framework.service.IBaseService;
import net.shangtech.studio.entity.SpecialPage;

public interface ISpecialPageService extends IBaseService<SpecialPage> {
	SpecialPage findByUrl(String url);
}
