

<header>

	<div class="headerContainer">
		<div class="contenedorHeader">
			<div class="headLogo">
				<a href="<%=request.getContextPath()%>/inicio"><img class="logo" src="<%=request.getContextPath() %>/images/logo.png" alt="F&B"/></a>
				<h1 class="wellcome">
					Welcome 
					<span class="destacable"> 
					<%
 					HttpSession sesion = request.getSession();

 					//Si es nueva la sesión y ya no tenemos datos que nos dirija al timeout.jsp
 					if (sesion.isNew()) {
 						request.getRequestDispatcher("timeout").forward(request, response);
 					} else {
 					//Se puede llamar a una clase del modelo aunque también se podría haber guardado otro atributo de la sesión que fuese
 					//"nombreUsuario" aunque hay que hacer casting

 						com.centro.modelo.Cliente usu = (com.centro.modelo.Cliente) sesion.getAttribute("usuario");
 						out.print(usu.getNombreUsu());
 					}
 					%>
					</span>
				</h1>
			</div>
		</div>
		<div class="clear"></div>

		<%
			String elegido = (String) request.getSession().getAttribute("menu");
			String ele = "class='destacable'";
			String img1 = "/images/home.png";
			String img2 = "/images/home2.png";
		%>
		<div class="contendorHeader">
			<nav>
				<div class="menu">
					<ul class="navMenu">
						<li class="menuItem"><a <%if (elegido.equals("logout")) {%> <%=ele%> <%}%>
						href="<%=request.getContextPath()%>/logout">Logout</a></li>
						<li class="menuItem"><a <%if (elegido.equals("cart")) {%> <%=ele%> <%}%>
						href="<%=request.getContextPath()%>/carrito">Cart</a></li>
						<li class="menuItem"><a <%if (elegido.equals("profile")) {%> <%=ele%> <%}%>
						href="<%=request.getContextPath()%>/profile">Profile</a></li>
						<li class="menuItem"><a <%if (elegido.equals("productos")) {%> <%=ele%> <%}%>
						href="<%=request.getContextPath()%>/inicio">Products</a></li>
						<li><a href="<%=request.getContextPath()%>/inicio"><img
							class="home"
							src="<%if (elegido.equals("inicio")) {%><%=request.getContextPath() + img2%><%} else {%><%=request.getContextPath() + img1%><%}%>" /></a></li>
					</ul>
				</div>
			</nav>
		</div>

		<div class="clear"></div>
	</div>
</header>
