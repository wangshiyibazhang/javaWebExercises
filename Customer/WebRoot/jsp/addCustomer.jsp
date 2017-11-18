<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>My JSP 'addCustomer.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath }/JS/ShowCalendar.js"></script>
    <script type="text/javascript">
    	function makepre(){
    		var pres = document.getElementsByName("pre");
    		var preference="";
    		for(var i=0;i<pres.length;i++){
    			var pre =pres[i];
    			if(pre.checked){
    				preference = preference+pre.value+",";
    			}
    		}
    		preference = preference.substr(0,preference.length-1,",");
    		
    		var form = document.getElementById("form");
    		var input = document.createElement("input");
    		input.type="hidden";
    		input.name="preference";
    		input.value=preference;
    		form.appendChild(input);
    		return true;
    	}
    </script>
  </head>
  
  <body style="text-align: center;">
  	<form action="${pageContext.request.contextPath}/servlet/addCustomer"  id="form" method="post" onsubmit="return makepre()" accept-charset="utf-8" >
  	<table width="50%" border="1">
  		<tr>
  			<td>客户姓名</td>
  			<td>
  				<input type="text" name="name">
  			</td>
  		</tr>
  		<tr>
  			<td>客户性别</td>
  			<td>
  				<c:forEach var="gender" items="${genders}">
  					<input type="radio" name="gender" value="${gender}">${gender}
  				</c:forEach> 
  			</td>
  		</tr>
  		<tr>
  			<td>电话</td>
  			<td>
  				<input type="text" name="cellphone">
  			</td>
  		</tr>
  		<tr>
  			<td>生日</td>
  			<td>
  				<input name="birthday" type="text" id="birthday"  onClick="showCalendar(this.id)">
  			</td>
  		</tr>
  		<tr>
  			<td>邮箱</td>
  			<td>
  				<input type="text" name="email">
  			</td>
  		</tr>
  		<tr>
  			<td>爱好</td>
  			<td>
  				<c:forEach var="preference" items="${preferences}">
  					<input type="checkbox" name="pre" value="${preference }">${preference }
  				</c:forEach>
  			</td>
  		</tr>
  		<tr>
  			<td>客户类型</td>
  			<td>
  				<c:forEach var="type" items="${types}">
  					<input type="radio" name="type" value="${type}">${type}
  				</c:forEach>
  			</td>
  		</tr>
  		<tr>
  			<td>描述</td>
  			<td>
  				<textarea rows="5" cols="50" name="description"></textarea>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				<input type="reset" value="重置">
  			</td>
  			<td>
  				<input type="submit" value="提交">
  			</td>
  		</tr>
  	</table>
  	</form>
   
  </body>
</html>
