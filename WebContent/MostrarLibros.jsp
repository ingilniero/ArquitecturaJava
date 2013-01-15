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
	<form action="MostrarLibros.jsp" method="get">
		<select name="categoria">
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
		<input type="submit" value="Filtrar">
		</form>
		<br>
<%  
 
List<Libro> listaDeLibros = null;
String categoria = request.getParameter("categoria");

if(categoria == null || categoria.equals("seleccionar")){
	listaDeLibros = Libro.buscarTodos();	
}else{
	listaDeLibros = Libro.buscarPorCategoria(categoria);
}


  for(Libro libro:listaDeLibros) { %> 
    <%=libro.getISBN()%> 
    <%=libro.getTitulo()%> 
    <%=libro.getCategoria()%> 
    <a href="BorrarLibro.jsp?isbn=<%=libro.getISBN()%>">Borrar</a>
    <a href="FormularioEditarLibro.jsp?isbn=<%=libro.getISBN()%>">Editar</a>
    <br/>    
<% } 
%> 
<a href="FormularioInsertarLibro.jsp">Insertar Libro</a> 
</body></html> 