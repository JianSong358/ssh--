package main.java.com.hj.shop.dao;

import java.util.List;

import main.java.com.hj.shop.entity.Category;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 一级分类持久层Dao接口
 * @author hj
 *
 */
public interface CategoryDao {

	/**
	 * 查询所有的一级分类
	 * @return 所有的一级分类集合
	 */
	public List<Category> getAll();

	
	/**
	 * 根据一级分类的id查询商品的总个数
	 * @param cid 一级分类的id
	 * @return
	 */
	public int findByCountCid(Integer cid);
	
	
	/**
	 * 根据一级分类的id和当前页数查询商品
	 * @param cid 一级分类的id
	 * @param currentPage 当前页数
	 * @return 查询到的分页封装类
	 */
	public List<Product> findByPageCid(Integer cid,int begin,int limit);
	
	
	/**
	 * 根据二级分类的id查询商品的总个数
	 * @param cid 二级分类的id
	 * @return
	 */
	public int findByCountCsid(Integer csid);
	
	
	/**
	 * 根据二级分类的id和当前页数查询商品
	 * @param csid 二级分类的id
	 * @param currentPage 当前页数
	 * @return 查询到的分页封装类
	 */
	public List<Product> findByPageCsid(Integer csid,int begin,int limit);
	
	
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
