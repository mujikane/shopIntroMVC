<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"
	import="com.centro.modelo.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	//Si expira la sesion que nos redirija a la pagina de timeout.jsp
%>
<meta http-equiv="refresh"
	content="<%=session.getMaxInactiveInterval()%>; url=timeout" />
<title>F&B | Profile</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<% request.getSession().setAttribute("menu", "profile"); %>
<body>
	<%@include file="frag/header.jsp"%>
	<%
		Cliente cli = (Cliente) request.getSession()
				.getAttribute("usuario");
	%>

	<div class="bar"></div>
	<div class="contenedorProfile">
		<div class="profileBox">
			<h1 class="title">
				Your profile <span class="destacable"> </span>
			</h1>

			<form action="profile" method="post">

				<table class="profileTable">
					<tr class="formsec">
						<td class="tit">User name:</td>
						<td class="tit2"><%=cli.getNombreUsu()%></td>
						<td class="note2" colspan="2">You can´t change your user name</td>
					</tr>
					<tr class="formsec">
						<td class="tit">First Name:</td>
						<td class="tit2"><%=cli.getNombre()%></td>
						<td class="tit3"><input type="button" value="Change First name"
							onclick="document.getElementById('nombre').style.visibility='visible'" /></td>
						<td class="tit4"><input type="text" id="nombre" name="nombre"
							style="visibility: hidden" placeholder="Change your First name" maxlength="30"/></td>
					</tr>
					<tr class="formsec">
						<td class="tit">Last name:</td>
						<td class="tit2"><%=cli.getApellidos()%></td>
						<td class="tit3"><input type="button" value="Change Last name"
							onclick="document.getElementById('apellidos').style.visibility='visible'" /></td>
						<td class="tit4"><input type="text" id="apellidos" name="apellidos"
							style="visibility: hidden" placeholder="Change your Last name" maxlength="45"/></td>
					</tr>
					<tr class="formsec">
						<td class="tit">NIF:</td>
						<td class="tit2"><%=cli.getDni()%></td>
						<td class="tit3"><input type="button" value="Change NIF"
							onclick="document.getElementById('dni').style.visibility='visible'" /></td>
						<td class="tit4"><input type="text" id="dni" name="dni"
							style="visibility: hidden" placeholder="Change you NIF" maxlength="11"/></td>
					</tr>
					<tr class="formsec">
						<td class="tit">Email:</td>
						<td class="tit2"><%=cli.getEmail()%></td>
						<td class="tit3"><input type="button" value="Change email"
							onclick="document.getElementById('email').style.visibility='visible'" /></td>
						<td class="tit4"><input type="email" id="email" name="email"
							style="visibility: hidden" placeholder="Change your email" maxlength="30"/></td>
					</tr>
					<tr class="formsec">
						<td class="tit">Address:</td>
						<td class="tit2"><%=cli.getDireccion()%></td>
						<td class="tit3"><input type="button" value="Change Address"
							onclick="document.getElementById('direccion').style.visibility='visible'" /></td>
						<td class="tit4"><input type="text" id="direccion" name="direccion"
							style="visibility: hidden" placeholder="Change your Address" maxlength="200"/></td>
					</tr>
					<tr class="formsec">
						<td class="tit">Phone Number:</td>
						<td class="tit2"><%=cli.getTelefono()%></td>
						<td class="tit3"><input type="button" value="Change Phone"
							onclick="document.getElementById('telefono').style.visibility='visible'" /></td>
						<td class="tit4"><input type="text" name="telefono" id="telefono"
							style="visibility: hidden" placeholder="Change your Phone number" maxlength="11"/></td>
					</tr>
					<tr class="formsec">
						<td colspan="2" class="tit3"><input type="button" value="Change password"
							onclick="document.getElementById('pass').style.visibility='visible'" /></td>
						<td colspan="2" class="tit4"><input type="password" id="pass" name="pass"
							style="visibility: hidden" placeholder="Change your password" maxlength="4"/></td>
					</tr>
				</table>

				<div class="inputButton">
					<input class="button" type="submit" name="submit" id="submit" value="Save changes" /><br />
					<br />
				</div>
				<div class="inputButton">
					<input class="button" type="submit" name="submit" id="submit" value="Unsubscribe" /><br />
					<br />
				</div>

			</form>
		</div>
	</div>

	</div>
	
<jsp:include page='frag/footer.jsp'>
    <jsp:param name="footer" value=""/>
</jsp:include>

</body>
</html>