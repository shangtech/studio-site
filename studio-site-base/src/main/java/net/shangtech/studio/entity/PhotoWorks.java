package net.shangtech.studio.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_photo_works")
public class PhotoWorks extends BaseEntity<Long> {

    private static final long serialVersionUID = -6069519588174386874L;
    
    /** 作品名称 **/
    private String name;
    
    /** 拍摄地 **/
    private String address;
    
    /** 赞 **/
    private String hearts;
    
    /** 摄影师ID **/
    private Long author;
    
    @Transient
    private Photographer photographer;
    
    /** 作品封面 **/
    private String image;
    
    /** 描述文字,SEO优化用的 **/
    private String description;
    
    /** 作品图片展 **/
    private String images;
    
    private String url;
    
    @OneToMany(mappedBy = "photoWorks", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, targetEntity = WorksToStyle.class)
    private Set<WorksToStyle> worksToStyleSet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHearts() {
		return hearts;
	}

	public void setHearts(String hearts) {
		this.hearts = hearts;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<WorksToStyle> getWorksToStyleSet() {
		return worksToStyleSet;
	}

	public void setWorksToStyleSet(Set<WorksToStyle> worksToStyleSet) {
		this.worksToStyleSet = worksToStyleSet;
	}

}
