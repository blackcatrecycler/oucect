<%@page import="java.nio.file.Path"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% HttpSession hs = request.getSession(); %>
<script type="text/javascript" src="/oucect/js/jquery-2.2.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h1>查询结果</h1>
区域：${area}<br>
楼号：${house}<br>
房间号：${room }<br>
电量情况：${ect1 }<br>
<button id="bu" onclick="go()" >返回</button>
<script type="text/javascript">
	function go(){
		window.location.href="/oucect/user/index";
	}
</script>
</div>
</body>
</html>