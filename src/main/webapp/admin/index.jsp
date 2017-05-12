<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网上商城管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminLogin.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
   $(function () {
      $("input[name='adminname']").focus();
       $('.login').click(function () {
           if ($('#uid').val() == "" || $('#pwd').val() == "") { 
        	   $('.tip').html('用户名或密码不可为空！');
        	   $("input[name='adminname']").focus();
           }
           else {
               //location.href = 'index.html';
               $("#loginForm").submit();
           }
       });
      
   })
</script>
</head>
<body>
    <div id="clouds" class="stage"></div>
    <div class="loginmain">
    </div>
		<form action="${pageContext.request.contextPath}/admin_login.action" target="_parent" id="loginForm" method="post">
		    <div class="row-fluid">
		        <h1>后台管理系统</h1>
		        <p>
		            <label>帐&nbsp;&nbsp;&nbsp;号：<input type="text" id="uid" name="adminname"/></label>
		        </p>
		        <p>
		            <label>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="pwd" name="password"/></label>
		        </p>
		        
		        <span class="tip" style="color:red;"><s:actionmessage/></span>
		        <hr />
		        <input type="button" value=" 登 录 " class="btn btn-primary btn-large login" />
		        &nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/index" class="btn btn-large" style="width: auto;">返回首页</a>
		    </div>
		 </form>
</body>
</html>
