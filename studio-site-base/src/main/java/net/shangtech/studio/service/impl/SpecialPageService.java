package net.shangtech.studio.service.impl;

import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.service.ISpecialPageService;
import net.shangtech.studio.entity.SpecialPage;
import net.shangtech.studio.dao.ISpecialPageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SpecialPageService extends BaseService<SpecialPage> implements ISpecialPageService {

	@Autowired private ISpecialPageDao dao;


}
