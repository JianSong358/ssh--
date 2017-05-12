package main.java.com.hj.shop.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.hj.shop.dao.ProductDao;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.utils.PageHibernateCallback;

/**
 * 商品Dao实现类
 * 
 * @author hj
 *
 */
@Transactional
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	/**
	 * 查询页面上的热门商品，10个
	 * 
	 * @return 查询到的热门商品
	 */
	@Override
	public List<Product> findHot() {
		// 离线条件查询
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		// 查询热门商品，条件：is_hot=1
		dc.add(Restrictions.eqOrIsNull("is_hot", 1));
		// 按商品的倒序排序
		dc.addOrder(Order.desc("pdate"));
		// 开始查询分页0,10 ,返回查询结果的集合
		List<Product> list = (List<Product>) getHibernateTemplate().findByCriteria(dc, 0, 10);
		return list;
	}

	/**
	 * 查询页面上的最新商品，10个
	 * 
	 * @return 查询到的热门商品
	 */
	@Override
	public List<Product> findNew() {
		// 离线条件查询
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		//按时间倒序排序
		dc.addOrder(Order.desc("pdate"));
		//开始查询
		List<Product> list =(List<Product>)getHibernateTemplate().findByCriteria(dc,0,10);
		return list;
	}
	
	/**
	 * 根据商品的id查询商品信息
	 */
	@Override
	public Product findByPid(Integer pid) {
		Product product =getHibernateTemplate().get(Product.class, pid);
		return product;
	}
	
	
	
	/**
	 * 查询出所有的商品个数
	 * @return
	 */
	@Override
	public Integer findByCount() {
		String hql = "select count(*) from Product";
		List<Long> list = (List<Long>) getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	
	
	/**
	 * 查询所有的商品
	 * @return
	 */
	@Override
	public List<Product> findByList(Integer begin,Integer currentPage) {
		String hql = "from Product order by pdate desc";
		
		return getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin, currentPage));
	}
	
	
	
	/**
	 * 添加一个商品
	 * @param product
	 */
	@Override
	public void save(Product product) {
		getHibernateTemplate().save(product);
	}
	
	
	/**
	 * 删除一个商品
	 * @param pid
	 */
	@Override
	public void delete(Product product) {
		getHibernateTemplate().delete(product);
	}
	
	
	
	/**
	 * 修改一个商品
	 * @param product
	 */
	@Override
	public void update(Product product) {
		getHibernateTemplate().update(product);
	}
}
