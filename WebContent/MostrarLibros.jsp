<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.Statement" %> 
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.sql.SQLException" %> 
<%@ page import="java.sql.ResultSet" %> 
<%@ page import="java.util.List" %> 
<%@ page import="com.arquitecturajava.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html> 
<html lang="es"> 
	<head> 
		<meta charset = "UTF8"> 
		<title>Lista de Libros</title> 
	</head> 
	<body>
	<form action="filtrar.do" method="get">
		<select name="categoria">
			<option value="seleccionar">seleccionar</option>
			<c:forEach var="categoria" items="${listaDeCategorias}">
			<option value="${categoria}">${categoria}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Filtrar">
		</form>
		<br>
		<c:forEach var="libro" items="${listaDeLibros}">
		  ${libro.ISBN}${libro.titulo}${libro.categoria}
		  <a href="BorrarLibro.do?isbn=${libro.ISBN}">borrar</a>
		  <a href="FormularioEditarLibro.do?isbn=${libro.ISBN}">editar</a>
		  <br/>
		 </c:forEach>
		 

<a href="FormularioInsertarLibro.do">Insertar Libro</a> 
</body></html> 