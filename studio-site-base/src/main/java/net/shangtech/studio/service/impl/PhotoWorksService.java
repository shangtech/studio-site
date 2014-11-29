package net.shangtech.studio.service.impl;

import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.service.IPhotoWorksService;
import net.shangtech.studio.entity.PhotoWorks;
import net.shangtech.studio.dao.IPhotoWorksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PhotoWorksService extends BaseService<PhotoWorks> implements IPhotoWorksService {

	@Autowired private IPhotoWorksDao dao;


}
