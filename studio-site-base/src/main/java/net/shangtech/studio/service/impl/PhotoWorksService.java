package net.shangtech.studio.service.impl;

import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.dao.IPhotoWorksDao;
import net.shangtech.studio.dao.IWorksToStyleDao;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.service.IPhotoWorksService;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class PhotoWorksService extends BaseService<PhotoWorks> implements IPhotoWorksService {

	@Autowired private IPhotoWorksDao dao;
	@Autowired private IWorksToStyleDao worksToStyleDao;

	@Override
    public Pagination<PhotoWorks> findByPhotographerByPage(Pagination<PhotoWorks> pagination, Long author) {
	    if(author == null){
	    	return findAllByPage(pagination);
	    }
	    return dao.findPage(() -> {
	    	return DetachedCriteria.forClass(PhotoWorks.class).add(Restrictions.eq("author", author));
	    }, pagination);
    }
	
	@Override
	public void update(PhotoWorks works){
		Assert.notNull(works, "can not update a null object");
		Assert.notNull(works.getId(), "id of object to update can not be null");
		PhotoWorks old = dao.find(works.getId());
		if(old != null){
			old.setAddress(works.getAddress());
			old.setDescription(works.getDescription());
			old.setHearts(works.getHearts());
			if(StringUtils.isNotBlank(works.getImage())){
				old.setImage(works.getImage());
			}
			if(StringUtils.isNotBlank(works.getImages())){
				old.setImages(works.getImages());
			}
			old.setImages(works.getImages());
			old.setName(works.getName());
			dao.update(old);
		}
	}

	@Override
    public Pagination<PhotoWorks> findByStyleByPage(Pagination<PhotoWorks> pagination, Long style) {
		//TODO 还不确定对不对
		if(style == null){
	    	return findAllByPage(pagination);
	    }
	    return dao.findPage(() -> {
	    	DetachedCriteria criteria = DetachedCriteria.forClass(PhotoWorks.class);
	    	criteria.createCriteria("worksToStyleSet")
	    		.createCriteria("style", "style")
	    		.add(Restrictions.eq("style.id", style));
	    	return criteria;
	    }, pagination);
    }

}
