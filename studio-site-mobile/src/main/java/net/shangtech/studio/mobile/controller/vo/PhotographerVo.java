package net.shangtech.studio.mobile.controller.vo;

import java.io.Serializable;

public class PhotographerVo implements Serializable {

    private static final long serialVersionUID = 4623495765943426162L;
    
	private String url;
	
	private String f_url;
	
	private String order_count;
	
	private String shotfeeoneday;
	
	private String usersdesc;
	
	private String usersname;
	
	private String year;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getF_url() {
		return f_url;
	}

	public void setF_url(String f_url) {
		this.f_url = f_url;
	}

	public String getOrder_count() {
		return order_count;
	}

	public void setOrder_count(String order_count) {
		this.order_count = order_count;
	}

	public String getShotfeeoneday() {
		return shotfeeoneday;
	}

	public void setShotfeeoneday(String shotfeeoneday) {
		this.shotfeeoneday = shotfeeoneday;
	}

	public String getUsersdesc() {
		return usersdesc;
	}

	public void setUsersdesc(String usersdesc) {
		this.usersdesc = usersdesc;
	}

	public String getUsersname() {
		return usersname;
	}

	public void setUsersname(String usersname) {
		this.usersname = usersname;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
