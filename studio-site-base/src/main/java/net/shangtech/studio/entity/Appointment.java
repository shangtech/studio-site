package net.shangtech.studio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_appointment")
public class Appointment extends BaseEntity<Long> {

    private static final long serialVersionUID = 3325363109461934916L;
    
    /** 手机号码 **/
    private String mobile;
    
    /** 创建时间 **/
    @Column(name = "create_time")
    private Date createTime;
    
    /** 用户IP **/
    private String ip;
    
    /** 备注 **/
    private String memo;
    
    /** 预约类型 摄影师预约,活动预约等等 **/
    @Column(name = "appointment_type")
    private String appointmentType;
    
    /** 预约意向,摄影师或者活动的ID **/
    private Long purpose;
    
    public enum AppointmentType{
    	/** 摄影师预约 **/
    	PHOTOGRAPHER,
    	
    	/** 活动预约 **/
    	ACTIVITY,
    }

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}

	public Long getPurpose() {
		return purpose;
	}

	public void setPurpose(Long purpose) {
		this.purpose = purpose;
	}

}
