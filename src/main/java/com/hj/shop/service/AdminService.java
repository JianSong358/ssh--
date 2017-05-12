package main.java.com.hj.shop.service;

import main.java.com.hj.shop.entity.Admin;

/**
 * 后台管理员Service接口
 * @author Administrator
 *
 */
public interface AdminService {

	/**
	 * 后台管理员登录
	 * @param admin 登录的信息封闭对象
	 * @return 返回查询 到的对象   没有则返回null
	 */
	public Admin login(Admin admin);
}
