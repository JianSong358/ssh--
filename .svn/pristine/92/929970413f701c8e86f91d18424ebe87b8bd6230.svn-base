package main.java.com.hj.shop.action.admin;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.Category;
import main.java.com.hj.shop.service.CategoryService;

/**
 * 后台一级分类管理操作的Action
 * @author Administrator
 *
 */
public class AdminCategoryAction implements ModelDriven<Category>{

	//模型驱动封装一级分类对象信息
	private Category category = new Category();
	@Override
	public Category getModel() {
		return category;
	}
	
	//由于是对一级分类的操作，所有要注入一级分类的Service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	/**
	 * 查询 出所有的一级分类
	 * @return
	 */
	public String findCategory(){
		//调用CategoryService查询所有的一级分类的集合
		List<Category> cList = categoryService.getAll();
		//将信息存入值栈中
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "getAll";
	}
	
	
	/**
	 * 添加一级分类
	 * @return
	 */
	public String save(){
		categoryService.save(category);
		return "save";
	}
	
	
	/**
	 * 删除一个一级分类
	 * @return
	 */
	public String delete(){
		Category existCategory = categoryService.findByCid(category.getCid());
		categoryService.delete(existCategory);
		return "delete";
	}
	
	
	
	/**
	 * 跳转到编辑一级分类页面
	 */
	public String edit(){
		//通过页面传递的id查询该一级分类
		category = categoryService.findByCid(category.getCid());
		return "edit";
	}
	
	
	/**
	 * 更新一级分类
	 */
	public String update(){
		categoryService.updateCategory(category);
		return "update";
	}
}
