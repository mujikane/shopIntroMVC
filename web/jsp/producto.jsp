<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true" import="com.centro.modelo.Cliente" import="com.centro.modelo.Producto" import="java.util.ArrayList"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%//Si expira la sesion que nos redirija a la pagina de timeout.jsp %>
<meta http-equiv="refresh"
	content="<%= session.getMaxInactiveInterval() %>; url=timeout" />
<title>F&B | Product</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<% request.getSession().setAttribute("menu", "inicio");
%>


<body>


<jsp:useBean id="producto" class="com.centro.modelo.Producto" scope="session" />
	<%@include file="frag/header.jsp" %>

	<div class="bar"></div>
	<div class="contenedor">
		<h1>
			<span class="destacable"><jsp:getProperty name="producto" property="nombre" /></span>
		</h1>
		
		
		<!-- Product List -->

		<div class="contenedorProd">
			<div class="prodImage">
				<div class="productImage">
					<img src="<%=request.getContextPath()%>/images/products/<jsp:getProperty name="producto" property="imagen" />" alt="<jsp:getProperty name="producto" property="nombre" />"/>
				</div>
			</div>
			<div class="prodDescr">
				<div class="contDescr">
					<form action="carrito" method="post">
						<h1><jsp:getProperty name="producto" property="nombre" /></h1>
						<div class="precios">
							<del class="precioAnt-grande"><jsp:getProperty name="producto" property="precioAnterior" /></del> 
							<span class="precio-grande"><jsp:getProperty name="producto" property="precio" /> &#8364</span>
						</div>
						<div class="descr">
							<p><jsp:getProperty name="producto" property="descripcion" /></p>
						</div>
						
						<div class="cantidad">
							<div class="cant">
								<h1 class="destacable">Quantity: </h1>
							
								<input type="number" name="cantidad" id="cantidad" step="1" min="1" max="10" maxlength="2" value="1"/>
							</div>	
						</div>
						
						<br/><br/>
						<div class="inputButton">
							<input class="button" type="submit" value="Add to cart" /><br />
							<br />
						</div>
					</form>
				</div>
			</div>
		</div> 
		<div class="bar"></div>

	</div>

<jsp:include page='frag/footer.jsp'>
    <jsp:param name="footer" value=""/>
</jsp:include>

</body>
</html>