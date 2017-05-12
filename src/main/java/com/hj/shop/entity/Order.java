package main.java.com.hj.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 订单模块实体类
 * @author hj
 *
 */
public class Order implements Serializable {

	private Integer oid;	//订单id
	private Double total;	//订单总金额
	private Date ordertime;	//订单创建的时间
	private Integer state;	//订单的状态
	private String addr;	//订单收货地址
	private String name;	//订单收货人性名
	private String phone;	//订单收货人电话
	
	//外键：订单所属的用户
	//多对一
	private User user;
	
	//订单中的多个订单项
	//一对多
	private Set<OrderItem> orderItemSet = new HashSet<OrderItem>();
	

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double d) {
		this.total = d;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getOrderItemSet() {
		return orderItemSet;
	}

	public void setOrderItemSet(Set<OrderItem> orderItemSet) {
		this.orderItemSet = orderItemSet;
	}
	
	
}
