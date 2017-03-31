<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>F&B | Login</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>

	<header>
			<img class="logo" src="<%=request.getContextPath() %>/images/logo.png" alt="F&B"/>	
	</header>

	<div class="contenedorLogin">
		<div class="loginBox">
			<form action="inicio" method="post">
				<h1 class="title">Login</h1>
				<div class="formsec">
					<label for="name">Name: <span class="note">*</span><input
						type="text" name="name" id="name" placeholder="Username here"
						required="required" autofocus /></label>
				</div>
				<div class="formsec">
					<label for="pass">Password: <span class="note">*</span><input
						type="password" name="pass" id="pass" placeholder="Password here"
						required="required" /></label>
				</div>
				<div class="inputButton">
					<input class="button" type="submit" value="Sign in" /><br />
					<br />
				</div>
			</form>
			
			<div class="inputButton"><a class="button"
					href="<%= request.getContextPath()%>/registro">New Account</a></div>
				
			
		</div>
		<span class="note">* Required fields</span>
	</div>
</body>
</html>