package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.Libro;

public class FormularioInsertarLibroAccion extends Accion {
    
    @Override
    public String ejecutar(HttpServletRequest request,
            HttpServletResponse response) {
        
        List<String> listaDeCategorias = null;
        
        listaDeCategorias = Libro.buscarTodasLasCategorias();
        
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        
        return "FormularioInsertarLibro.jsp";
    }
}
