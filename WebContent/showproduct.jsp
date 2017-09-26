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
<c:if test="${empty requestScope.productPage.list }">
<jsp:forward page="ShowProductServlet"></jsp:forward>
</c:if>
<script type="text/javascript">
function addCart(pid){
	location="AddCartItemServlet?pid="+pid;
}


</script>
<table>
	<tr>
	<td>编号</td>
	<td>名称</td>
	<td>价格</td>
	<td>数量</td>
	<td>图片</td>
	<td>操作</td>
	</tr>
	<c:forEach items="${requestScope.productPage.list }" var="product">
		<tr>
			<td>${product.pid }</td>
			<td>${product.pname }</td>
			<td>${product.price }</td>
			<td>${product.num }</td>
			<td><img src="upload/${product.pic}"></img></td>
			<td><input type="button" value="放入购物车" onclick="addCart(${product.pid})"></td>
		</tr>
	</c:forEach>
	<tr>
	<td colspan="5">
	每页${requestScope.productPage.pageSize }条记录&nbsp;共${requestScope.productPage.totalCount }条记录第${requestScope.productPage.currentPage }页共${requestScope.productPage.totalPage }页
	<c:if test="${requestScope.productPage.currentPage==1 }">
	首页&nbsp;上一页
	</c:if>
	<c:if test="${requestScope.productPage.currentPage!=1 }">
	<a href="ShowProductServlet?currentPage=1">首页</a>
	<a href="ShowProductServlet?currentPage=${requestScope.productPage.currentPage-1}">上一页</a>
	</c:if>
	<c:if test="${requestScope.productPage.currentPage==requestScope.productPage.totalPage }">
	下一页&nbsp;尾页
	</c:if>
	<c:if test="${requestScope.productPage.currentPage!=requestScope.productPage.totalPage }">
	<a href="ShowProductServlet?currentPage=${requestScope.productPage.currentPage+1 }">下一页</a>
	<a href="ShowProductServlet?currentPage=${requestScope.productPage.totalPage}">尾页</a>
	</c:if>
	</td>
	</tr>
	
	
</table>
</body>
</html>