package main.java.com.hj.shop.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.User;
import main.java.com.hj.shop.service.UserService;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 后台用户管理Action
 * @author Administrator
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<User> {
	// 模型驱动使用的对象
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	// 注入AdminUserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private Integer currentPage;
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	/**
	 * 带分页查询所有的用户
	 * 
	 * @return
	 */
	public String findUser() {
		// 调用Service查询所有的用户的集合
		PageBean<User> pb  = userService.findByUser(currentPage);
		// 将信息存入值栈中
		ActionContext.getContext().getValueStack().set("pb", pb);
		return "findUser";
	}
	
	
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	public String edit(){
		user = userService.findbyUid(user.getUid());
		return "edit";
	}
	
	
	
	/**
	 * 更新用户信息
	 */
	public String update(){
		userService.update(user);
		return "update";
	}
	
	
	/**
	 * 删除一个用户
	 */
	public String delete(){
		user = userService.findbyUid(user.getUid());
		userService.delete(user);
		return "delete";
	}

}
