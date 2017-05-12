package main.java.com.hj.shop.action.admin;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.Category;
import main.java.com.hj.shop.entity.CategorySecond;
import main.java.com.hj.shop.service.CategorySecondService;
import main.java.com.hj.shop.service.CategoryService;
import main.java.com.hj.shop.service.impl.CategorySecondServiceImpl;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 后台二级分类的管理Action
 * @author Administrator
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{

	//模型驱动接收数据 
	private CategorySecond categorySecond = new CategorySecond();
	@Override
	public CategorySecond getModel() {
		// TODO Auto-generated method stub
		return categorySecond;
	}
	
	
	//注入二级分类的categorySecondService
	private CategorySecondService categorySecondService = new CategorySecondServiceImpl();
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	
	//注入一级分类的Service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	//接收分页的当前页数
	private Integer currentPage;
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	/**
	 * 获取所有的二级分类，带分页
	 * @return
	 */
	public String findCategorySecond(){
		//调用Service查询并返回一个分页对象
		PageBean<CategorySecond> pb = categorySecondService.findByPage(currentPage);
		//将分布对象存入值栈中
		ActionContext.getContext().getValueStack().set("pb", pb);
		return "findCategorySecond";
	}
	
	
	
	/**
	 * 查询所属一级分类的数据并跳转到添加二级分类页面
	 */
	public String addCategorySecond(){
		//调用一级分类的Service查询所有的一级分类
		List<Category> cList = categoryService.getAll();
		//将集合存入值栈中
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addCategorySecond";
	}
	
	
	/**
	 * 添加一个二级分类
	 * @return
	 */
	public String save(){
		categorySecondService.save(categorySecond);
		return "save";
	}
	
	
	/**
	 * 删除一个二级分类
	 * @return
	 */
	public String delete(){
		//查询要删除的二级分类
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//删除
		categorySecondService.delete(categorySecond);
		return "delete";
	}
	
	
	/**
	 * 查询数量并跳转到编辑页面
	 * @return
	 */
	public String edit(){
		//查询二级分类
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//查询所有的一级分类
		List<Category> cList = categoryService.getAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		
		return "edit";
	}
	
	
	/**
	 * 修改二级分类
	 * @return
	 */
	public String update(){
		categorySecondService.update(categorySecond);
		return "update";
	}
	

}
