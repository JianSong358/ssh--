package main.java.com.hj.shop.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import main.java.com.hj.shop.dao.CategoryDao;
import main.java.com.hj.shop.entity.Category;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.utils.PageBean;
import main.java.com.hj.shop.utils.PageHibernateCallback;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	/**
	 * 查询所有的一级分类
	 * 
	 * @return 所有的一级分类集合
	 */
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		String hql = "from Category order by cid desc";
		List<Category> cList = (List<Category>) getHibernateTemplate().find(hql);
		if (cList != null || cList.size() > 0) {
			return cList;
		}
		return null;
	}

	/**
	 * 根据一级分类的id查询商品的总个数
	 * 
	 * @param cid
	 *            一级分类的id
	 * @return
	 */
	@Override
	public int findByCountCid(Integer cid) {
		// 查询商品里所属二级分类所属一级分类的id是否等于传递的cid
		String hql = "select count(*) from Product p where p.categorySecond.category.cid=?";
		// 执行hql
		List<Long> list = (List<Long>) getHibernateTemplate().find(hql, cid);

		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 根据一级分类的id和当前页数查询商品
	 * 
	 * @param cid
	 *            一级分类的id
	 * @param currentPage
	 *            当前页数
	 * @return 查询到的分页封装类
	 */
	@Override
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		// String hql = "select p from Category c,CategorySecond cs,Product p
		// where c.cid=cs.category.cid and cs.csid=p.categorySecond.csid and
		// c.cid=?";
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";

		// 查询分页
		List<Product> list = (List<Product>) getHibernateTemplate()
				.execute(new PageHibernateCallback<Product>(hql, new Object[] { cid }, begin, limit));
		if (list != null && list.size() > 0) {

			return list;
		}
		return null;
	}

	/**
	 * 根据二级分类的id和当前页数查询商品
	 * 
	 * @param csid
	 *            二级分类的id
	 * @param currentPage
	 *            当前页数
	 * @return 查询到的分页封装类
	 */
	@Override
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list = getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[] { csid }, begin, limit));
		if (list != null && list.size() > 0) {

			return list;
		}
		return null;
	}

	/**
	 * 根据二级分类的id查询商品的总个数
	 * 
	 * @param cid
	 *            二级分类的id
	 * @return
	 */
	@Override
	public int findByCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list = (List<Long>) getHibernateTemplate().find(hql, csid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	
	
	/**
	 * 添加一个一级分类
	 * @param category
	 */
	@Override
	public void save(Category category) {
		getHibernateTemplate().save(category);
	}
	
	
	/**
	 * 删除一级分类
	 * @param cid
	 */
	@Override
	public void delete(Category category) {
		getHibernateTemplate().delete(category);
		
	}
	
	
	
	/**
	 * 根据一级分类的id查询该一级分类
	 * @param cid
	 * @return
	 */
	@Override
	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Category.class, cid);
	}
	
	
	
	/**
	 * 更新一个一级分类
	 * @param category
	 */
	@Override
	public void updateCategory(Category category) {
		getHibernateTemplate().update(category);
	}
}
