<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>F&B | Time out</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<center>
		<h1 class="destacable">Session timeout</h1>
		<p>Sorry, your session timed out after a long time of inactivity.</p>
		<p>Please sign in again.</p>

		<a class="button" href="<%=request.getContextPath()%>/inicio">Sign In</a>
	</center>
</body>
</html>