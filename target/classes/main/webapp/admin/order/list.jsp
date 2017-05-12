<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/css/Style1.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script language="javascript"
	src="${pageContext.request.contextPath}/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script type="text/javascript">
$(function(){
	
});

function showDetail(oid){
	  
	  var x = layer.load(1);
	  $.ajax({
		  cache:false,
		  url: "${pageContext.request.contextPath}/adminOrder_detail.action",
		  data: "time="+new Date().getTime()+"&oid="+oid,
	      success: function(responseText, textStatus, XMLHttpRequest){
	    	  
	    	  layer.open({
	    		  type: 2,
	    		  title: '详情',
	    		  maxmin: true,
	    		  shadeClose: true, //点击遮罩关闭层
	    		  area : ['800px' , '520px'],
	    		  content: '${pageContext.request.contextPath}/adminOrder_detail.action?oid='+oid
	    		  });
	    	  layer.close(x);
	      }
	  });
}

function ship(oid){
	
	layer.confirm('确认发货？', {
		  btn: ['发货','取消'] //按钮
		}, function(){
			window.location.href="${pageContext.request.contextPath}/adminOrder_updateState.action?oid="+oid;
		});
}
	
</script>
</HEAD>
<body>
	<br>
	<form id="Form1" name="Form1"
		action="${pageContext.request.contextPath}/user/list.jsp"
		method="post">
		<table cellSpacing="1" cellPadding="0" width="100%" align="center"
			bgColor="#f5fafe" border="0">
			<TBODY>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单列表</strong></TD>
				</tr>
				<tr>
					<td class="ta_01" align="right"></td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table cellspacing="0" cellpadding="1" rules="all"  class="table table-striped table-hover"
							bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
							<tr
								style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">
								<td align="center" width="4%">序号</td>
								<td align="center" width="5%">订单编号</td>
								<td align="center" width="6%">订单金额</td>
								<td align="center" width="10%">创建时间</td>
								<td align="center" width="5%">收货人</td>
								<td align="center" width="6%">电话</td>
								<td align="center" width="11%">地址</td>
								<td width="5%" align="center">创建用户</td>
								<td width="5%" align="center">状态</td>
								<td align="center" width="4%">详情</td>
							</tr>
							<s:if test="pb.list!=null">
								<s:iterator value="pb.list" var="o" status="s">
									<tr onmouseover="this.style.backgroundColor = 'white'"
										onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="4%"><s:property value="#s.count" /></td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="5%"><s:property value="#o.oid" /></td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="6%"><s:property value="#o.total" />￥</td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="10%"><s:property value="#o.ordertime" /></td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="5%"><s:property value="#o.name" /></td>
										<td style="CURSOR: hand; HEIGHT: 22px" align="center"
											width="6%"><s:property value="#o.phone" /></td>
										<td align="center" style="HEIGHT: 22px" width="11%"><s:property
												value="#o.addr" /></td>
										<td align="center" style="HEIGHT: 22px" width="7%"><s:property
												value="#o.user.username" /></td>
										<td align="center" style="HEIGHT: 22px" width="7%"><s:if
												test="#o.state==1">
												<b><a href="#">未付款</a></b>
											</s:if> <s:if test="#o.state==2">
												<b><a href="javascript:ship(<s:property value="#o.oid"/>)" class="btn">发货</a></b>
											</s:if> <s:if test="#o.state==3">
												<b><a href="#">未确定收货</a></b>
											</s:if> <s:if test="#o.state==4">
												<b><a href="#">已完成</a></b>
											</s:if></td>
										<td style="HEIGHT: 22px" align="center" width="4%">
											<input type="button" value="详情" id="btn<s:property value="#o.oid"/>" onclick="showDetail(<s:property value="#o.oid"/>)" class="btn-primary" />
										</td>
									</tr>
								</s:iterator>
							</s:if>
							<s:else>
								<tr>
									<td colspan="10" align="center"><h1>还没有订单</h1></td>
								</tr>
							</s:else>
						</table>
					</td>
				</tr>
				<tr align="center">
					<td>第<s:property value="pb.currentPage" />/<s:property
							value="pb.totalPage" />页| <s:if test="pb.currentPage!=1">
							<a
								href="${pageContext.request.contextPath}/adminOrder_findOrder.action?currentPage=1">首页</a>|&nbsp;&nbsp;&nbsp;
								<a
								href="${pageContext.request.contextPath}/adminOrder_findOrder.action?currentPage=<s:property value="pb.currentPage-1"/>">上一页</a>|
							</s:if> <s:if test="pb.currentPage!=pb.totalPage">
							<a
								href="${pageContext.request.contextPath}/adminOrder_findOrder.action?currentPage=<s:property value="pb.currentPage+1"/>">下一页</a>|
								<a
								href="${pageContext.request.contextPath}/adminOrder_findOrder.action?currentPage=<s:property value="pb.totalPage"/>">最后一页</a>|
							</s:if>
					</td>
				</tr>
			</TBODY>
		</table>
	</form>
</body>
</HTML>

