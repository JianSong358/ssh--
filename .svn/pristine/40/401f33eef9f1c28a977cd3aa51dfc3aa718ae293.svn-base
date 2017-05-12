package main.java.com.hj.shop.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import main.java.com.hj.shop.dao.UserDao;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.entity.User;
import main.java.com.hj.shop.utils.PageHibernateCallback;

/**
 * 用户模块(数据访问)持久层Dao接口实现类
 * @author hj
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	/**
	 * 通过用户名查询用户
	 * @param username 要查询的用户名
	 * @return 查询到的用户 没有则返回null
	 */
	public User findByUsernaem(String username){
		String hql = "from User where username=?";
		List<User> list =(List<User>) getHibernateTemplate().find(hql, username);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 用户注册
	 * @param user 要注册的用户信息
	 */
	@Override
	public void add(User user) {
		getHibernateTemplate().save(user);
		
	}

	/**
	 * 根据激活码查询用户
	 * @param code 要查询的激活码
	 * @return 查询到的用户
	 */
	@Override
	public User findByCode(String code) {
		String hql = "from User where code=?";
		List<User> list = (List<User>) getHibernateTemplate().find(hql, code);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 更新用户信息
	 * @param existUser 更新信息的用户
	 */
	@Override
	public void update(User existUser) {
		getHibernateTemplate().update(existUser);
	}
	
	
	/**
	 * 用户登录
	 * @param u
	 */
	@Override
	public User login(User u) {
		String hql = "from User where username=? and password=? and state=?";
		List<User> list =  (List<User>) getHibernateTemplate().find(hql, u.getUsername(),u.getPassword(),1);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
	/**
	 * 查询出所有的商品个数
	 * @return
	 */
	@Override
	public Integer findByCount() {
		String hql = "select count(*) from User";
		List<Long> list = (List<Long>) getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	
	
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	@Override
	public List<User> findByList(Integer begin,Integer currentPage) {
		String hql = "from User order by uid asc";
		
		return getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, null, begin, currentPage));
	}
	
	
	/**
	 * 根据用户id查询
	 * @param uid
	 * @return
	 */
	@Override
	public User findbyUid(Integer uid) {
		
		return getHibernateTemplate().get(User.class, uid);
	}
	
	
	
	/**
	 * 删除一个用户
	 * @param user
	 */
	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}
}
