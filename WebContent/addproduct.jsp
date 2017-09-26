<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function checkForm(){
	var file=document.getElementById("file");
	if(file.value==null){
		alert("请上传文件");
		return false;
	}else{
		return true;
	}
	
}
</script>
<body>
<form action="${pageContext.request.contextPath }/AddProductServlet" enctype="multipart/form-data" method="post" onsubmit="checkForm();" >
商品名称：<input type="text" name="pname" />
商品价格：<input type="text" name="price">
商品数量：<input type="text" name="num">
商品图片：<input type="file" id="file" name="file">
<input type="submit" value="添加">
</form>
</body>
</html>