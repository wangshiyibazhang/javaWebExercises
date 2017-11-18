<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listCustomer.jsp' starting page</title>
  </head>	  
  <style type="text/css">
  	.even{background-color:#00FFFF }
  	.odd{background-color:#00FF7F }
  	tr:hover{background-color:#FFDAB9 }
  </style>
  <body>
  	<table frame="border" width="100%">
  		<tr>
  			<td>客户姓名</td>
  			<td>客户性别</td>
  			<td>客户生日</td>
  			<td>客户电话</td>
  			<td>客户邮箱</td>
  			<td>客户爱好</td>
  			<td>客户类型</td>
  			<td>客户描述</td>
  			<td>操作</td>
  		</tr>
  		<c:forEach var="c" items="${requestScope.pagebean.list }" varStatus="status">
  			<tr class="${status.count%2==0?'even':'odd' }">
  				<td>${c.name}</td>
  				<td>${c.gender }</td>
  				<td>${c.birthday }</td>
  				<td>${c.cellphone }</td>
  				<td>${c.email }</td>
  				<td>${c.preference }</td>
  				<td>${c.type }</td>
  				<td>${c.description }</td>
  				<td>
  					<a href="${pageContext.request.contextPath }/servlet/updateCustomer?id=${c.id}">修改</a>
  					<a href="${pageContext.request.contextPath }/servlet/deleteCustomer?id=${c.id}">删除</a>
  				</td>
  			</tr>
  		</c:forEach>
  	</table>
  	<script type="text/javascript">
  		function goPage(currentPage){
  			window.location.href ="${pageContext.request.contextPath }/servlet/listCustomer?currentPage="+currentPage;
  		}
  	</script>
  	共有[${pagebean.totalrecord}]条记录，每页[${pagebean.pagesize}]条，共[${pagebean.pagesize}]页，当前第[${pagebean.currentpage}]页，
  	<a href="javascript:void(0)" onclick="goPage(${pagebean.previouspage})">上一页</a>
  	<c:forEach var="pagenum" items="${pagebean.pageBar }">
  		<c:if test="${pagenum==pagebean.currentpage }">
  			<font color="red">${pagenum}</font>
  		</c:if>
  		<c:if test="${pagenum!=pagebean.currentpage }">
  			<a href="javascript:void(0)" onclick="goPage(${pagenum})" >${pagenum}</a>
  		</c:if>
  	</c:forEach>
  	<a href="javascript:void(0)" onclick="goPage(${pagebean.nextpage})">下一页</a>
  </body>
</html>
