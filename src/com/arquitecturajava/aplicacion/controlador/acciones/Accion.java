package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {
    
    public static Accion getAccion(String tipo) {
        
        Accion accion = null;
        
        if (tipo.contains("/MostrarLibros.do")) {
            
            accion = new MostrarLibrosAccion();
            
        } else if (tipo.contains("/FormularioInsertarLibro.do")) {
            
            accion = new FormularioInsertarLibroAccion();
            
        } else if (tipo.contains("/InsertarLibro.do")) {
            
            accion = new InsertarLibroAccion();
            
        } else if (tipo.contains("/BorrarLibro.do")) {
            
            accion = new BorrarLibroAccion();
            
        } else if (tipo.contains("/FormularioEditarLibro.do")) {
            
            accion = new FormularioEditarLibroAccion();
            
        } else if (tipo.contains("/SalvarLibro.do")) {
            
            accion = new ModificarLibroAccion();
            
        } else if (tipo.contains("/filtrar.do")) {
            
            accion = new FiltrarLibrosPorCategoriaAccion();
            
        } else {
            accion = new MostrarLibrosAccion();
        }
        
        return accion;
        
    }
    
    public abstract String ejecutar(HttpServletRequest request,
            HttpServletResponse response);
}
