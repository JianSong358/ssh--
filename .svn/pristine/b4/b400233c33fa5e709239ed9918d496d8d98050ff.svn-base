package main.java.com.hj.shop.action.admin;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.Order;
import main.java.com.hj.shop.entity.OrderItem;
import main.java.com.hj.shop.service.OrderService;
import main.java.com.hj.shop.utils.PageBean;

public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {

	// 用模型驱动封装数据
	private Order order = new Order();

	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}

	// 注入OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// 接收当前页数
	private Integer currentPage;

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 带分页查询所有的订单
	 * 
	 * @return
	 */
	public String findOrder() {
		// 调用OrderService查询
		PageBean<Order> pb = orderService.findByPage(currentPage);
		// 放入值栈
		ActionContext.getContext().getValueStack().set("pb", pb);
		return "findOrder";
	}

	/**
	 * 带分页查询指定状态的订单
	 * 
	 * @return
	 */
	public String findByState() {
		// 调用OrderService查询
		PageBean<Order> pb = orderService.findByState(currentPage,order.getState());
		// 放入值栈
		ActionContext.getContext().getValueStack().set("pb", pb);
		return "findOrder";
	}
	
	
	/**
	 * 跳转到订单详情页面
	 * @return
	 */
	public String detail(){
		List<OrderItem> oiList =orderService.findByOrderItem(order.getOid());
		ActionContext.getContext().getValueStack().set("oiList", oiList);
		return "detail";
	}
	
	
	/**
	 * 更新订单的状态
	 * @return
	 */
	public String updateState(){
		order = orderService.findByOid(order.getOid());
		order.setState(3);
		orderService.updateOrder(order);
		return "updateState";
	}

}
