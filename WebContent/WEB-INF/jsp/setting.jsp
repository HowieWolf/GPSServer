<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="admin.do">管理员页面</a>
	<br>
	<br> 设置IP和端口
	<form action="setting/iport.do" method="post">
		ID<input type="text" name="eId" /><br> IP<input type="text"
			name="ip" /><br> port<input type="text" name="port" /><br>
		<input type="submit" value="修改" />
	</form>
	<br />
	<br /> 设置定位时间间隔
	<form action="setting/positionspan.do" method="post">
		ID<input type="text" name="eId" /><br> 间隔<input type="text"
			name="span" />s<br> <input type="submit" value="修改" />
	</form>
	<br />
	<br />
</body>
</html>