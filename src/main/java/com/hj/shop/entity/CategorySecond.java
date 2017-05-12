package main.java.com.hj.shop.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 二级分类的实体类
 * @author hj
 *
 */
public class CategorySecond implements Serializable {

	private Integer csid;
	private String csname;
	
	//外键：所属的一级分类
	private Category category;
	
	//二级分类下面的所有商品
	private Set<Product> productSet = new HashSet<Product>();
	

	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
