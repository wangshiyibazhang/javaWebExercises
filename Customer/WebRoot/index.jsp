<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>首页</title>
  </head> 
  <frameset rows="20%,*">
  	<frame name="head" src="${ pageContext.request.contextPath}/head.jsp">
  	<frame name="main" src="${ pageContext.request.contextPath}/main.jsp">
  </frameset>
</html>
