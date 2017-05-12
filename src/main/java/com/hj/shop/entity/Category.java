package main.java.com.hj.shop.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 一级分类的实体类对象
 * @author hj
 *
 */
public class Category implements Serializable {

	private Integer cid;
	private String cname;

	//一级分类下所有的二级分类
	private Set<CategorySecond> categorySecondSet = new HashSet<CategorySecond>();
	
	public Set<CategorySecond> getCategorySecondSet() {
		return categorySecondSet;
	}
	public void setCategorySecondSet(Set<CategorySecond> categorySecondSet) {
		this.categorySecondSet = categorySecondSet;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	
}
