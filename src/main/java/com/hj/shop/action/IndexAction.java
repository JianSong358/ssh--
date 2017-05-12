package main.java.com.hj.shop.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import main.java.com.hj.shop.entity.Category;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.service.CategoryService;
import main.java.com.hj.shop.service.ProductService;

/**
 * 访问首页的Action
 * @author Administrator
 *
 */
public class IndexAction extends ActionSupport {

	//注入一级分类的categoryService
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//注入商品的productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	@Override
	public String execute() throws Exception {
		//进入首页时查询一级分类
		//调用categoryService层处理查询一级分类
		List<Category> cList =categoryService.getAll();
		//将查询到的结果放入Session
		ActionContext.getContext().getSession().put("cList", cList);
		
		//进入首页时查询热门商品
		//调用productService层处理查询热门商品
		List<Product> pList = productService.findHot();
		//将查询到的结果放入值栈中
		ActionContext.getContext().getValueStack().set("pList", pList);
		
		//进入首页时查询最新商品
		//调用productService层处理查询最新商品
		List<Product> nList = productService.findNew();
		//将查询到的结果放入值栈中
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
}
