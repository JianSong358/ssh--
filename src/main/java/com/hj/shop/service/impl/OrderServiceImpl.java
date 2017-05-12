package main.java.com.hj.shop.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.java.com.hj.shop.dao.OrderDao;
import main.java.com.hj.shop.entity.Order;
import main.java.com.hj.shop.entity.OrderItem;
import main.java.com.hj.shop.service.OrderService;
import main.java.com.hj.shop.utils.PageBean;

/*8
 * 订单模块业务逻辑层接口实现类
 */
@Transactional  //开启事务
public class OrderServiceImpl implements OrderService {

	//注入OrderDao
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	
	/**
	 * 保存订单
	 * @param order 要保存的订单对象
	 */
	@Override
	public void save(Order order) {
		orderDao.save(order);
	}
	
	
	/**
	 * 根据用户 的id查询所有的订单，分页
	 * @param uid 用户的id
	 * @param currentPage 分布的当前页数
	 * @return 查询到的页面信息封装
	 */
	@Override
	public PageBean<Order> findByUid(Integer uid, Integer currentPage) {
		//创建一个PageBean对象
		PageBean<Order> pb = new PageBean<Order>();
		//设置当前页
		pb.setCurrentPage(currentPage);
		//设置每页显示的记录数
		Integer limit = 6;
		pb.setLimit(limit);
		//设置总的记录数
		Integer totalCount = 0;
		totalCount =orderDao.findByCountUid(uid);
		pb.setTotalCount(totalCount);
		
		//设置总页数
		Integer totalPage=0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=(totalCount/limit)+1;
		}
		pb.setTotalPage(totalPage);
		
		//设置每页显示的数据集合
		Integer begin = (currentPage-1)*limit;
		List<Order> list = orderDao.findByPageUid(uid,begin,limit);
		pb.setList(list);
		
		return pb;
	}
	
	
	/**
	 * 根据订单的id查询订单
	 * @param oid 要查询的订单id
	 * @return 查询到的订单对象
	 */
	@Override
	public Order findByOid(Integer oid) {
		
		return orderDao.findByOid(oid);
	}
	
	
	
	/**
	 * 修改订单
	 * @param order 要修改的订单对象
	 */
	@Override
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}
	
	
	/**
	 * 带分页查询所有的订单
	 * @param currentPage
	 * @return
	 */
	@Override
	public PageBean<Order> findByPage(Integer currentPage) {
		PageBean<Order> pb = new PageBean<Order>();
		pb.setCurrentPage(currentPage);
		
		Integer limit = 20;
		pb.setLimit(limit);
		
		Integer totalCount = orderDao.findByCount();
		pb.setTotalCount(totalCount);
		
		Integer totalPage = 0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=(totalCount/limit)+1;
		}
		pb.setTotalPage(totalPage);
		
		Integer begin = (currentPage-1)*limit;
		List<Order> list = orderDao.findByList(begin,currentPage);
		pb.setList(list);
		return pb;
	}
	
	
	
	/**
	 * 带分页查询指定状态的订单
	 * @param currentPage当前页
	 * @param state 订单的状态
	 * @return
	 */
	@Override
	public PageBean<Order> findByState(Integer currentPage, Integer state) {
		PageBean<Order> pb = new PageBean<Order>();
		pb.setCurrentPage(currentPage);
		
		Integer limit = 20;
		pb.setLimit(limit);
		
		Integer totalCount = orderDao.findByCount();
		pb.setTotalCount(totalCount);
		
		Integer totalPage = 0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=(totalCount/limit)+1;
		}
		pb.setTotalPage(totalPage);
		
		Integer begin = (currentPage-1)*limit;
		List<Order> list = orderDao.findByStateList(begin,currentPage,state);
		pb.setList(list);
		return pb;
	}
	
	
	
	/**
	 * 根据订单id查询订单项
	 * @param oid
	 * @return
	 */
	@Override
	public List<OrderItem> findByOrderItem(Integer oid) {
		// TODO Auto-generated method stub
		return orderDao.findByOrderItem(oid);
	}
}
