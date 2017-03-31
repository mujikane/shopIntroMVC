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
<title>F&B | Welcome</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<% request.getSession().setAttribute("menu", "productos"); %>
<body>
	<%@include file="frag/header.jsp" %>

	<div class="bar"></div>
	<div class="contenedor">
		<h1>
			Offers of <span class="destacable"> <%
			//Obtenemos la fecha actual y la mostramos en la pagina
			java.util.Calendar fecha = java.util.Calendar.getInstance();
			out.println(fecha.get(java.util.Calendar.DATE) + "-"
			  + (fecha.get(java.util.Calendar.MONTH)+1)    + "-"
			  + fecha.get(java.util.Calendar.YEAR));
			
			%>

			</span>
		</h1>
		<%ArrayList<Producto> productos = new ArrayList<Producto>();
		Producto product = new Producto();
		productos = (ArrayList) request.getSession().getAttribute("productos");
		%>
		<!-- Product List -->

		<div class="contenedorProd">
			<ul class="prductos">
			<c:forEach items="${productos}" var="prod">
			
				<li class="producto">
						
					<a href="<%=request.getContextPath()%>/producto?prod=${prod.idProducto}" title="${prod.nombre}">
						<div class="productImage">
							<img class="pequenya" src="<%=request.getContextPath()%>/images/products/min-${prod.imagen}" alt="${prod.nombre}"/>
						</div>
						<div class="prodtitle">
							<div class="precios">
								<del class="precioAnt">${prod.precioAnterior}</del>
								<span class="precio">${prod.precio} &#8364</span>
							</div>
							<h3>${prod.nombre}</h3>
						</div>
					</a>

				</li>
				
			</c:forEach>
				
			</ul>
		
		</div> 
		<div class="bar"></div>

	</div>

<jsp:include page='frag/footer.jsp'>
    <jsp:param name="footer" value=""/>
</jsp:include>
</body>
</html>