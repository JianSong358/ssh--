package main.java.com.hj.shop.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import main.java.com.hj.shop.dao.OrderDao;
import main.java.com.hj.shop.entity.Order;
import main.java.com.hj.shop.entity.OrderItem;
import main.java.com.hj.shop.utils.PageBean;
import main.java.com.hj.shop.utils.PageHibernateCallback;

/**
 * 订单模块Dao接口实现类
 * @author hj
 *
 */
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	
	/**
	 * 保存订单
	 * @param order 要保存的订单对象
	 */
	@Override
	public void save(Order order) {
		getHibernateTemplate().save(order);
	}
	
	
	
	
	/**
	 * 根据用户的id查询用户所有订单的数量
	 * @param uid 用户的id
	 * @return
	 */
	@Override
	public Integer findByCountUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid=?";
		List<Long> list = (List<Long>)getHibernateTemplate().find(hql, uid);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	
	
	/**
	 * 根据用户的id查询用户所有的订单，分页
 	 * @param uid 用户的id
	 * @param begin 分页的开始
	 * @param limit 每页要显示的数量
	 * @return
	 */
	@Override
	public List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
		String hql = "from Order o where o.user.uid=? order by ordertime desc";
		List<Order> list = getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}


	/**
	 * 根据订单的id查询订单
	 * @param oid 要查询的订单id
	 * @return 查询到的订单对象
	 */
	@Override
	public Order findByOid(Integer oid) {
		Order order = getHibernateTemplate().get(Order.class, oid);
		return order;
	}
	
	
	/**
	 * 修改订单
	 * @param order 要修改的订单对象
	 */
	@Override
	public void updateOrder(Order order) {
		getHibernateTemplate().update(order);
		
	}
	
	
	/**
	 * 查询所有订单的数量
	 * @return
	 */
	@Override
	public Integer findByCount() {
		String hql = "select count(*) from Order";
		List<Long> list = (List<Long>) getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	
	/**
	 * 带分页查询所有的订单
	 * @param currentPage 当前页
	 * @param begin 开始页
	 * @param limit 结束页
	 * @return 所有订单的集合
	 */
	@Override
	public List<Order> findByList(Integer begin, Integer currentPage) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, null, begin, currentPage));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	
	
	/**
	 * 带分页查询指定状态的订单
	 * @param currentPage当前页
	 * @param begin 开始页
	 * @param state 订单的状态
	 * @return
	 */
	@Override
	public List<Order> findByStateList(Integer begin, Integer currentPage, Integer state) {
		String hql = "from Order o where o.state=?  order by ordertime desc";
		List<Order> list = getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{state}, begin, currentPage));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	
	
	/**
	 * 根据订单id查询订单项
	 * @param oid
	 * @return
	 */
	@Override
	public List<OrderItem> findByOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid=?";
		List<OrderItem> list =(List<OrderItem>) getHibernateTemplate().find(hql, oid);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

}
