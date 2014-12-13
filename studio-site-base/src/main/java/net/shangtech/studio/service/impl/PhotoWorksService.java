package net.shangtech.studio.service.impl;

import java.util.List;

import net.shangtech.framework.dao.support.MapHolder;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.dao.IPhotoWorksDao;
import net.shangtech.studio.dao.IStyleDao;
import net.shangtech.studio.dao.IWorksToStyleDao;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.entity.Style;
import net.shangtech.studio.entity.WorksToStyle;
import net.shangtech.studio.service.IPhotoWorksService;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;


@Service
@Transactional
public class PhotoWorksService extends BaseService<PhotoWorks> implements IPhotoWorksService {

	@Autowired private IPhotoWorksDao dao;
	@Autowired private IWorksToStyleDao worksToStyleDao;
	@Autowired private IStyleDao styleDao;

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
    public Pagination<WorksToStyle> findByStyleByPage(Pagination<WorksToStyle> pagination, Long style) {
	    return worksToStyleDao.findPage(() -> {
	    	DetachedCriteria criteria = DetachedCriteria.forClass(WorksToStyle.class);
	    	criteria.createCriteria("style", "style")
	    		.add(Restrictions.eq("style.id", style));
	    	return criteria;
	    }, pagination);
    }

	@Override
    public List<WorksToStyle> findByStyle(Long style) {
	    return worksToStyleDao.findByProperties(MapHolder.instance("style.id", style));
    }

	@Override
    public List<PhotoWorks> findByPhotographer(Long photographer) {
	    return dao.findByProperties(MapHolder.instance("author", photographer));
    }

	@Override
    public PhotoWorks findByUrl(String url) {
	    return dao.findOneByProperties(MapHolder.instance("url", url));
    }

	@Override
    public void save(PhotoWorks works, List<Long> styles) {
	    dao.save(works);
	    if(styles != null){
	    	styles.forEach(styleId -> {
	    		WorksToStyle old = worksToStyleDao.findOneByProperties(MapHolder.instance("style.id", styleId).put("photoWorks.id", works.getId()));
	    		if(old == null){
		    		Style style = styleDao.find(styleId);
		    		if(style != null){
		    			WorksToStyle wts = new WorksToStyle();
		    			wts.setPhotoWorks(works);
		    			wts.setStyle(style);
		    			worksToStyleDao.save(wts);
		    		}
	    		}
	    	});
	    }
    }

	@Override
    public void update(PhotoWorks works, List<Long> styles) {
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
			if(styles != null){
				// 新增的wts
				styles.forEach(styleId -> {
					WorksToStyle oldWts = worksToStyleDao.findOneByProperties(MapHolder.instance("style.id", styleId).put("photoWorks.id", works.getId()));
		    		if(oldWts == null){
			    		Style style = styleDao.find(styleId);
			    		if(style != null){
			    			WorksToStyle wts = new WorksToStyle();
			    			wts.setPhotoWorks(old);
			    			wts.setStyle(style);
			    			worksToStyleDao.save(wts);
			    		}
		    		}
				});
				// 删除的wts
				List<WorksToStyle> wtsList = worksToStyleDao.findByProperties(MapHolder.instance("photoWorks.id", old.getId()));
				if(!CollectionUtils.isEmpty(wtsList)){
					wtsList.forEach(wts -> {
						if(styles != null && !CollectionUtils.containsInstance(styles, wts.getStyle().getId())){
							worksToStyleDao.delete(wts.getId());
						}
					});
				}
			}
		}
    }
	
	
}
