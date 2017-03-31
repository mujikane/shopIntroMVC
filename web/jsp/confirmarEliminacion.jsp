<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"
	import="com.centro.modelo.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>F&B | Unsuscribe</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>

<%
	Cliente cli = (Cliente) request.getSession()
			.getAttribute("usuario");
	String nombreUsu = cli.getNombre() + " " + cli.getApellidos();
%>
<body>
	<center>
		<form action="unsuscribe" method="post">
			<h1 class="destacable"><%=nombreUsu%>,
			</h1>
			<h1 class="destacable">Are you sure you want to unsubscribe ?</h1>

			<div class="inputButton">
				<input class="button" type="submit" id="submit" name="submit"
					value="No" /><br /> <br />
			</div>
			<div class="inputButton">
				<input class="button" type="submit" id="submit" name="submit"
					value="Yes" /><br /> <br />
			</div>

		</form>

	</center>
</body>
</html>