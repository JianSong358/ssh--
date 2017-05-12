package main.java.com.hj.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.service.ProductService;

/**
 * 商品的Action
 * @author hj
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product> {

	//模型驱动获取页面封装的商品信息对象
	private Product product = new Product();
	@Override
	public Product getModel() {
		return product;
	}
	
	//注入productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	/**
	 * 根据页面传递的商品id查询商品信息
	 * @return
	 */
	public String findByPid(){
		product=productService.findByPid(product.getPid());
		return "findByPid";
	}
}
