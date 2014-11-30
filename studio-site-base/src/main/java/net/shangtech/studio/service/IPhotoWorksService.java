package net.shangtech.studio.service;

import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.framework.service.IBaseService;
import net.shangtech.studio.entity.PhotoWorks;

public interface IPhotoWorksService extends IBaseService<PhotoWorks> {
	Pagination<PhotoWorks> findByPhotographerByPage(Pagination<PhotoWorks> pagination, Long author);
}
