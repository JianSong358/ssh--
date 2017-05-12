package main.java.com.hj.shop.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import main.java.com.hj.shop.entity.Cart;
import main.java.com.hj.shop.entity.CartItem;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.service.ProductService;

/**
 * 购物车的Action
 * @author hj
 *
 */
public class CartAction extends ActionSupport {
	
	//注入商品的ProductService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//接收页面传递的商品id
	private Integer pid;
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	//接收页面传递的数量
	private Integer count;
	public void setCount(Integer count) {
		this.count = count;
	}


	/**
	 * 将购物项添加到购物车
	 * @return
	 */
	public String addCart(){
		//封装一个CartItem对象
		CartItem cartItem = new CartItem();
		
		//设置商品的数量
		cartItem.setCount(count);
		
		//根据商品的id查询商品
		Product product = productService.findByPid(pid);
		
		//设置商品的信息
		cartItem.setProduct(product);
		
		//从session获取购物车
		Cart cart = getCart();
		
		//将购物项添加到购物车
		cart.addCart(cartItem);
		return "addCart";
	}
	
	
	/**
	 * 从购物车人移除一个购物项
	 */
	public String removeCart(){
		Cart cart = getCart();
		cart.removeCart(pid);
		return "removeCart";
	}
	
	
	/**
	 * 清空购物车
	 * @return
	 */
	public String clearCart(){
		
		Cart cart = getCart();
		
		cart.clearCart();
		
		return "clearCart";
	}
	
	/**
	 * 跳转到购物车
	 * @return
	 */
	public String myCart(){
		return "myCart";
	}

	
	//从session获取购物车
	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		//判断session里有没有购物车
		if(cart==null){
			//没有，创建一个cart并把它存到session中
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
}
