package main.java.com.hj.shop.dao;

import java.util.List;

import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.entity.User;
import main.java.com.hj.shop.utils.PageHibernateCallback;

/**
 * 用户模块(数据访问)持久层Dao接口
 * @author hj
 *
 */
public interface UserDao{

	/**
	 * 通过用户名查询用户
	 * @param username 要查询的用户名
	 * @return 查询到的用户 没有则返回null
	 */
	public User findByUsernaem(String username);
	
	/**
	 * 用户注册
	 * @param user 要注册的用户信息
	 */
	public void add(User user);

	/**
	 * 根据激活码查询用户
	 * @param code 要查询的激活码
	 * @return 查询到的用户
	 */
	public User findByCode(String code);

	
	/**
	 * 更新用户信息
	 * @param existUser 更新信息的用户
	 */
	public void update(User existUser);

	
	/**
	 * 用户登录
	 * @param u
	 */
	public User login(User u);
	
	
	/**
	 * 查询出所有的用户个数
	 * @return
	 */
	public Integer findByCount();
	
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User> findByList(Integer begin,Integer currentPage);
	
	
	/**
	 * 根据用户id查询
	 * @param uid
	 * @return
	 */
	public User findbyUid(Integer uid);
	
	
	/**
	 * 删除一个用户
	 * @param user
	 */
	public void delete(User user);
}
