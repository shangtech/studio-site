package net.shangtech.studio.dao.impl;

import net.shangtech.framework.dao.hibernate.BaseDao;
import net.shangtech.studio.dao.IAppointmentDao;
import net.shangtech.studio.entity.Appointment;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentDao extends BaseDao<Appointment> implements IAppointmentDao {

}
