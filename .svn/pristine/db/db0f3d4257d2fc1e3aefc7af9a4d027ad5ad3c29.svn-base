package main.java.com.hj.shop.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 自定义拦截器，后台管理员未登录跳转到登录页面
 * @author Administrator
 *
 */
public class AdminInterceptor implements Interceptor{
	


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		 if (req.getSession().getAttribute("existAdmin") == null){
			 return "loginFial";
		 }else{
			 invocation.invoke();
		 }
		return null;
	}

	
	

}
