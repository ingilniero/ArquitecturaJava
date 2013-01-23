package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.Libro;

public class ModificarLibroAccion extends Accion {
    
    @Override
    public String ejecutar(HttpServletRequest request,
            HttpServletResponse response) {
        
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        
        Libro libro = new Libro(isbn, titulo, categoria);
        
        libro.salvar();
        
        return "MostrarLibros.do";
    }
    
}
