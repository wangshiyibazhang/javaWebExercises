<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>head</title>
  </head>
  <body style="text-align: center;">
  	<h1>拉拉网站客户管理中心</h1>
  	<br/>
  	<a href="${pageContext.request.contextPath }/servlet/addCustomer" target="main">添加客户</a>
  	<a href="${pageContext.request.contextPath }/servlet/listCustomer" target="main">查询客户</a>
</body>
</html>  	
