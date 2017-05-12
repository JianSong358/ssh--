package main.java.com.hj.shop.dao;

import java.util.List;

import main.java.com.hj.shop.entity.CategorySecond;

/**
 * 二级分类Dao持久层接口
 * @author Administrator
 *
 */
public interface CategorySecondDao {

	/**
	 * 查询所有的二级分类的数量
	 * @return
	 */
	public Integer findByCount();
	
	
	/**
	 * 带分布查询所有的二级分类
	 * @param begin 分页的开始
	 * @param limit 每页要显示多少
	 * @return 所有的二级分类的集合
	 */
	public List<CategorySecond> findByPage(Integer begin,Integer limit);
	
	
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
