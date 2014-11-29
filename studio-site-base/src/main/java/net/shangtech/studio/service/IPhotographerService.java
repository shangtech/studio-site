package net.shangtech.studio.service;

import org.springframework.transaction.annotation.Transactional;

import net.shangtech.framework.service.IBaseService;
import net.shangtech.studio.entity.Photographer;

@Transactional
public interface IPhotographerService extends IBaseService<Photographer> {

}
