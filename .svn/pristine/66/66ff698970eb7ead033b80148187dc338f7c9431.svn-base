package main.java.com.hj.shop.service.impl;

import org.springframework.transaction.annotation.Transactional;

import main.java.com.hj.shop.dao.AdminDao;
import main.java.com.hj.shop.entity.Admin;
import main.java.com.hj.shop.service.AdminService;

/**
 * 后台管理员Service接口实现类
 * @author Administrator
 *
 */
@Transactional
public class AdminServiceImpl implements AdminService {

	//注入AdminDao
	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	
	/**
	 * 后台管理员登录
	 * @param admin 登录的信息封闭对象
	 * @return 返回查询 到的对象   没有则返回null
	 */
	@Override
	public Admin login(Admin admin) {
		
		return adminDao.login(admin);
	}
}
