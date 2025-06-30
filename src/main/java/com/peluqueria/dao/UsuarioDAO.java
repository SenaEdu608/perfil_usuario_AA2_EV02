package com.peluqueria.dao;

import com.peluqueria.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // URL de la base de datos MySQL (se conecta al puerto 3306, base de datos "perfil_datos")
    private String jdbcURL = "jdbc:mysql://localhost:3306/perfil_datos?useSSL=false";
    
    // Credenciales de la base de datos
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    // Consultas SQL predefinidas
    private static final String INSERT_USUARIO_SQL = "INSERT INTO edicion_datos (nombre, correo, telefono, direccion) VALUES (?, ?, ?, ?);";
    private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM edicion_datos WHERE id = ?";
    private static final String SELECT_ALL_USUARIOS = "SELECT * FROM edicion_datos";
    private static final String UPDATE_USUARIO_SQL = "UPDATE edicion_datos SET nombre = ?, correo = ?, telefono = ?, direccion = ? WHERE id = ?;";

    // Método para obtener la conexión con la base de datos
    protected Connection getConnection() {
        Connection connection = null;
        try {
            // Carga el controlador JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Se conecta a la base de datos usando la URL, el usuario y la contraseña
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Si ocurre un error, se imprime en la consola
        }
        return connection;
    }
    
    // Método para insertar un nuevo usuario en la base de datos
    public void insertUsuario(Usuario usuario) throws SQLException {
        // Establece la conexión y prepara la consulta SQL
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIO_SQL)) {
            // Establece los parámetros de la consulta (los valores del usuario)
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getCorreo());
            preparedStatement.setString(3, usuario.getTelefono());
            preparedStatement.setString(4, usuario.getDireccion());
            // Ejecuta la consulta para insertar los datos
            preparedStatement.executeUpdate();
        }
    }
    
    // Método para seleccionar un usuario por su ID
    public Usuario selectUsuario(int id) {
        Usuario usuario = null;
        // Establece la conexión y prepara la consulta SQL
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIO_BY_ID)) {
            // Establece el ID del usuario que se desea buscar
            preparedStatement.setInt(1, id);
            // Ejecuta la consulta y obtiene el resultado
            ResultSet rs = preparedStatement.executeQuery();
            
            // Si se encuentra el usuario, se mapean los resultados
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                // Crea un objeto Usuario con los datos obtenidos
                usuario = new Usuario(nombre, correo, telefono, direccion);
                usuario.setId(id); // Establece el ID del usuario
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Si ocurre un error, se imprime en la consola
        }
        return usuario; // Retorna el usuario o null si no se encuentra
    }
    
    // Método para seleccionar todos los usuarios de la base de datos
    public List<Usuario> selectAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        // Establece la conexión y prepara la consulta SQL
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS)) {
            // Ejecuta la consulta y obtiene los resultados
            ResultSet rs = preparedStatement.executeQuery();
            
            // Recorre todos los resultados y crea objetos Usuario
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                // Agrega el usuario a la lista de usuarios
                usuarios.add(new Usuario(id, nombre, correo, telefono, direccion));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Si ocurre un error, se imprime en la consola
        }
        return usuarios; // Retorna la lista de usuarios
    }
    
    // Método para actualizar los datos de un usuario en la base de datos
    public boolean updateUsuario(Usuario usuario) throws SQLException {
        boolean rowUpdated = false;
        // Establece la conexión y prepara la consulta SQL
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USUARIO_SQL)) {
            // Establece los parámetros de la consulta (los valores del usuario)
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getCorreo());
            preparedStatement.setString(3, usuario.getTelefono());
            preparedStatement.setString(4, usuario.getDireccion());
            preparedStatement.setInt(5, usuario.getId());
            
            // Ejecuta la consulta y obtiene el número de filas afectadas
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated; // Retorna true si la fila fue actualizada con éxito, false si no
    }
}
