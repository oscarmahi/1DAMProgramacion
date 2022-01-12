<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Tienda DAM</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login1.css"/>
</head>
<body>
	<img src="<%=request.getContextPath()%>/imagenes/miterisPP.jpg" class="right"></img>
	<%
	String usuarioActivo = (String) request.getSession().getAttribute("usuarioSesion");
	String usuarioNull="";
	if (usuarioActivo != null){
		usuarioNull = usuarioActivo;
	}
	%>
	<h5>Usuario activo: <%= usuarioNull %></h5>
	<hr/>
	<h1>Validacion de usuario</h1>
	<form action="<%=request.getContextPath()%>" method="post">
		<label for="user">Usuario: </label>
		<input type="text" name="user" placeholder="Introduce tu usuario"/>
		<br/>
		<label for="pass">Password: </label>
		<input type="password" name="pass" placeholder="Introduce tu contraseña"/>
		<br/><br/>
		<input type="hidden" name="operacion" value="consultaLogin"/>
		<button type="submit" name="consultaLogin">INICIAR SESION</button>
		<br/>
	</form>
	<br/><br/>
	<hr/>
	<h1>Grabar usuario nuevo</h1>
	<form action="<%=request.getContextPath()%>" method="post">
		<label for="user">Usuario: </label>
		<input type="text" name="user" placeholder="Introduce tu usuario"/>
		<br/>
		<label for="pass">Password: </label>
		<input type="password" name="pass" placeholder="Introduce tu contraseña"/>
		<br/>
		<label for="pass2">Repite Password: </label>
		<input type="password" name="pass2" placeholder="Repite tu contraseña"/>
		<br/><br/>
		<input type="hidden" name="operacion" value="grabarLogin"/>
		<button type="submit" name="grabarLogin">GRABAR</button>
		<br/>
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