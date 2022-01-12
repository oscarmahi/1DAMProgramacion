<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dii.tienda.model.Producto" %>        
    
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
	<h1>Lista de Productos</h1>
    <form action="<%=request.getContextPath()%>" method="post"><!-- Esto es asi pq entra por el servler vacio -->
<%

	ArrayList<Producto> listaProductos = (ArrayList<Producto>) request.getAttribute("listaProducto");

	if(listaProductos!=null) {
		for(int i=0; i<listaProductos.size(); i++) {
	%>
		<div class='listaP'>
			Id Producto: <%= listaProductos.get(i).getIdProducto() %> <br/>
			NombreProducto: <%= listaProductos.get(i).getNombreProducto() %><br/>
			PrecioProducto: <%= listaProductos.get(i).getPrecioProducto() %><br/>
			<label for="unidades: ">Introduce numero de unidades para la cesta: </label>
			<input type="text" name="<%=i %>" placeholder="unidades"/>	
		</div>
  		<!--<input type="submit" value="Añadir productos a la cesta"><br/>-->
  		-----------------------------------------------------------------------------------------------------
        <br/>
	<%	
		}
	}
	%>
	<input type="hidden" name="operacion" value="listar"/>
	<input type="submit" value="Añadir productos a la cesta" class="boton">
	</form>
	<br/><br/>
	<form action="<%=request.getContextPath()%>" method="post">
        <input type="hidden" name="operacion" value="login"/>
        <input type="submit" value="Acceder como usuario" class="boton">
	</form>
	<%
	String m = (String) request.getAttribute("mensaje");
	
	if (m != null) {
		%>
		<script>
			alert("<%=m%>");
		</script>
	<%
	}
	%>		
</body>
</html>