package net.shangtech.studio.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.shangtech.framework.dao.support.BaseEntity;

@Entity
@Table(name = "t_style")
public class Style extends BaseEntity<Long> {

    private static final long serialVersionUID = 7748210071977567945L;
    
    private String name;
    
    private String description;
    
    private Integer sort;
    
    private String memo;
    
    private String url;
    
    @OneToMany(mappedBy = "style", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, targetEntity = WorksToStyle.class)
    private Set<WorksToStyle> worksToStyleSet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
