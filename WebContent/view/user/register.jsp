<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="/oucect/js/jquery-2.2.3.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="./register" method="post">
	<h1>用户注册</h1>
	用户名：<input id="acc" type="text" name="account" onchange="go()"><br><br>
	密码：<input type="text" name="password"><br><br>   
	email:<input type="text" name="mail" ><br><br>
	<input type="submit" value="注册"/>
	<a href="./index">返回</a>
	</form>
	<script type="text/javascript">
	function go(){
		var account = $("#acc").val();
		$.ajax({
            type: "POST",
            url: "/oucect/inputajax",
            data: {account:	$("#acc").val()},
            dataType: "json",
            success: function(req){
            	$("#ac").text(req.text);
            }
        });
	}
	</script>
</body>
</html>