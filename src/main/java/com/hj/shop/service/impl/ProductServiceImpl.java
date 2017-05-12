package main.java.com.hj.shop.service.impl;

import java.util.List;

import main.java.com.hj.shop.dao.ProductDao;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.service.ProductService;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 商品业务逻辑层实现类
 * @author hj
 *
 */
public class ProductServiceImpl implements ProductService {

	//注入ProductDao
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	/**
	 * 查询页面上的热门商品，10个
	 * @return 查询到的热门商品
	 */
	@Override
	public List<Product> findHot() {
		
		return productDao.findHot();
	}
	
	/**
	 * 查询页面上的最新商品，10个
	 * 
	 * @return 查询到的热门商品
	 */
	@Override
	public List<Product> findNew() {
		
		return productDao.findNew();
	}
	
	/**
	 * 根据商品的id查询商品信息
	 */
	@Override
	public Product findByPid(Integer pid) {
		
		return productDao.findByPid(pid);
	}
	
	
	
	/**
	 * 带分页查询所有商品
	 * @param currentPage
	 * @return
	 */
	@Override
	public PageBean<Product> findByPage(Integer currentPage) {
		PageBean<Product> pb = new PageBean<Product>();
		
		pb.setCurrentPage(currentPage);
		
		Integer limit = 10;
		pb.setLimit(limit);
		
		Integer totalCount = productDao.findByCount();
		pb.setTotalCount(totalCount);
		
		Integer totalPage =0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=(totalCount/limit)+1;
		}
		pb.setTotalPage(totalPage);
		
		Integer begin = (currentPage-1)*limit;
		List<Product> list = productDao.findByList(begin,limit);
		pb.setList(list);
		return pb;
	}
	
	
	
	
	/**
	 * 添加一个商品
	 * @param product
	 */
	@Override
	public void save(Product product) {
		productDao.save(product);
	}
	
	
	
	/**
	 * 删除一个商品
	 * @param pid
	 */
	@Override
	public void delete(Product product) {
		productDao.delete(product);
	}
	
	
	/**
	 * 修改一个商品
	 * @param product
	 */
	@Override
	public void update(Product product) {
		productDao.update(product);
	}
}
