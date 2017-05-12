package main.java.com.hj.shop.action.admin;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.Admin;
import main.java.com.hj.shop.service.AdminService;

/**
 * 后台管理员的Admins
 * @author Administrator
 *
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	//使用模型驱动封闭对象
	private Admin admin = new Admin();
	@Override
	public Admin getModel() {
		return admin;
	}
	
	//注入AdminService
	private AdminService adminService;
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	/**
	 * 后台管理员登录
	 */
	public String login(){
		//调用Service完成业务处理
		Admin existAdmin = adminService.login(admin);
		//判断 
		if(existAdmin==null){
			//登录失败
			addActionError("登录失败，请检查用户名或密码重试");
			return "loginFail";
		}else{
			//登录成功
			//将信息存入session
			ServletActionContext.getRequest().getSession().setAttribute("existAdmin", existAdmin);
			return "loginSuccess";
		}
	}
}
