package main.java.com.hj.shop.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author hj
 *
 */
public class Cart implements Serializable {

	//购物车中每一项的集合key:商品的id、value:购物项
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer,CartItem>();
	
	//购物总计
	private double total;
	
	
	
	public double getTotal() {
		return total;
	}

	//获取所有购物项的集合
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	//购物车的功能
	//将购物项添加到购物车
	public void addCart(CartItem cartItem){
		//获取要添加的购物项里商品的id
		Integer pid = cartItem.getProduct().getPid();
		
		//判断购物车里(map)有没有该购物项
		if(map.containsKey(pid)){
			//有，在原来的数量、小计上加上要要添加的购物项
			//获取已存在的购物项
			CartItem _cartItem =map.get(pid);
			//数量相加
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			//没有，往map里添加一个购物项
			map.put(pid, cartItem);
		}
		
		//总计加上添加的小计
		total+=cartItem.getSubtotal();
	}
	
	//将购物项从购物车中移除
	public void removeCart(Integer pid){
		//移除购物项
		CartItem cartItem = map.remove(pid);
		
		//总计减购物项的小计
		total -= cartItem.getSubtotal();
	}
	
	//清空购物车
	public void clearCart(){
		//将购物项清空
		map.clear();
		
		//将总计设为0
		total=0;
	}
}
