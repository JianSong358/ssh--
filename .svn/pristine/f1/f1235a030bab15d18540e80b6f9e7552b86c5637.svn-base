package main.java.com.hj.shop.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import main.java.com.hj.shop.dao.CategorySecondDao;
import main.java.com.hj.shop.entity.CategorySecond;
import main.java.com.hj.shop.utils.PageHibernateCallback;

/**
 * 二级分类Dao持久层接口实现类
 * @author Administrator
 *
 */
public class CategorySecondDaoImpl extends HibernateDaoSupport implements CategorySecondDao {

	/**
	 * 查询所有的二级分类的数量
	 * @return
	 */
	@Override
	public Integer findByCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list =(List<Long>) getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	
	/**
	 * 带分布查询所有的二级分类
	 * @param begin 分页的开始
	 * @param limit 每页要显示多少
	 * @return 所有的二级分类的集合
	 */
	@Override
	public List<CategorySecond> findByPage(Integer begin, Integer limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, null, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	
	
	/**
	 * 添加一个二级分类
	 * @param categorySecond 要添加的二级分类对象
	 */
	@Override
	public void save(CategorySecond categorySecond) {
		getHibernateTemplate().save(categorySecond);
	}
	
	
	
	/**
	 * 根据二级分类的id查询
	 * @param csid 要查询的二级分类id
	 * @return
	 */
	@Override
	public CategorySecond findByCsid(Integer csid) {
		
		return getHibernateTemplate().get(CategorySecond.class, csid);
	}
	
	
	
	/**
	 * 删除一个二级分类
	 * @param categorySecond 要删除的二级分类
	 */
	@Override
	public void delete(CategorySecond categorySecond) {
		getHibernateTemplate().delete(categorySecond);
	}
	
	
	/**
	 * 修改一个二级分类
	 * @param categorySecond
	 */
	@Override
	public void update(CategorySecond categorySecond) {
		getHibernateTemplate().update(categorySecond);
	}
	
	
	/**
	 * 查询所有的二级分类
	 * @return
	 */
	@Override
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		
		return (List<CategorySecond>) getHibernateTemplate().find(hql);
	}
}
