package main.java.com.hj.shop.service;

import java.util.List;

import main.java.com.hj.shop.entity.CategorySecond;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 二级分类业务逻辑层接口
 * @author Administrator
 *
 */
public interface CategorySecondService {

	/**
	 * 带分布查询二级分类
	 * @return 查询到的分页对象
	 */
	public PageBean<CategorySecond> findByPage(Integer currentPage);
	
	
	/**
	 * 添加一个二级分类
	 * @param categorySecond 要添加的二级分类对象
	 */
	public void save(CategorySecond categorySecond);
	
	
	/**
	 * 根据二级分类的id查询
	 * @param csid 要查询的二级分类id
	 * @return
	 */
	public CategorySecond findByCsid(Integer csid);
	
	
	/**
	 * 删除一个二级分类
	 * @param categorySecond 要删除的二级分类
	 */
	public void delete(CategorySecond categorySecond);
	
	
	
	/**
	 * 修改一个二级分类
	 * @param categorySecond
	 */
	public void update(CategorySecond categorySecond);
	
	
	/**
	 * 查询所有的二级分类
	 * @return
	 */
	public List<CategorySecond> findAll();
}
