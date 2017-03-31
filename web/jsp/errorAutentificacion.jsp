<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<center>
		<h1 class="destacable">Username or password is not correct</h1>

		<a class="button" href="<%=request.getContextPath()%>/inicio">Retry</a>
	</center>
</body>
</html>