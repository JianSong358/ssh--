package main.java.com.hj.shop.dao;

import java.util.List;

import main.java.com.hj.shop.entity.Product;

/**
 * 商品持久层Dao接口
 * @author hj
 *
 */
public interface ProductDao {

	/**
	 * 查询页面上的热门商品，10个
	 * @return 查询到的热门商品
	 */
	public List<Product> findHot();
	
	/**
	 * 查询页面上的最新商品，10个
	 * @return 查询到的热门商品
	 */
	public List<Product> findNew();
	
	/**
	 * 根据商品的id查询商品信息
	 */
	public Product findByPid(Integer pid);
	
	
	/**
	 * 查询出所有的商品个数
	 * @return
	 */
	public Integer findByCount();
	
	
	/**
	 * 带分页查询所有的商品
	 * @return
	 */
	public List<Product> findByList(Integer begin,Integer currentPage);
	
	
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
