package net.shangtech.studio.service.impl;

import net.shangtech.framework.dao.support.MapHolder;
import net.shangtech.framework.dao.support.Pagination;
import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.dao.IAppointmentDao;
import net.shangtech.studio.entity.Appointment;
import net.shangtech.studio.entity.Appointment.AppointmentType;
import net.shangtech.studio.service.IAppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppointmentService extends BaseService<Appointment> implements IAppointmentService {

	@Autowired private IAppointmentDao dao;

	@Override
    public Pagination<Appointment> findBySpecial(Long special, Pagination<Appointment> pagination) {
		MapHolder<String> holder = MapHolder.instance("appointmentType", AppointmentType.ACTIVITY.name());
		if(special != null){
			holder.put("purpose", special);
		}
	    return dao.findPageByProperties(holder, "createTime desc", pagination);
    }

	@Override
    public Pagination<Appointment> findByPhotographer(Long photographer, Pagination<Appointment> pagination) {
		MapHolder<String> holder = MapHolder.instance("appointmentType", AppointmentType.PHOTOGRAPHER.name());
		if(photographer != null){
			holder.put("purpose", photographer);
		}
		return dao.findPageByProperties(holder, "createTime desc", pagination);
    }


}
