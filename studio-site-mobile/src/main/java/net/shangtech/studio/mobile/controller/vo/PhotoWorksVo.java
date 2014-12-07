package net.shangtech.studio.mobile.controller.vo;

import java.io.Serializable;

public class PhotoWorksVo implements Serializable {

	private static final long serialVersionUID = -6069519588174386874L;

	/** 作品名称 **/
	private String name;

	/** 拍摄地 **/
	private String address;

	/** 赞 **/
	private String hearts;

	/** 摄影师 **/
	private String author;

	/** 作品封面 **/
	private String image;

	/** 描述文字,SEO优化用的 **/
	private String description;

	/** 作品图片展 **/
	private String images;

	private String url;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

}
