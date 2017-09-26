 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="CreatOrderServlet" method="post">
<table>
<tr>
<td>商品名称</td>
<td>商品单价</td>
<td>商品购买数量</td>
<td>商品小计</td>
</tr>
<c:forEach items="${sessionScope.cart.mycart }" var="mycart">
<tr>
<td>${mycart.value.product.pname }</td>
<td>${mycart.value.product.price }</td>
<td>${mycart.value.totalnum }</td>
<td>${mycart.value.product.price*mycart.value.totalnum}</td>
<c:set var="count" value="${count+mycart.value.product.price*mycart.value.totalnum }"></c:set>
</tr>
</c:forEach>
</table>
<input type="hidden" name="money" value="${count }">
收件人<input type="text" name="username"><br/>
收件人电话：<input type="text" name="phone"><br/>
 收件人地址：<input type="text" name="address"><br/>
<input type="submit" value="提交">
</form>

</body>
</html>