package main.java.com.hj.shop.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.java.com.hj.shop.dao.UserDao;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.entity.User;
import main.java.com.hj.shop.service.UserService;
import main.java.com.hj.shop.utils.MailUtils;
import main.java.com.hj.shop.utils.PageBean;
import main.java.com.hj.shop.utils.UUIDUtils;

/**
 * 用户模块业务逻辑层接口实现类
 * 
 * @author hj
 *
 */

@Transactional  //开启事务
public class UserServiceImpl implements UserService{

	// 注入Dao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 通过用户名查询用户
	 * 
	 * @param username
	 *            要查询的用户名
	 * @return 查询到的用户 没有则返回null
	 */
	public User findByUsernaem(String username) {
		return userDao.findByUsernaem(username);
	}

	/**
	 * 用户注册
	 * @param user 要注册的用户信息
	 */
	@Override
	public void add(User user) {
		//设置状态码，0:未激活，1：已激活
		user.setState(0);
		
		//设置激活码
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		
		//调用UserDao把数据存入数据库
		userDao.add(user);
		
		//给注册的用户发送激活邮件
		MailUtils.sendMail(user.getEmail(), code);
		//System.out.println(user.getEmail());
	}

	/**
	 * 根据激活码查询用户
	 * @param code 要查询的激活码
	 * @return 查询到的用户
	 */
	@Override
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}
	
	
	/**
	 * 更新用户信息
	 * @param existUser 更新信息的用户
	 */
	@Override
	public void update(User existUser) {
		userDao.update(existUser);
	}
	
	
	/**
	 * 用户登录
	 * @param u
	 */
	@Override
	public User login(User u) {
		return userDao.login(u);
	}
	
	
	/**
	 * 带分页查询所有的用户
	 * @return
	 */
	@Override
	public PageBean<User> findByUser(Integer currentPage) {
		PageBean<User> pb = new PageBean<User>();
		
		pb.setCurrentPage(currentPage);
		
		Integer limit = 10;
		pb.setLimit(limit);
		
		Integer totalCount = userDao.findByCount();
		pb.setTotalCount(totalCount);
		
		Integer totalPage =0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=(totalCount/limit)+1;
		}
		pb.setTotalPage(totalPage);
		
		Integer begin = (currentPage-1)*limit;
		List<User> list = userDao.findByList(begin,limit);
		pb.setList(list);
		return pb;
	}
	
	
	/**
	 * 根据用户id查询
	 * @param uid
	 * @return
	 */
	@Override
	public User findbyUid(Integer uid) {
		// TODO Auto-generated method stub
		return userDao.findbyUid(uid);
	}
	
	
	
	/**
	 * 删除一个用户
	 * @param user
	 */
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
}
