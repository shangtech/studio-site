package net.shangtech.studio.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_works_to_style")
public class WorksToStyle extends BaseEntity<Long> {

    private static final long serialVersionUID = -291207258871667181L;

    @JoinColumn(name = "photo_works")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PhotoWorks.class)
    private PhotoWorks photoWorks;
    
    @JoinColumn(name = "style")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Style.class)
    private Style style;

	public PhotoWorks getPhotoWorks() {
		return photoWorks;
	}

	public void setPhotoWorks(PhotoWorks photoWorks) {
		this.photoWorks = photoWorks;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

}
