<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div >
	<form action="./query" method="post">
	<h1>电量查询</h1>
	区域（东区北区南区）：<br><input name="area" type="text" /><br>
	楼号（如：1）：<br><input name="house" type="text" /><br>
	房间号（如：110）：<br><input name="room" type="text" /><br>
	<input name="sub" type="submit" value="查询" /><br>
	<a href="./register">注册</a>
	<a href="./mailpost">发送提醒</a>
	</form>
	</div>
</body>
</html>