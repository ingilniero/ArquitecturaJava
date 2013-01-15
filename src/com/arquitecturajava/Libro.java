package com.arquitecturajava;

import java.sql.SQLException;
import java.util.List;

public class Libro {
	
	private String isbn;
	private String titulo;
	private String categoria;
	
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	public String getISBN(){
		return this.isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Libro(){
		super();
	}
	
	public Libro(String isbn, String titulo,String categoria){
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}
	
	
	public static List<String> buscarTodasLasCategorias(){ 
	    
		String consultaSQL = "SELECT DISTINCT(categoria) FROM libros"; 
	    DataBaseHelper<String> helper = new DataBaseHelper<String>(); 
	     
	    List<String> listaDeCategorias = helper.seleccionarRegistros(consultaSQL, String.class);
	    
	    return listaDeCategorias; 
	} 
	
	public  void insertar(){ 
	    
		String consultaSQL = "INSERT INTO libros (isbn,titulo,categoria) VALUES "; 
	    consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')"; 
	    
	    DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>(); 
	    
	    helper.modificarRegistro(consultaSQL); 
	} 
	
	public static  List<Libro> buscarTodos() { 
	    
		String consultaSQL = "SELECT isbn,titulo,categoria FROM libros";
	    DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
	    List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
	    
	    return listaDeLibros; 
	}
	
	public void borrar()throws DataBaseException{
		
		String consultaSQL = "DELETE FROM libros WHERE isbn = '" + this.isbn + "'";
		
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		
		helper.modificarRegistro(consultaSQL);
		
	}
	
	public static Libro buscarPorClave(String isbn){
		
		String consultaSQL = "SELECT isbn, titulo, categoria FROM libros WHERE isbn = '" + isbn +"'";
		
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		
		List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
		
		return listaDeLibros.get(0);								
	}
	
	public void salvar(){
		String consultaSQL = "UPDATE libros SET" +
													" titulo = '" + this.titulo + "'," +
													" categoria = '" + this.categoria + "' "+
													" WHERE isbn = '" + this.isbn + "'";
		
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		helper.modificarRegistro(consultaSQL);
	}
	
	public static List<Libro> buscarPorCategoria(String categoria){
		
		String consultaSQL = "SELECT isbn, titulo, categoria FROM libros WHERE categoria = '" + categoria +"'";
		
		DataBaseHelper<Libro> helper = new DataBaseHelper<Libro>();
		
		List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
		
		return listaDeLibros;
	}
}



















