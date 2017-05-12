<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>传智网上商城</title>
	<link href="${pageContext.request.contextPath}/css/common.css"
		rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/product.css"
		rel="stylesheet" type="text/css" />
</head>
<body>

	<%@ include file="header.jsp"%>

	<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator var="c" value="#session.cList">
					<dl>
						<dt>
							<a href="${pageContext.request.contextPath}/category_findByCid?cid=<s:property value="#c.cid"/>&currentPage=1""><s:property value="#c.cname" /></a>
						</dt>
						<s:iterator value="#c.categorySecondSet" var="cs">
							<dd>
								<a href="${pageContext.request.contextPath}/category_findByCsid?csid=<s:property value="#cs.csid"/>&currentPage=1"><s:property value="#cs.csname" /></a>
							</dd>
						</s:iterator>
					</dl>
				</s:iterator>
			</div>
		</div>
		<div class="span18 last">

			<form id="productForm"
				action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm" method="get">

				<div id="result" class="result table clearfix">
					<ul>
						<s:iterator var="p" value="pb.list">
							<li><a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#p.pid"/>"> <img
									src="${pageContext.request.contextPath}/<s:property value="#p.image"/>"
									width="170" height="170" style="display: inline-block;" /> <span
									style='color:green'> <s:property value="#p.pname"/> </span> <span class="price">
										商城价： ￥<s:property value="#p.shop_price"/> </span>
	
							</a></li>
						</s:iterator>
					</ul>
				</div>
					
				<div class="pagination">
					<span>第<s:property value="pb.currentPage"/>/<s:property value="pb.totalPage"/>页</span>
						<s:if test="cid!=null">
							<s:if test="pb.currentPage!=1">
								<a href="${pageContext.request.contextPath}/category_findByCid?currentPage=1&cid=<s:property value="cid"/>" class="firstPage">&nbsp;</a>
								<a href="${pageContext.request.contextPath}/category_findByCid?currentPage=<s:property value="pb.currentPage-1"/>&cid=<s:property value="cid"/>" class="previousPage">&nbsp;</a>
							</s:if>
							<s:iterator begin="1" end="pb.totalPage" var="i">
								<s:if test="pb.currentPage!=#i">
									<a href="${pageContext.request.contextPath}/category_findByCid?currentPage=<s:property value="#i"/>&cid=<s:property value="cid"/>"><s:property value="#i"/></a> 
								</s:if>
								<s:else>
									<a href="${pageContext.request.contextPath}/category_findByCid?currentPage=<s:property value="#i"/>&cid=<s:property value="cid"/>" class="currentPage"><s:property value="#i"/></a> 
								</s:else>
							</s:iterator>
							<s:if test="pb.currentPage!=pb.totalPage">
								<a href="${pageContext.request.contextPath}/category_findByCid?currentPage=<s:property value="pb.currentPage+1"/>&cid=<s:property value="cid"/>" class="nextPage" >&nbsp;</a> 
								<a href="${pageContext.request.contextPath}/category_findByCid?currentPage=<s:property value="pb.totalPage"/>&cid=<s:property value="cid"/>" class="lastPage" >&nbsp;</a>
							</s:if>
						</s:if>
						
						<s:if test="csid!=null">
							<s:if test="pb.currentPage!=1">
								<a href="${pageContext.request.contextPath}/category_findByCsid?currentPage=1&csid=<s:property value="csid"/>" class="firstPage">&nbsp;</a>
								<a href="${pageContext.request.contextPath}/category_findByCsid?currentPage=<s:property value="pb.currentPage-1"/>&csid=<s:property value="csid"/>" class="previousPage">&nbsp;</a>
							</s:if>
							<s:iterator begin="1" end="pb.totalPage" var="i">
								<s:if test="pb.currentPage!=#i">
									<a href="${pageContext.request.contextPath}/category_findByCsid?currentPage=<s:property value="#i"/>&csid=<s:property value="csid"/>"><s:property value="#i"/></a> 
								</s:if>
								<s:else>
									<a href="${pageContext.request.contextPath}/category_findByCsid?currentPage=<s:property value="#i"/>&csid=<s:property value="csid"/>" class="currentPage"><s:property value="#i"/></a> 
								</s:else>
							</s:iterator>
							<s:if test="pb.currentPage!=pb.totalPage">
								<a href="${pageContext.request.contextPath}/category_findByCsid?currentPage=<s:property value="pb.currentPage+1"/>&csid=<s:property value="csid"/>" class="nextPage" >&nbsp;</a> 
								<a href="${pageContext.request.contextPath}/category_findByCsid?currentPage=<s:property value="pb.totalPage"/>&csid=<s:property value="csid"/>" class="lastPage" >&nbsp;</a>
							</s:if>
						</s:if>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>