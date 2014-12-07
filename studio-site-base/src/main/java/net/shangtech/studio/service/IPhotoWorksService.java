package net.shangtech.studio.service;

import java.util.List;

import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.framework.service.IBaseService;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.entity.WorksToStyle;

public interface IPhotoWorksService extends IBaseService<PhotoWorks> {
	Pagination<PhotoWorks> findByPhotographerByPage(Pagination<PhotoWorks> pagination, Long author);
	Pagination<WorksToStyle> findByStyleByPage(Pagination<WorksToStyle> pagination, Long style);
	List<WorksToStyle> findByStyle(Long style);
	List<PhotoWorks> findByPhotographer(Long photographer);
	PhotoWorks findByUrl(String url);
}
