

<footer>

	<div class="footerContainer">
		<div class="contenedorFooter">
			<div class="headLogo">
				<a href="#"><img class="logo" src="<%=request.getContextPath() %>/images/logo.png" alt="F&B"/></a>
			</div>
		</div>
		<div class="clear"></div>

		<%
			String elegido = (String) request.getSession().getAttribute("menu");
			String ele = "class='destacable'";
			String img1 = "/images/home.png";
			String img2 = "/images/home2.png";
		%>
		<div class="contendorFooter">
			<p>Copyleft Ane Mugica urbina 2016</p>
		</div>
			

		
	</div>
</header>
