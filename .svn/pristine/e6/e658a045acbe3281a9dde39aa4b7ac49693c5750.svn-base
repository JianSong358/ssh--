<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<table width="100%">
<tr style="background: #70d0f5;">
	<td>商品名称</td>
	<td>商品图片</td>
	<td>商品数量</td>
	<td>商品小计</td>
</tr>
<s:iterator value="oiList" var="oi">
	<tr>
		<td><s:property value="#oi.product.pname"/></td>
		<td><img src="<s:property value="#oi.product.image"/>" height="60px"/></td>
		<td><s:property value="#oi.count"/></td>
		<td><s:property value="#oi.total"/></td>
	</tr>
</s:iterator>
</table>