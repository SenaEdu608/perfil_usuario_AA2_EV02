package com.peluqueria.controller;

import com.peluqueria.dao.UsuarioDAO;
import com.peluqueria.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Anotación para mapear este servlet a la URL "/editar"
@WebServlet("/editar")
public class EditarServlet extends HttpServlet {
    // Serialización del servlet para asegurar la consistencia en la sesión
    private static final long serialVersionUID = 1L;
    
    // Instancia del objeto UsuarioDAO que interactuará con la base de datos
    private UsuarioDAO usuarioDAO;
    
    // Método init() que se ejecuta una vez al inicializar el servlet
    public void init() {
        // Inicializa el objeto usuarioDAO para usarlo en los métodos
        usuarioDAO = new UsuarioDAO();
    }
    
    // Método que maneja las solicitudes HTTP GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Para este ejemplo, suponemos que el ID del usuario es 1
        int id = 1;
        
        // Llama al método selectUsuario del DAO para obtener los datos del usuario
        Usuario usuario = usuarioDAO.selectUsuario(id);
        
        // Establece el objeto usuario como atributo en la solicitud, para que se pueda acceder desde la vista
        request.setAttribute("usuario", usuario);
        
        // Obtiene un dispatcher para redirigir a la página editar.jsp, donde se mostrará el formulario
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/editar.jsp");
        
        // Realiza el forward, enviando la solicitud a la vista
        dispatcher.forward(request, response);
    }
    
    // Método que maneja las solicitudes HTTP POST (cuando se envía el formulario)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ID del usuario que se va a editar (en este caso, el ID es fijo en 1 para el ejemplo)
        int id = 1; 
        
        // Obtiene los parámetros enviados desde el formulario (nombre, correo, teléfono, dirección)
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        
        // Crea un objeto Usuario con los nuevos datos
        Usuario usuario = new Usuario(id, nombre, correo, telefono, direccion);
        
        try {
            // Llama al método updateUsuario del DAO para actualizar la información en la base de datos
            usuarioDAO.updateUsuario(usuario);
        } catch (SQLException e) {
            // Si ocurre algún error con la base de datos, lo imprime en la consola
            e.printStackTrace();
        }
        
        // Redirige al servlet que maneja la vista del perfil después de la actualización
        response.sendRedirect("perfil");
    }
}
