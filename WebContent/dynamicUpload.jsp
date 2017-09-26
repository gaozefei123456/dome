<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function addMore(){
	var textFile=document.createElement("input");
	textFile.type="file";
	textFile.name="file";
	var btnDelete=document.createElement("input");
	btnDelete.type="button";
	btnDelete.value="删除";
	var br=document.createElement("br");
	var divAddMore=document.getElementById("divAddMore");
	divAddMore.appendChild(textFile);
	divAddMore.appendChild(btnDelete);
	divAddMore.appendChild(br);
	btnDelete.onclick=function(){
		divAddMore.removeChild(textFile);
		divAddMore.removeChild(btnDelete);
		divAddMore.removeChild(br);
	}
}

</script>
<body>
<form action="MultiUploadServlet" method="post" enctype="multipart/form-data">
	<p>选择文件</p>
<input type="file" name="file"><input type="button" value="显示更多" onclick="addMore();">
<div id="divAddMore"></div>
<input type="submit" value="上传">
</form>
</body>
</html>