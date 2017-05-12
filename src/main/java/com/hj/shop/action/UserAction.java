package main.java.com.hj.shop.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.User;
import main.java.com.hj.shop.service.UserService;

/**
 * 用户模块Action类
 * @author hj
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {

	//使用模型驱动获取页面的封装的数据
	private User u = new User();
	public User getModel() {
		return u;
	}
	
	//注入UserService来处理业务逻辑
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//接收验证码
	private String checkCode;
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	/**
	 * 跳转到注册页面
	 * @return
	 */
	public String toRegister(){
		
		return "toRegister";
	}
	
	/**
	 * Ajax校验用户名是否存在
	 * @throws IOException 
	 */
	public String checkName() throws IOException{
		//获取Response
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置字条编码
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//调用UserService处理业务逻辑(查询)
		User existUser =userService.findByUsernaem(u.getUsername());
		//判断用户名是否存在
		if(existUser!=null){
			//存在
			response.getWriter().write("<font color='red'>用户名已存在</font>");
		}else{
			//不存在
			response.getWriter().write("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	
	
	/**
	 * 用户注册
	 * @return
	 */
	public String register(){
		//判断验证码
		String Code =(String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		
		if(!Code.equalsIgnoreCase(checkCode)){
			addActionMessage("验证码有误");
			return "checkCodeError";
		}
		u.setRegistertime(new Date());
		userService.add(u);
		addActionMessage("注册成功，请去邮箱激活！");
		return "msg";
	}

	/**
	 * 用户激活
	 * @return
	 */
	public String active(){
		//调用UserService查询用户
		User existUser = userService.findByCode(u.getCode());
		if(existUser!=null){
			//激活码存在，激活成功
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
			addActionMessage("激活成功！");
		}else{
			//激活码不存在，激活失败
			addActionMessage("激活失败！激活码不存在");
		}
		return "msg";
	}
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	public String toLogin(){
		return "toLogin";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		//调用UserService查询用户
		User existUser =userService.login(u);
		if(existUser!=null){
			//登录成功
			//将信息存入Session
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess";
		}else {
			//登录失败
			addActionMessage("登录失败，用户名或密码有误或用户未激活"); 
			return "login";
		}
	}
	
	
	/**
	 * 用户退出，销毁Session
	 * @return
	 */
	public String quit(){
		//销毁Session
		ServletActionContext.getRequest().getSession().invalidate();
		
		return "quit";
	}
}
