<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function preAddProduct() {
	location="ShowProductServlet?currentPage="+1;
}
function addProduct(pid){
	location="AddCartItemServlet?pid="+pid;
}
function clearCart(){
	location="ClearCartServlet";
}
function deleteProduct(pid,flag){
	var num=document.getElementById("num").value;
	if(num==1){
		confirm("确定要删除吗？");
		location="DeleteCartItemServlet?pid="+pid+"&flag="+flag;
	}else{
		location="DeleteCartItemServlet?pid="+pid+"&flag="+flag;
	}
	
}

</script>
<body>
<input type="button" value="继续购物" onclick="preAddProduct();">
<table>
<tr>
<td>商品名称</td>
<td>商品单价</td>
<td>商品购买数量</td>
<td>商品小计</td>
<td>商品操作</td>
</tr>
<c:forEach items="${sessionScope.cart.mycart }" var="mycart">
<tr>
<td>${mycart.value.product.pname }</td>
<td>${mycart.value.product.price }</td>
<input type="hidden" value="${mycart.value.totalnum }" id="num">
<td><input type="button" value="+" onclick="addProduct(${mycart.value.product.pid });">${mycart.value.totalnum }<input type="button" value="-" onclick="deleteProduct(${mycart.value.product.pid },1);"></td>
<td>${mycart.value.product.price*mycart.value.totalnum }</td>
<td><input type="button" value="删除" onclick="deleteProduct(${mycart.value.product.pid },2)"></td>
</tr>
</c:forEach>
</table>
<input type="button" value="清空购物车" onclick="clearCart();">
<input type="button" value="提交订单" onclick="javascrpt:location='order.jsp'">
</body>
</html>