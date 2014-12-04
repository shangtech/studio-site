package net.shangtech.studio.service;

import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.framework.service.IBaseService;
import net.shangtech.studio.entity.Appointment;

public interface IAppointmentService extends IBaseService<Appointment> {
	
	Pagination<Appointment> findBySpecial(Long special, Pagination<Appointment> pagination);
	
	Pagination<Appointment> findByPhotographer(Long photographer, Pagination<Appointment> pagination);

}
