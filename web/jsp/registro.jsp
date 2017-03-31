<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.centro.controlador.managers.RegisterManager"
	import="com.centro.modelo.Cliente" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>F&B | New Account</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>

<body>

	<header>
		<img class="logo" src="<%=request.getContextPath() %>/images/logo.png" alt="F&B"/>
	</header>

	<div class="contenedorReg">
	<div class="regBox">

			<%//Si hay sesion guardada con los datos del usuario se añadirán%>
			<%Cliente cli = new Cliente();
				RegisterManager rm = new RegisterManager();%>

			<form action="registro" method="post">

				<jsp:useBean id="usuario" class="com.centro.modelo.Cliente"
					scope="session" />

				<%cli = (Cliente) session.getAttribute("usuario");%>

				<h1 class="title">Registration form</h1>
				<div class="formsec">
					<label for="nombreUsu">User name: <span class="note">*</span><input
						type="text" name="nombreUsu" id="nombreUsu"
						placeholder="Choose a username" required="required" autofocus
						value="<%=rm.getValor(cli.getNombreUsu())%>" maxlength="20" /></label>
						
					<%if (session.getAttribute("nombreExistente") != null) {%>
					<div class="formsec"><span class="note">
						<%out.print(session.getAttribute("nombreExistente"));%>
					</span></div>
					<%}%>
					
				</div>

				<div class="formsec">
					<label for="nombre">Your first name: <span class="note">*</span><input
						type="text" name="nombre" id="nombre"
						placeholder="Your first name here" required="required"
						value="<%=rm.getValor(cli.getNombre())%>" maxlength="30" /></label>
				</div>
				<div class="formsec">
					<label for="apellidos">Your last name: <span class="note">*</span><input
						type="text" name="apellidos" id="apellidos"
						placeholder="Your last name here" required="required"
						value="<%=rm.getValor(cli.getApellidos())%>" maxlength="45" /></label>
				</div>
				<div class="formsec">
					<label for="dni">Your NIF here: <span class="note">*</span><input
						type="text" name="dni" id="dni" placeholder="Ex. 12345678x"
						required="required" value="<%=rm.getValor(cli.getDni())%>"
						maxlength="9" /></label>
				</div>
				<div class="formsec">
					<label for="email">Your email: <span class="note">*</span><input
						type="email" name="email" id="email"
						placeholder="example@mail.com" required="required"
						value="<%=rm.getValor(cli.getEmail())%>" maxlength="30" /></label>
				</div>
				<div class="formsec">
					<label for="pass">Password: <span class="note">*</span><input
						type="password" name="pass" id="pass" placeholder="Password here"
						required="required" maxlength="4" /></label>
				</div>
				<div class="formsec">
					<label for="pass2">Write again Password: <span class="note">*</span><input
						type="password" name="pass2" id="pass2"
						placeholder="Write again Password here" required="required"
						maxlength="4" /></label>
				</div>
				<%if (session.getAttribute("passMal") != null) {%>
				
				<div class="formsec">
					<span class="note">
					<%out.print(session.getAttribute("passMal"));%>
				</span></div>
					<%}%>

				<div class="formsec">
					<label for="direccion">Add your Address: <textarea
							name="direccion" id="direccion" cols="100" rows="4"
							placeholder="Ex. C/Licenciado 3, 1ºB Bilbao Bizkaia 48010 "
							maxlength="200"><%=rm.getValor(cli.getDireccion())%></textarea></label>
				</div>

				<div class="formsec">
					<label for="telefono">Your Phone Number: <input
						type="number" name="telefono" id="telefono"
						placeholder="Ex. 600123456" maxlength="11" /></label>
				</div>

				<div class="formsec">
					<span class="note">* Required fields</span>
				</div>
				<div class="inputButton">
					<input class="button" type="submit" value="Create new account" /><br />
					<br />
				</div>

				<jsp:setProperty name="usuario" property="*" />

			</form>

		
		<div class="inputButton">
			<a class="button" href="<%=request.getContextPath()%>/inicio">Sign
				In</a>
		</div>
		</div>
	</div>
	<jsp:include page='frag/footer.jsp'>
    <jsp:param name="footer" value=""/>
</jsp:include>
</body>
</html>