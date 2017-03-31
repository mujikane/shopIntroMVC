<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"
	import="com.centro.modelo.Cliente" import="com.centro.modelo.Producto" import="com.centro.modelo.Carrito" import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	//Si expira la sesion que nos redirija a la pagina de timeout.jsp
%>
<meta http-equiv="refresh"
	content="<%=session.getMaxInactiveInterval()%>; url=timeout" />
<title>F&B | Cart</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css">
</head>
<% request.getSession().setAttribute("menu", "cart"); %>
<body>
	<%@include file="frag/header.jsp"%>
	<%
		Cliente cli = (Cliente) request.getSession().getAttribute("usuario");
		ArrayList<Carrito> pedidos = new ArrayList<Carrito>();
		Carrito pedido = new Carrito();
		pedidos = (ArrayList) request.getSession().getAttribute("pedidos");

	%>
	
	<div class="bar"></div>
	<div class="contenedorCart">
		<div class="cartBox">
			<h1 class="title">
				Your Cart <span class="destacable"> </span>
			</h1>

			<form action="confirm" method="post">

				<table class="cartTable">
				<thead>
					<tr class="cartFila">
						<th class="cartTit">Product name</th>
						<th class="cartTit">Image</th>
						<th class="cartTit">Quantity</th>
						<th class="cartTit">Unit Price</th>
						<th class="cartTit">Price</th>
						<th class="cartTit">&nbsp;</th>
					</tr>
				</thead>
				</tbody>	
			<c:set var="total" value="0"/>
			<%if (pedidos.size() != 0){ %>
				<c:forEach items="${pedidos}" var="pedido">
				<c:if test="${pedido.cantidad != 0}">
					<tr class="cartFila">
						<td class="cartElem">${pedido.prod.nombre}</td>
						<td class="cartElem"><img src="<%=request.getContextPath()%>/images/products/min-${pedido.prod.imagen}" alt="${pedido.prod.nombre}"/></td>
						<td class="cartElem">${pedido.cantidad}</td>
						<td class="cartElem">${pedido.prod.precio}</td>
						<c:set var="precio" value="${pedido.prod.precio}"/>
						<c:set var="cant" value="${pedido.cantidad}"/>
						<td class="cartElem">${precio*cant} </td>
						<td class="cartElem"><input type="radio" name="radio" id="radio" value="${pedido.prod.idProducto}"/>Delete</td>
						<c:set var="total" value="${total + (precio*cant) }"/>
					</tr>
					</c:if>
				</c:forEach>
				<tr>
				<td class="total" colspan="6">Total : ${total}  &#8364</td>
				</tr>
				</tbody>
				</table>
			<%}else{%>
				<tr>
				<td class="total" colspan="6">Total : ${total}  &#8364</td>
				</tr>
				</tbody>
				</table>
				
				<h1 span="destacable">There isn't products in your chart</h1>
				<%} %>	
				
				<div class="inputButton">
					<input class="button" type="submit" id="submit" name="submit" value="Confirm delete" /><br />
					<br />
				</div>
				<div class="inputButton">
					<input class="button" type="submit" id="submit" name="submit" value="Confirm and checkout" /><br />
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