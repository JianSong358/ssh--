package main.java.com.hj.shop.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.java.com.hj.shop.dao.CategoryDao;
import main.java.com.hj.shop.entity.Category;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.service.CategoryService;
import main.java.com.hj.shop.utils.PageBean;

@Transactional
public class CategoryServiceImpl implements CategoryService {

	// 注入categoryDao
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	/**
	 * 查询所有的一级分类
	 * @return 所有的一级分类集合
	 */
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryDao.getAll();
	}
	
	
	/**
	 * 根据一级分类的id和当前页数查询商品
	 * @param cid 一级分类的id
	 * @param currentPage 当前页数
	 * @return 查询到的分页封装类
	 */
	@Override
	public PageBean<Product> findByPageCid(Integer cid, int currentPage) {
		PageBean<Product> pb = new PageBean<Product>();
		//设置当前页数
		pb.setCurrentPage(currentPage);
		
		//设置每页显示的记录数
		int limit = 8;
		pb.setLimit(limit);
		
		//设置总记录数
		int totalCount = 0;
		totalCount = categoryDao.findByCountCid(cid);
		pb.setTotalCount(totalCount);
		
		//设置总的页数
		int totalPage =0;
		if(totalCount/limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=(totalCount/limit)+1;
		}
		pb.setTotalPage(totalPage);
		
		//设置每页显示的数据集合
		//开始
		int begin = 0;
		begin = (currentPage-1)*limit;
		
		
		List<Product> list = categoryDao.findByPageCid(cid, begin,limit);
		pb.setList(list);
		return pb;
	}
	
	
	/**
	 * 根据二级分类的id和当前页数查询商品
	 * @param csid 二级分类的id
	 * @param currentPage 当前页数
	 * @return 查询到的分页封装类
	 */
	@Override
	public PageBean<Product> findByPageCsid(Integer csid, int currentPage) {
		PageBean<Product> pb = new PageBean<Product>();
		//设置当前页数
		pb.setCurrentPage(currentPage);
		
		//设置每页显示的记录数
		int limit = 8;
		pb.setLimit(limit);
		
		//设置总记录数
		int totalCount = 0;
		totalCount = categoryDao.findByCountCsid(csid);
		pb.setTotalCount(totalCount);
		
		//设置总的页数
		int totalPage =0;
		totalPage = (int) Math.ceil(totalCount/limit);
		pb.setTotalPage(totalPage);
		
		//设置每页显示的数据集合
		//开始
		int begin = 0;
		begin = (currentPage-1)*limit;
		
		
		List<Product> list = categoryDao.findByPageCsid(csid, begin,limit);
		pb.setList(list);
		return pb;
	}
	
	
	
	/**
	 * 添加一个一级分类
	 * @param category
	 */
	@Override
	public void save(Category category) {
		categoryDao.save(category);
	}
	
	
	/**
	 * 根据一级分类的id查询该一级分类
	 * @param cid
	 * @return
	 */
	@Override
	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.findByCid(cid);
	}

	
	
	/**
	 * 删除一级分类
	 * @param cid
	 */
	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
	}
	
	
	/**
	 * 更新一个一级分类
	 * @param category
	 */
	@Override
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}
}
