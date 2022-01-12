<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dii.tienda.model.LineaCarrito" %>       
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Tienda DAM</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index1.css"/>
</head>
<body>
	<img src="<%=request.getContextPath()%>/imagenes/miterisPP.jpg" class="right"></img>
	<%
	String usuarioActivo = (String) request.getSession().getAttribute("usuarioSesion");
	%>
	<h5>Usuario activo: <%= usuarioActivo %></h5>
	<hr/>
	<h1>Cesta de Productos</h1>
	<br/>
	<form action="<%=request.getContextPath()%>" method="post">
<%	
	ArrayList<LineaCarrito> listaCesta = (ArrayList<LineaCarrito>) request.getSession().getAttribute("listaCarrito");

	if(listaCesta!=null) {
		for(int i=0; i<listaCesta.size(); i++) {
	%>
		<div class='listaCesta'>
			Id Producto: <%= listaCesta.get(i).getIdProducto() %> <br/>
			NombreProducto: <%= listaCesta.get(i).getNombreProducto() %><br/>
			PrecioProducto: <%= listaCesta.get(i).getPrecio() %><br/>
			<label for="unidades: ">Unidades en la cesta: </label>
			<input type="text" name="<%=i %>" value=" <%= listaCesta.get(i).getUnidades() %> "/>	
			
		</div>
  		-----------------------------------------------------------------------------------------------------
        <br/>
	<%	
		}
	}
	%>
	<input type="hidden" name="operacion" value="cesta"/>
	<input type="submit" value="Confirmar cesta" class="boton"><br/>
	</form>
	


</body>
</html>