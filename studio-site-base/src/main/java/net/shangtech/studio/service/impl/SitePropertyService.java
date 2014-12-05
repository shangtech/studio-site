package net.shangtech.studio.service.impl;

import java.util.List;

import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.service.ISitePropertyService;
import net.shangtech.studio.entity.SiteProperty;
import net.shangtech.studio.dao.ISitePropertyDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class SitePropertyService extends BaseService<SiteProperty> implements ISitePropertyService {

	@Autowired private ISitePropertyDao dao;

	@Override
	public void save(List<SiteProperty> list) {
		Assert.notNull(list, "can not save null list");
		list.forEach(property -> {
			if(property.getId() != null){
				SiteProperty old = dao.find(property.getId());
				if(old != null){
					old.setPropertyValue(property.getPropertyValue());
					old.setPropertyCode(property.getPropertyCode());
					dao.update(old);
				}
			}
			else{
				dao.save(property);
			}
		});
	}

}
