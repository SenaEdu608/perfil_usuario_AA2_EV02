package com.peluqueria.model;

public class Usuario {
    
    // Atributos del usuario: id, nombre, correo, telefono, direccion
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    
    // Constructor vacío: se utiliza cuando se crea un objeto de tipo Usuario sin pasarle parámetros
    public Usuario() {}

    // Constructor con 4 parámetros (sin ID): se utiliza cuando no se tiene el ID (por ejemplo, al insertar un nuevo usuario)
    public Usuario(String nombre, String correo, String telefono, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    // Constructor con 5 parámetros (con ID): se utiliza cuando ya se tiene el ID (por ejemplo, para actualizar un usuario existente)
    public Usuario(int id, String nombre, String correo, String telefono, String direccion) {
        this.id = id;  // Inicializa el ID
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    // Getters y Setters: permiten obtener (get) o modificar (set) los valores de los atributos

    public int getId() { 
        return id;  // Retorna el valor del atributo 'id'
    }
    
    public void setId(int id) { 
        this.id = id;  // Establece el valor del atributo 'id'
    }

    public String getNombre() { 
        return nombre;  // Retorna el valor del atributo 'nombre'
    }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre;  // Establece el valor del atributo 'nombre'
    }

    public String getCorreo() { 
        return correo;  // Retorna el valor del atributo 'correo'
    }
    
    public void setCorreo(String correo) { 
        this.correo = correo;  // Establece el valor del atributo 'correo'
    }

    public String getTelefono() { 
        return telefono;  // Retorna el valor del atributo 'telefono'
    }
    
    public void setTelefono(String telefono) { 
        this.telefono = telefono;  // Establece el valor del atributo 'telefono'
    }

    public String getDireccion() { 
        return direccion;  // Retorna el valor del atributo 'direccion'
    }
    
    public void setDireccion(String direccion) { 
        this.direccion = direccion;  // Establece el valor del atributo 'direccion'
    }
}
