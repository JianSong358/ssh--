<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cart.css"
	rel="stylesheet" type="text/css" />

</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="container cart">

		<div class="span24">
			<table>
				<tbody>
					<s:if test="pb.totalCount!=0">
						<s:iterator value="pb.list" var="order">
							<tr>
								<th colspan="5">订单编号：<s:property value="#order.oid" />&nbsp;&nbsp;&nbsp;&nbsp;订单状态：
									<s:if test="#order.state==1">
										<b><a href="${pageContext.request.contextPath}/order_findByOid.action?oid=<s:property value="#order.oid" />"><font color="red">付款</font></a></b>
									</s:if> <s:if test="#order.state==2">
										<b><a href="#">已付款</a></b>
									</s:if> <s:if test="#order.state==3">
										<b><a href="${pageContext.request.contextPath}/order_updateState.action?oid=<s:property value="#order.oid"/>"><font color="red">确定收货</font></a></b>
									</s:if> <s:if test="#order.state==4">
										<b><a href="#">已完成</a></b>
									</s:if>
								</th>
							</tr>
							<tr>
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<s:iterator value="#order.orderItemSet" var="orderItem">
								<tr>
									<td width="60"><img
										src="${pageContext.request.contextPath}/<s:property value="#orderItem.product.image"/>" />
									</td>
									<td><a target="_blank"><s:property
												value="#orderItem.product.pname" /></a></td>
									<td><s:property value="#orderItem.product.shop_price" /></td>
									<td class="quantity" width="60"><s:property
											value="#orderItem.count" /></td>
									<td width="140">￥<s:property value="#orderItem.subtotal" />
									</td>
								</tr>
							</s:iterator>
						</s:iterator>
	
						<tr>
							<th colspan="5">
								<div class="pagination">
									<span>第<s:property value="pb.currentPage" />/<s:property
											value="pb.totalPage	" />页
									</span>
									<s:if test="pb.currentPage!=1">
										<a
											href="${pageContext.request.contextPath}/order_findByUid?currentPage=1"
											class="firstPage">&nbsp;</a>
										<a
											href="${pageContext.request.contextPath}/order_findByUid?currentPage=<s:property value="pb.currentPage-1"/>"
											class="previousPage">&nbsp;</a>
									</s:if>
									<s:iterator begin="1" end="pb.totalPage" var="i">
										<s:if test="pb.currentPage!=#i">
											<a
												href="${pageContext.request.contextPath}/order_findByUid?currentPage=<s:property value="#i"/>"><s:property
													value="#i" /></a>
										</s:if>
										<s:else>
											<a
												href="${pageContext.request.contextPath}/order_findByUid?currentPage=<s:property value="#i"/>"
												class="currentPage"><s:property value="#i" /></a>
										</s:else>
									</s:iterator>
									<s:if test="pb.currentPage!=pb.totalPage">
										<a
											href="${pageContext.request.contextPath}/order_findByUid?currentPage=<s:property value="pb.currentPage+1"/>"
											class="nextPage">&nbsp;</a>
										<a
											href="${pageContext.request.contextPath}/order_findByUid?currentPage=<s:property value="pb.totalPage"/>"
											class="lastPage">&nbsp;</a>
									</s:if>
								</div>
							</th>
						</tr>
					</s:if>
					<s:else>
						<tr>
							<th colspan="5">你还没有订单，请先去购物吧</th>
						</tr>
					</s:else>
				</tbody>
			</table>
		</div>

	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>