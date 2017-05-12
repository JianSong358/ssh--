package main.java.com.hj.shop.entity;

import java.io.Serializable;

/**
 * 购物车里每一项的对象
 * @author hj
 *
 */
public class CartItem implements Serializable {

	private Product product;	//购物车中商品的信息
	private int count;			//商品的数量
	private double subtotal;	//商品价格的小计
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count*product.getShop_price();
	}
	
	
}
