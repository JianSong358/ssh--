package main.java.com.hj.shop.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.Cart;
import main.java.com.hj.shop.entity.CartItem;
import main.java.com.hj.shop.entity.Order;
import main.java.com.hj.shop.entity.OrderItem;
import main.java.com.hj.shop.entity.User;
import main.java.com.hj.shop.service.OrderService;
import main.java.com.hj.shop.utils.PageBean;
import main.java.com.hj.shop.utils.PaymentUtil;

/**
 * 订单的Action
 * 
 * @author hj
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	// 使用模型驱动接收页面封装的信息对象
	private Order order = new Order();
	@Override
	public Order getModel() {
		return order;
	}

	// 注入OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// 接收页面传递的currentPage
	private Integer currentPage;

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	// 接收付款银行的代码
	private String pd_FrpId;

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	
	
	//接收付款成功回调的数据
	//支付金额
	private String r3_Amt;
	//订单编号 
	private String r6_Order;
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}
	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	/**
	 * 生成订单，跳转到订单页面
	 * 
	 * @return
	 */
	public String save() {
		// 设置订单的信息
		order.setOid((int)new Date().getTime());
		// 订单的时间
		order.setOrdertime(new Date());
		// 订单的状态：1：未付款，2：已付款，3：已发货，4：交易完成
		order.setState(1);
		// 从session中获取购物车
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		// 判断session中是否有购物
		if (cart == null) {
			addActionMessage("请先去购物吧");
			return "msg";
		}
		// 订单总的金额
		order.setTotal(cart.getTotal());
		// 订单中的订单项
		for (CartItem cartItem : cart.getCartItems()) {
			// 创建一个订单项
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrder(order);
			orderItem.setProduct(cartItem.getProduct());

			// 把订单项添加到订单中
			order.getOrderItemSet().add(orderItem);
		}

		// 订单所属的用户
		// 获取session中的用户
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		// 判断用户是否已登录
		if (existUser == null) {
			addActionMessage("请先登录");
			return "login";
		}
		order.setUser(existUser);
		// 保存数据到数据库
		orderService.save(order);

		// 清空购物车
		cart.clearCart();
		return "save";
	}

	/**
	 * 显示用户的所有订单
	 */
	public String findByUid() {
		// 获取session中的用户对象
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");

		// 根据用户的id查询订单
		PageBean<Order> pb = orderService.findByUid(user.getUid(), currentPage);

		List<Order> lis = pb.getList();

		// 将PageBean存入值栈中
		ServletActionContext.getContext().getValueStack().set("pb", pb);
		return "findByUid";
	}

	/**
	 * 根据订单的id查询订单的信息
	 */
	public String findByOid() {
		// 用模型驱动接收页面传递的oid，调用Service查询，并把查询到的结果赋值给模型驱动order对象
		order = orderService.findByOid(order.getOid());
		return "findByOid";
	}
	
	
	

	
	
	/**
	 * 订单付款
	 * 
	 * @return
	 * @throws IOException
	 */
	public String payOrder() throws IOException {
		// 修改订单
		Order o = orderService.findByOid(order.getOid());
		o.setAddr(order.getAddr());
		o.setName(order.getName());
		o.setPhone(order.getPhone());
		orderService.updateOrder(o);

		// 付款
		// 业务类型
		String p0_Cmd = "Buy";
		// 商家帐号（编号）
		String p1_MerId = "10001126856";
		// 订单号
		String p2_Order = order.getOid().toString();
		// 付款金额 0.01测试 order.getTotal()
		String p3_Amt = "0.01";
		// 交易币种
		String p4_Cur = "CNY";
		// 商品名称
		String p5_Pid = "";
		// 商品种类
		String p6_Pcat = "";
		// 商品描述
		String p7_Pdesc = "";
		// 商户接收支付成功数据的地址
		String p8_Url = "http://localhost:8080/shop/order_callBack.action";
		// 送货地址
		String p9_SAF = "";
		// 商户扩展信息
		String pa_MP = "";
		// 银行编码
		String pd_FrpId = this.pd_FrpId;
		// 应答机制
		String pr_NeedResponse = "1";

		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		// 签名数据
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

		// 拼接请求数据的路径
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);

		// 重定向到请求数据的路径
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return "none";
	}
	
	
	/**
	 * 订单付款完成回调
	 */
	public String callBack(){
		//修改订单的状态为已付款
		Order o = orderService.findByOid(Integer.parseInt(r6_Order));
		o.setState(2);
		orderService.updateOrder(o);
		
		//在支付页面显示支付的信息
		addActionMessage("支付成功，订单编号："+r6_Order+"支付金额："+r3_Amt);
		return "msg";
	}
	
	
	
	/**
	 * 修改订单状态
	 * @return
	 */
	public String updateState(){
		order = orderService.findByOid(order.getOid());
		order.setState(4);
		orderService.updateOrder(order);
		return "updateState";
	}
}
