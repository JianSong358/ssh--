package main.java.com.hj.shop.service;

import java.util.List;

import main.java.com.hj.shop.entity.Category;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 一级分类业务逻辑层接口
 * @author hj
 *
 */
public interface CategoryService {

	/**
	 * 查询所有的一级分类
	 * @return 所有的一级分类集合
	 */
	public List<Category> getAll();

	
	/**
	 * 根据一级分类的id和当前页数查询商品
	 * @param cid 一级分类的id
	 * @param currentPage 当前页数
	 * @return 查询到的分页封装类
	 */
	public PageBean<Product> findByPageCid(Integer cid,int currentPage);
	
	
	/**
	 * 根据二级分类的id和当前页数查询商品
	 * @param csid 二级分类的id
	 * @param currentPage 当前页数
	 * @return 查询到的分页封装类
	 */
	public PageBean<Product> findByPageCsid(Integer csid,int currentPage);
	
	
	/**
	 * 添加一个一级分类
	 * @param category
	 */
	public void save(Category category);
	
	
	
	/**
	 * 删除一级分类
	 * @param cid
	 */
	public void delete(Category category);
	
	
	/**
	 * 根据一级分类的id查询该一级分类
	 * @param cid
	 * @return
	 */
	public Category findByCid(Integer cid);
	
	
	
	/**
	 * 更新一个一级分类
	 * @param category
	 */
	public void updateCategory(Category category);
}
