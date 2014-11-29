package net.shangtech.studio.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_photographer")
public class Photographer extends BaseEntity<Long> {

    private static final long serialVersionUID = -6426639068793788793L;

    /** 摄影师姓名 **/
    private String name;
    
    /** 摄影师照片 **/
    private String image;
    
    /** 预约次数 **/
    private String appointments;
    
    /** 服务价格 **/
    private String price;
    
    /** 服务人员（化妆师灯光师等等） **/
    private String members;
    
    /** 从业年限 **/
    private String experience;
    
    /** 简介 **/
    private String description;
    
    /** 排序 **/
    private Integer sort;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAppointments() {
		return appointments;
	}

	public void setAppointments(String appointments) {
		this.appointments = appointments;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
    
}
