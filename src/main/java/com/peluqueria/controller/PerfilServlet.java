package com.peluqueria.controller;

import com.peluqueria.dao.UsuarioDAO;
import com.peluqueria.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// La anotación @WebServlet mapea este servlet a la URL "/perfil"
@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
    
    // Serialización del servlet, asegura que el objeto del servlet sea consistente entre distintas invocaciones
    private static final long serialVersionUID = 1L;
    
    // Declaración de un objeto UsuarioDAO para interactuar con la base de datos
    private UsuarioDAO usuarioDAO;
    
    // El método init() se ejecuta una sola vez al inicializar el servlet
    public void init() {
        // Inicializa el objeto usuarioDAO, que contiene los métodos para interactuar con la base de datos
        usuarioDAO = new UsuarioDAO();
    }
    
    // Método que maneja las solicitudes HTTP GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Supongamos que el ID del usuario es 1 en este ejemplo
        int id = 1;
        
        // Llama al método selectUsuario del DAO para obtener el usuario de la base de datos con el ID proporcionado
        Usuario usuario = usuarioDAO.selectUsuario(id);
        
        // Establece el objeto 'usuario' como atributo en la solicitud (request), para que se pueda acceder en la vista
        request.setAttribute("usuario", usuario);
        
        // Obtiene un Dispatcher para redirigir la solicitud a la página JSP de perfil (perfil.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/perfil.jsp");
        
        // Realiza el forward a la página JSP, enviando la solicitud y la respuesta a la vista
        dispatcher.forward(request, response);
    }
}
