package net.shangtech.studio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_special_page")
public class SpecialPage extends BaseEntity<Long> {

    private static final long serialVersionUID = 8826927132005200862L;
    
    /** 页面名称 **/
    private String name;
    
    /** 页面标题 **/
    @Column(name = "page_title")
    private String pageTitle;
    
    /** 页面URL **/
    private String url;
    
    /** 页面关键词 **/
    @Column(name = "page_key_words")
    private String pageKeyWords;
    
    /** 页面描述 **/
    @Column(name = "page_description")
    private String pageDescription;
    
    /** 页面内容 **/
    @Column(name = "page_content")
    private String pageContent;
    
    /** 是否显示预约按钮 **/
    @Column(name = "show_appointment")
    private Boolean showAppointment;
    
    /** 是否显示联系电话按钮 **/
    @Column(name = "show_tel")
    private Boolean showTel;
    
    /** 是否在首页显示 **/
    @Column(name = "show_index")
    private Boolean showIndex;
    
    /** 封面图 **/
    private String image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageDescription() {
		return pageDescription;
	}

	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}

	public String getPageContent() {
		return pageContent;
	}

	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}

	public Boolean getShowAppointment() {
		return showAppointment;
	}

	public void setShowAppointment(Boolean showAppointment) {
		this.showAppointment = showAppointment;
	}

	public Boolean getShowTel() {
		return showTel;
	}

	public void setShowTel(Boolean showTel) {
		this.showTel = showTel;
	}

	public String getPageKeyWords() {
		return pageKeyWords;
	}

	public void setPageKeyWords(String pageKeyWords) {
		this.pageKeyWords = pageKeyWords;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(Boolean showIndex) {
		this.showIndex = showIndex;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
