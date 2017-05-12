package main.java.com.hj.shop.dao;

import java.util.List;

import main.java.com.hj.shop.entity.Order;
import main.java.com.hj.shop.entity.OrderItem;

/**
 * 订单模块持久层Dao接口
 * @author hj
 *
 */
public interface OrderDao {

	/**
	 * 保存订单
	 * @param order 要保存的订单对象
	 */
	public void save(Order order);
	
	


	/**
	 * 根据用户的id查询用户所有订单的数量
	 * @param uid 用户的id
	 * @return
	 */
	public Integer findByCountUid(Integer uid);


	
	/**
	 * 根据用户的id查询用户所有的订单，分页
 	 * @param uid 用户的id
	 * @param begin 分页的开始
	 * @param limit 每页要显示的数量
	 * @return
	 */
	public List<Order> findByPageUid(Integer uid, Integer begin, Integer limit);
	
	
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
	 * 查询所有订单的数量
	 * @return
	 */
	public Integer findByCount();
	
	
	/**
	 * 带分页查询所有的订单
	 * @param currentPage 当前页
	 * @param begin 开始页
	 * @return 所有订单的集合
	 */
	public List<Order> findByList(Integer begin, Integer currentPage);
	
	
	/**
	 * 带分页查询指定状态的订单
	 * @param currentPage当前页
	 * @param begin 开始页
	 * @param state 订单的状态
	 * @return
	 */
	public List<Order> findByStateList(Integer begin, Integer currentPage,Integer state);
	
	
	/**
	 * 根据订单id查询订单项
	 * @param oid
	 * @return
	 */
	public List<OrderItem> findByOrderItem(Integer oid);
}
