package net.shangtech.studio.service.impl;

import net.shangtech.framework.service.BaseService;
import net.shangtech.studio.service.IAppointmentService;
import net.shangtech.studio.entity.Appointment;
import net.shangtech.studio.dao.IAppointmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppointmentService extends BaseService<Appointment> implements IAppointmentService {

	@Autowired private IAppointmentDao dao;


}
