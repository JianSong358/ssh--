package main.java.com.hj.shop.service;

import java.util.List;

import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 商品业务逻辑层接口
 * @author hj
 *
 */
public interface ProductService {

	/**
	 * 查询页面上的热门商品，10个
	 * @return 查询到的热门商品
	 */
	public List<Product> findHot();
	
	/**
	 * 查询页面上的最新商品，10个
	 * 
	 * @return 查询到的热门商品
	 */
	public List<Product> findNew();
	
	/**
	 * 根据商品的id查询商品信息
	 */
	public Product findByPid(Integer pid);
	
	
	/**
	 * 带分页查询所有商品
	 * @param currentPage
	 * @return
	 */
	public PageBean<Product> findByPage(Integer currentPage);
	
	
	/**
	 * 添加一个商品
	 * @param product
	 */
	public void save(Product product);
	
	
	
	/**
	 * 删除一个商品
	 * @param pid
	 */
	public void delete(Product product);
	
	
	/**
	 * 修改一个商品
	 * @param product
	 */
	public void update(Product product);
}
