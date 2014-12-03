package net.shangtech.studio.service.impl;

import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.service.IPhotographerService;
import net.shangtech.studio.entity.Photographer;
import net.shangtech.studio.dao.IPhotographerDao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class PhotographerService extends BaseService<Photographer> implements IPhotographerService {

	@Autowired private IPhotographerDao dao;

	@Override
	@Transactional
	public void update(Photographer photographer){
		Assert.notNull(photographer, "photographer can not be null");
		Assert.notNull(photographer.getId(), "photographer.id can not be null");
		Photographer old = dao.find(photographer.getId());
		Assert.notNull(old, "该摄影师记录不存在");
		old.setDescription(photographer.getDescription());
		old.setAppointments(photographer.getAppointments());
		old.setExperience(photographer.getExperience());
		if(StringUtils.isNotBlank(photographer.getImage())){
			old.setImage(photographer.getImage());
		}
		old.setMembers(photographer.getMembers());
		old.setName(photographer.getName());
		old.setPrice(photographer.getPrice());
		old.setSort(photographer.getSort());
		old.setUrl(photographer.getUrl());
		dao.update(old);
	}
	
}
