<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>信息</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/register.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>

<script>
	
</script>
</head>
<body>

	<%@ include file="header.jsp" %>


	<div id="msgMain"
		style="width: 18%;
    margin-left: 38%;
    margin-top: 10%;
    margin-bottom: 10%;
    font-size: 22px;">
    	<img src="${pageContext.request.contextPath}/images/IconTexto_WebDev_009.jpg" alt="" style="padding-left: 15%;"/>
		<s:actionmessage />
		<s:actionerror />
	</div>


	<%@ include file="footer.jsp" %>
</body>
</html>