<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.Statement" %> 
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.sql.SQLException" %> 
<%@ page import="java.sql.ResultSet" %> 
<%@ page import="java.util.List" %> 
<%@ page import="com.arquitecturajava.*" %> 
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
<%		
	List<String> listaDeCategorias = null;
	listaDeCategorias = (List<String>) request.getAttribute("listaDeCategorias"); 
// 	listaDeCategorias = Libro.buscarTodasLasCategorias(); 
		
		for(String categoria:listaDeCategorias){
%>
<option value="<%=categoria%>">
		<%=categoria%>
</option>
<%
		}
%>
		</select>
		<input type="submit" value="Filtrar">
		</form>
		<br>
<%  
 
List<Libro> listaDeLibros = (List<Libro>) request.getAttribute("listaDeLibros");


  for(Libro libro:listaDeLibros) { %> 
    <%=libro.getISBN()%> 
    <%=libro.getTitulo()%> 
    <%=libro.getCategoria()%> 
    <a href="BorrarLibro.do?isbn=<%=libro.getISBN()%>">Borrar</a>
    <a href="FormularioEditarLibro.do?isbn=<%=libro.getISBN()%>">Editar</a>
    <br/>    
<% } 
%> 
<a href="FormularioInsertarLibro.do">Insertar Libro</a> 
</body></html> 