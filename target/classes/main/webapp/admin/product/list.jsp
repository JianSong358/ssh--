<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/layer/layer.js"></script>
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/adminProduct_addProduct.action";
			}
			function del(pid){
				var is = confirm("确认删除此商品？");
				if(is){
					window.location.href = "${pageContext.request.contextPath}/adminProduct_delete.action?pid="+pid;
				}else{
					return false;
				}
			}
			//${pageContext.request.contextPath}/adminProduct_delete.action?pid=<s:property value="#p.pid"/>
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0"  class="layui-table">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add layui-btn layui-btn-normal" onclick="addProduct()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="6%">
										序号
									</td>
									<td align="center" width="11%">
										商品名称
									</td>
									<td align="center" width="11%">
										商品图片
									</td>
									<td align="center" width="6%">
										商品价格
									</td>
									<td align="center" width="6%">
										热门
									</td>
									<td align="center" width="7%">
										更新时间
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
									<s:iterator value="pb.list" var="p" status="s" >
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="8%">
													<s:property value="#s.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="11%">
												<s:property value="#p.pname"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="11%">
												<img alt="<s:property value="#p.pname"/>" height="60px" src="${pageContext.request.contextPath}/<s:property value="#p.image"/>">
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#p.shop_price"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:if test="#p.is_hot==1">
													是
												</s:if>
												<s:else>
													否
												</s:else>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="#p.pdate"/>
											</td>
											
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/adminProduct_edit.action?pid=<s:property value="#p.pid"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="javascript:del(<s:property value="#p.pid"/>)">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</s:iterator>
							</table>
						</td>
					</tr>
					<tr align="center">
						<td>
							第<s:property value="pb.currentPage"/>/<s:property value="pb.totalPage"/>页|
							<s:if test="pb.currentPage!=1">
								<a href="${pageContext.request.contextPath}/adminProduct_findProduct.action?currentPage=1">首页</a>|&nbsp;&nbsp;&nbsp;
								<a href="${pageContext.request.contextPath}/adminProduct_findProduct.action?currentPage=<s:property value="pb.currentPage-1"/>">上一页</a>|
							</s:if>
							<s:if test="pb.currentPage!=pb.totalPage">
								<a href="${pageContext.request.contextPath}/adminProduct_findProduct.action?currentPage=<s:property value="pb.currentPage+1"/>">下一页</a>|
								<a href="${pageContext.request.contextPath}/adminProduct_findProduct.action?currentPage=<s:property value="pb.totalPage"/>">最后一页</a>|
							</s:if>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

