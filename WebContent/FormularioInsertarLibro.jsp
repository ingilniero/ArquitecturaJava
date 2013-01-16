<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.util.List" %> 
<%@ page import="com.arquitecturajava.*" %> 
<!DOCTYPE html">
<html lang="es">
<head>
<meta charset="utf8">
<title>Fomulario Libro</title>
<script type="text/javascript" src="js/validacion.js"></script>
<link rel="stylesheet" type="text/css" href="css/formato.css" />
</head>
<body>
	<h1>Formulario alta libro</h1>
	<form action="InsertarLibro.jsp" id="miformulario" onSubmit="return validacion();">
		<fieldset>
			<legend>Formulario alta libro</legend>
			<p>
				<label for="isbn">ISBN: </label>
				<input type="text" name="isbn" id="isbn"/>
			</p>
			<p>
				<label for="titulo">Título: </label>
				<input type="text" name="titulo" id="titulo"/>
			</p>
			<p>
				<label for="categoria">Categoría: </label>
				<select name="categoria" id="seleccionar">
					<option value="seleccionar">seleccionar</option>
<%		
		List<String> listaDeCategorias = Libro.buscarTodasLasCategorias();
		
		for(String categoria:listaDeCategorias){
%>
					<option value="<%=categoria%>">
					<%=categoria%>
					</option>
<%
		}
%>
		</select>
			</p>
			<p>
				<input type="submit" value="Insertar"/>
			</p>
		</fieldset> 
	</form>
	<p>
		<a href="MostrarLibros.jsp">Mostrar Libros</a>
	</p>
</body>
</html>