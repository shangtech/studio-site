package net.shangtech.studio.service.impl;

import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.service.IStyleService;
import net.shangtech.studio.entity.Style;
import net.shangtech.studio.dao.IStyleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StyleService extends BaseService<Style> implements IStyleService {

	@Autowired private IStyleDao dao;


}
