package com.arquitecturajava;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class DataBaseHelper<T>{
	
	private static final Logger log = Logger.getLogger(DataBaseHelper.class.getPackage().getName());
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/arquitecturajava";
	private static final String USUARIO = "root";
	private static final String CLAVE = "root";
	
	public int modificarRegistro(String consultaSQL){
		
		Connection conexion = null;
		Statement sentencia = null;
		int filasAfectadas = 0;
		
		try{
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL,USUARIO, CLAVE);
			sentencia = conexion.createStatement();
			filasAfectadas = sentencia.executeUpdate(consultaSQL);
			
		}catch(ClassNotFoundException e){
			
			//System.out.println("Error de driver: " + e.getMessage());
			log.error("Error de acceso al driver:" + e.getMessage());
			throw new DataBaseException("Clase no encontrada.",e);
			
		}catch(SQLException e){
			
			//System.out.println("Error de SQL: "+ e.getMessage());
			log.error("Error de SQL:" + e.getMessage());
			throw new DataBaseException("Error de SQL",e);
			
		}finally{
			
			if(sentencia != null){
				try{
					sentencia.close();
				}catch(SQLException e){
					System.out.println("Error cerrando la sentencia" + e.getMessage());
					throw new DataBaseException("Error de SQL",e);
				}
			}
			if(conexion != null){
				try{
					conexion.close();
				}catch(SQLException e){
//					System.out.println("Error cerrando la conexión " + e.getMessage());
					log.error("Error de SQL:" + e.getMessage());
					throw new DataBaseException("Error de SQL",e);
				}
			}
		}
		
		return filasAfectadas;
		
	}
	
	public List<T> seleccionarRegistros(String consultaSQL, Class<T> clase){
		
		Connection conexion = null;
		Statement sentencia = null;
		ResultSet filas = null;
		List<T> listaDeObjetos = new ArrayList<T>();
		
		try{
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL,USUARIO,CLAVE);
			sentencia = conexion.createStatement();
			
			filas = sentencia.executeQuery(consultaSQL);
			
			while(filas.next()){
				
				T objeto = (T) Class.forName(clase.getName()).newInstance();
				Method[] metodos = objeto.getClass().getDeclaredMethods();
				
				
				for(int i = 0; i < metodos.length; i++){
					
					if(metodos[i].getName().startsWith("set")){
						metodos[i].invoke(objeto,
								filas.getString(metodos[i].getName().substring(3)));
					}
					
					if(objeto.getClass().getName().equals("java.lang.String")){
						objeto = (T) filas.getString(1);
					}
				}
				listaDeObjetos.add(objeto);
			}
		}catch(Exception e){
//			System.out.println("Error al seleccionar registros: " + e.getMessage());
			log.error("Error de SQL:" + e.getMessage());
			throw new DataBaseException("Error de SQL",e);
		}finally{
			
			if (sentencia != null) { 
				try {
					sentencia.close();
					}catch (SQLException e) {
						log.error("Error de SQL:" + e.getMessage());
						throw new DataBaseException("Error de SQL",e);
					} 
			} 
			
			if (conexion != null) { 
			    try {
			    	conexion.close();
			    	}catch (SQLException e) {
			    		log.error("Error de SQL:" + e.getMessage());
			    		throw new DataBaseException("Error de SQL",e);
			    	} 
			}
			
			return listaDeObjetos;
			
		}
	}

}
