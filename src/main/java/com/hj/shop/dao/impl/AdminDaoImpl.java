package main.java.com.hj.shop.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import main.java.com.hj.shop.dao.AdminDao;
import main.java.com.hj.shop.entity.Admin;

/**
 * 后台管理员Dao接口实现类
 * @author Administrator
 *
 */
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	/**
	 * 后台管理员登录
	 * @param admin 登录的信息封闭对象
	 * @return 返回查询 到的对象   没有则返回null
	 */
	@Override
	public Admin login(Admin admin) {
		String hql = "from Admin where adminname=? and password=?";
		List<Admin> list = (List<Admin>) getHibernateTemplate().find(hql, admin.getAdminname(),admin.getPassword());
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
