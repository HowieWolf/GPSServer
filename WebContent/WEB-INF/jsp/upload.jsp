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
	<br><br>
	<br>
	${result}
	<br>
	<br>
	<form action="submitNewVersion.do" method="post" enctype="multipart/form-data">
		版本号<input type="text" name="code" /><br/>
		版本名称<input type="text" name="name" /><br/>
		版本描述<input type="text" name="desc" /><br/>
		APK<input type="file" name="newApk" /><br/>
		<input type="submit" value="提交" /><br/>
	</form>
</body>
</html>