package main.java.com.hj.shop.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义拦截器，用户未登录跳转到登录页面
 * @author Administrator
 *
 */
public class UserInterceptor extends MethodFilterInterceptor{
	

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest req = ServletActionContext.getRequest();
		 if (req.getSession().getAttribute("existUser") == null){
			 //ActionSupport as = (ActionSupport) invocation.getAction();
			 //as.addActionMessage("请先登录");
			 return "login";
		 }else{
			 invocation.invoke();
		 }
		return null;
	}

	
	

}
