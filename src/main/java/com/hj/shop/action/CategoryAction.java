package main.java.com.hj.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.Category;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.service.CategoryService;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 一级分类Action
 * 
 * @author hj
 *
 */
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {

	// 通过模型驱动获取页面封装的一级分类信息
	private Category category = new Category();

	@Override
	public Category getModel() {
		return category;
	}

	// 注入一级分类的categoryServoce
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// 接收页面传递的二级分类的id
	private Integer csid;

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public Integer getCsid() {
		return csid;
	}

	// 接收页面传递的当前页数
	private int currentPage;

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * 根据一级分类的id查询所有商品
	 * 
	 * @return
	 */
	public String findByCid() {
		// 因为之前已经查询了所有的一级分类并把它放入Session了，所以这直接跳转到页面中在Session里拿cList

		// 通过一级分类查询商品，带分页
		PageBean<Product> pb = categoryService.findByPageCid(category.getCid(), currentPage);

		// 将PageBean对象存入值栈中
		ActionContext.getContext().getValueStack().set("pb", pb);
		return "findByCid";
	}

	/**
	 * 根据二级分类的id查询所有商品
	 * 
	 * @return
	 */
	public String findByCsid() {
		// 通过二级分类查询商品，带分页
		PageBean<Product> pb = categoryService.findByPageCsid(csid, currentPage);

		// 将PageBean对象存入值栈中
		ActionContext.getContext().getValueStack().set("pb", pb);
		return "findByCsid";
	}
}
