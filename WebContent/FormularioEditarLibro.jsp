<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.arquitecturajava.Libro"%>
<%@ page import = "java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<% Libro libro = Libro.buscarPorClave(request.getParameter("isbn")); %>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset ="utf-8">
<title>Editar Libro</title>
<script type="text/javascript" src="js/validacion.js"></script>
<link rel="stylesheet" type="text/css" href="css/formato.css" />
</head>
<body>
	<form action="SalvarLibro.do" id="miformulario" onSubmit="return validacion();">
		<fieldset>
			<legend>Formulario Editar libro</legend>
			<p>
				<label for="isbn">ISBN: </label>
				<input type="text" name="isbn" id="isbn" value="<%= libro.getISBN() %>"/>
			</p>
			<p>
				<label for="titulo">Título: </label>
				<input type="text" name="titulo" id="titulo" value="<%= libro.getTitulo() %>"/>
			</p>
			<p>
				<label for="categoria">Categoría: </label>
				<select name="categoria" id="seleccionar">
					<option value="seleccionar">seleccionar</option>
					<c:forEach var="categoria" items="listaDeCategorias">
					   <option value="${categoria}">${categoria}</option>)
					</c:forEach>
		</select>
			</p>
			<p>
				<input type="submit" value="Salvar"/>
			</p>
		</fieldset> 
	</form>
	<p>
		<a href="MostrarLibros.do">Mostrar Libros</a>
	</p>
</body>
</html>