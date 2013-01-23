package com.arquitecturajava.aplicacion.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.controlador.acciones.Accion;
import com.arquitecturajava.aplicacion.controlador.acciones.BorrarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.FiltrarLibrosPorCategoriaAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.FormularioEditarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.FormularioInsertarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.InsertarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.ModificarLibroAccion;
import com.arquitecturajava.aplicacion.controlador.acciones.MostrarLibrosAccion;

public class ControladorLibros extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher despachador = null;
        Accion accion = null;
        
        if (request.getServletPath().equals("/MostrarLibros.do")) {
            
            accion = new MostrarLibrosAccion();
            
        } else if (request.getServletPath().equals(
                "/FormularioInsertarLibro.do")) {
            
            accion = new FormularioInsertarLibroAccion();
            
        } else if (request.getServletPath().equals("/InsertarLibro.do")) {
            
            accion = new InsertarLibroAccion();
            
        } else if (request.getServletPath().equals("/BorrarLibro.do")) {
            
            accion = new BorrarLibroAccion();
            
        } else if (request.getServletPath().equals("/FormularioEditarLibro.do")) {
            
            accion = new FormularioEditarLibroAccion();
            
        } else if (request.getServletPath().equals("/SalvarLibro.do")) {
            
            accion = new ModificarLibroAccion();
            
        } else if (request.getServletPath().equals("/filtrar.do")) {
            
            accion = new FiltrarLibrosPorCategoriaAccion();
            
        }
        
        despachador = request.getRequestDispatcher(accion.ejecutar(request,
                response));
        
        despachador.forward(request, response);
        
    }
}
