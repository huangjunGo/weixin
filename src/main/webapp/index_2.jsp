<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OpenId</title>
</head>
<body>
	<%
		String openid="--";
		openid=request.getParameter("openId");
	%>
	Openid------->>><%=openid %>
</body>
</html>