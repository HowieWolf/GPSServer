<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	服务器的开启与关闭
	<br>
	<form action="start.do" method="post">
		<input type="submit" value="启动" />
	</form>
	<form action="stop.do" method="post">
		<input type="submit" value="停止" />
	</form>
	<br>
	<br>
	<br> 查看
	<form action="equiplist.do" method="post">
		<input type="submit" value="设备列表" />
	</form>
	
	<a href="upload.do">上传新版本</a>
	
</body>
</html>