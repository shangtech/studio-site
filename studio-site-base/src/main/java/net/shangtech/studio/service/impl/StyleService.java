package net.shangtech.studio.service.impl;

import net.shangtech.framework.dao.support.MapHolder;
import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.dao.IPhotoWorksDao;
import net.shangtech.studio.dao.IStyleDao;
import net.shangtech.studio.dao.IWorksToStyleDao;
import net.shangtech.studio.entity.Style;
import net.shangtech.studio.entity.WorksToStyle;
import net.shangtech.studio.service.IStyleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class StyleService extends BaseService<Style> implements IStyleService {

	@Autowired private IStyleDao dao;
	@Autowired private IWorksToStyleDao worksToStyleDao;
	@Autowired private IPhotoWorksDao worksDao;

	@Override
	public void update(Style style){
		Assert.notNull(style, "can not update null");
		Assert.notNull("style", "can not update entity with a null id");
		Style old = dao.find(style.getId());
		if(old != null){
			old.setDescription(style.getDescription());
			old.setMemo(style.getMemo());
			old.setUrl(style.getUrl());
			dao.update(old);
		}
	}

	@Override
    public void removeWorksToStyle(Long works, Long style) {
	    WorksToStyle wts = worksToStyleDao.findOneByProperties(MapHolder.instance("photoWorks.id", works).put("style.id", style));
	    if(wts != null){
	    	worksToStyleDao.delete(wts.getId());
	    }
    }

	@Override
    public void addWorksToStyle(Long works, Long style) {
		WorksToStyle wts = worksToStyleDao.findOneByProperties(MapHolder.instance("photoWorks.id", works).put("style.id", style));
		if(wts == null){
			wts = new WorksToStyle();
			wts.setPhotoWorks(worksDao.find(works));
			wts.setStyle(dao.find(style));
			worksToStyleDao.save(wts);
		}
    }

}
