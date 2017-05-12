package main.java.com.hj.shop.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import main.java.com.hj.shop.dao.CategorySecondDao;
import main.java.com.hj.shop.dao.impl.CategorySecondDaoImpl;
import main.java.com.hj.shop.entity.CategorySecond;
import main.java.com.hj.shop.service.CategorySecondService;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 二级分类业务逻辑层接口实现类
 * @author Administrator
 *
 */
@Transactional
public class CategorySecondServiceImpl implements CategorySecondService {

	//注入Dao
	private CategorySecondDao categorySecondDao = new CategorySecondDaoImpl();
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	
	
	/**
	 * 带分布查询二级分类
	 * @return 查询到的分页对象
	 */
	@Override
	public PageBean<CategorySecond> findByPage(Integer currentPage) {
		//创建一个分页对象
		PageBean<CategorySecond> pb = new PageBean<CategorySecond>();
		//设置当前页数
		pb.setCurrentPage(currentPage);
		//设置每页显示的数
		Integer limit = 10;
		pb.setLimit(limit);
		//设置总的记录数
		Integer totalCount = categorySecondDao.findByCount();
		pb.setTotalCount(totalCount);
		//设置总页数
		Integer totalPage = 0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=(totalCount/limit)+1;
		}
		pb.setTotalPage(totalPage);
		//设置页面要显示的数据集合
		Integer begin = (currentPage-1)*limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pb.setList(list);
		return pb;
	}
	
	
	
	/**
	 * 添加一个二级分类
	 * @param categorySecond 要添加的二级分类对象
	 */
	@Override
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}
	
	
	/**
	 * 根据二级分类的id查询
	 * @param csid 要查询的二级分类id
	 * @return
	 */
	@Override
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}
	
	
	
	/**
	 * 删除一个二级分类
	 * @param categorySecond 要删除的二级分类
	 */
	@Override
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}
	
	
	/**
	 * 修改一个二级分类
	 * @param categorySecond
	 */
	@Override
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}
	
	
	/**
	 * 查询所有的二级分类
	 */
	@Override
	public List<CategorySecond> findAll() {
		
		return categorySecondDao.findAll();
	}
}
