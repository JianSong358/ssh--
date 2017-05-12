package main.java.com.hj.shop.service;

import java.util.List;

import main.java.com.hj.shop.dao.OrderDao;
import main.java.com.hj.shop.entity.Order;
import main.java.com.hj.shop.entity.OrderItem;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 订单模块业务逻辑层接口
 * @author hj
 *
 */
public interface OrderService {
	

	/**
	 * 保存订单
	 * @param order 要保存的订单对象
	 */
	public void save(Order order);
	
	
	/**
	 * 根据用户 的id查询所有的订单，分页
	 * @param uid 用户的id
	 * @param currentPage 分布的当前页数
	 * @return 查询到的页面信息封装
	 */
	public PageBean<Order> findByUid(Integer uid,Integer currentPage);
	
	
	/**
	 * 根据订单的id查询订单
	 * @param oid 要查询的订单id
	 * @return 查询到的订单对象
	 */
	public Order findByOid(Integer oid);
	
	
	
	/**
	 * 修改订单
	 * @param order 要修改的订单对象
	 */
	public void updateOrder(Order order);
	
	
	/**
	 * 带分页查询所有的订单
	 * @param currentPage
	 * @return
	 */
	public PageBean<Order> findByPage(Integer currentPage);
	
	
	/**
	 * 带分页查询指定状态的订单
	 * @param currentPage当前页
	 * @param state 订单的状态
	 * @return
	 */
	public PageBean<Order> findByState(Integer currentPage,Integer state);
	
	
	/**
	 * 根据订单id查询订单项
	 * @param oid
	 * @return
	 */
	public List<OrderItem> findByOrderItem(Integer oid);
}
