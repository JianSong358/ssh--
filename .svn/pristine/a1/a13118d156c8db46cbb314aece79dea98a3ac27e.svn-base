package main.java.com.hj.shop.entity;

import java.io.Serializable;

/**
 * 订单模块的订单项实体类
 * @author hj
 *
 */
public class OrderItem implements Serializable {

	private Integer itemid;	//订单项的id
	private Integer count;	//商品的数量
	private Double subtotal;//商品的小计
	
	//外键：商品
	private Product product;
	//外键：订单
	private Order order;
	
	
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
