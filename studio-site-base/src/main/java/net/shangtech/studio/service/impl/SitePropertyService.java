package net.shangtech.studio.service.impl;

import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.service.ISitePropertyService;
import net.shangtech.studio.entity.SiteProperty;
import net.shangtech.studio.dao.ISitePropertyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SitePropertyService extends BaseService<SiteProperty> implements ISitePropertyService {

	@Autowired private ISitePropertyDao dao;


}
