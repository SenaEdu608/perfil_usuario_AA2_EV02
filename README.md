# Proyecto de Perfil de Usuario con Java Servlet

## Información del Proyecto

**Evidencia de producto**: GA7-220501096-AA2-EV02 módulos de software codificados y probados  
**Nombre**: John Jairo Zamudio Agudelo  
**Ficha**: 2977467  
**Curso**: Análisis y Desarrollo de Software

Este proyecto tiene como objetivo aplicar y consolidar los conocimientos adquiridos durante el curso "Construcción de aplicaciones con Java" mediante la implementación de una aplicación web usando **Java Servlets**, **JSP**, y **MySQL**. La aplicación permite gestionar el perfil de usuario, permitiendo la visualización y edición de los datos del usuario.

### Propósito del Proyecto

El propósito principal del proyecto es construir una aplicación web que permita:
1. **Visualizar** el perfil de un usuario con datos almacenados en una base de datos MySQL.
2. **Editar** los datos del perfil a través de un formulario HTML utilizando los métodos **POST** para actualizarlos en la base de datos.

Se utilizó el patrón de diseño de **Modelo-Vista-Controlador (MVC)** para organizar la estructura del proyecto, siguiendo las mejores prácticas en el desarrollo de aplicaciones web basadas en Java.

---

## Estructura del Proyecto

El proyecto está organizado de la siguiente forma:

```
/PerfilUsuario
|-- /src
| |-- /main
| |-- /java
| |-- /com
| |-- /peluqueria
| |-- /controller
| |-- EditarServlet.java # Maneja la edición del perfil
| |-- PerfilServlet.java # Maneja la visualización del perfil
| |-- /dao
| |-- UsuarioDAO.java # Interacciones con la base de datos
| |-- /model
| |-- Usuario.java # Modelo de datos para usuario
| |-- /webapp
| |-- /WEB-INF
| |-- /views
| |-- editar.jsp # Página para editar el perfil
| |-- perfil.jsp # Página para visualizar el perfil
| |-- /frontend
| |-- /css
| |-- editar.css # Estilos para la página de edición
| |-- nav.css # Estilos para la barra de navegación
| |-- perfil.css # Estilos para la página de perfil
|-- /target
| |-- /PerfilUsuario
| |-- /WEB-INF
| |-- /classes
| |-- /com
| |-- /peluqueria
| |-- /controller
| |-- EditarServlet.class
| |-- PerfilServlet.class
| |-- /dao
| |-- UsuarioDAO.class
| |-- /model
| |-- Usuario.class
| |-- /lib
| |-- jstl-1.2.jar # Dependencia JSTL
| |-- mysql-connector-java-8.0.28.jar # Conector MySQL
| |-- /views
| |-- editar.jsp
| |-- perfil.jsp
| |-- /frontend
| |-- /css
| |-- editar.css
| |-- nav.css
| |-- perfil.css
```
---

## Descripción de la Implementación

### **1. Servlets**

- **PerfilServlet**: Este servlet maneja la visualización del perfil de usuario. Se encarga de obtener los datos del usuario desde la base de datos y mostrarlos en la página `perfil.jsp`.
  
- **EditarServlet**: Este servlet maneja la edición de los datos del perfil de usuario. Cuando el formulario en `editar.jsp` se envía, el servlet procesa la solicitud **POST** y actualiza los datos en la base de datos.

### **2. JSP (Java Server Pages)**

- **perfil.jsp**: Presenta la información del usuario en un formato legible. También proporciona un enlace para editar el perfil.
  
- **editar.jsp**: Contiene un formulario HTML que permite al usuario modificar sus datos. El formulario se envía a través del método **POST** al servlet correspondiente para realizar las actualizaciones en la base de datos.

### **3. Base de Datos**

La base de datos **MySQL** tiene una tabla llamada `edicion_datos` con los siguientes campos:
- `id`: Identificador único del usuario (clave primaria).
- `nombre`: Nombre del usuario.
- `correo`: Correo electrónico del usuario.
- `telefono`: Número de teléfono del usuario.
- `direccion`: Dirección del usuario.

### **4. Frontend**

Se crearon estilos específicos para cada página:
- **editar.css**: Estilos para la página de edición del perfil.
- **perfil.css**: Estilos para la página de visualización del perfil.
- **nav.css**: Estilos para la barra de navegación.

---

## Flujo de Trabajo

1. **Visualización del Perfil**: 
   - El usuario accede a la página de su perfil (`perfil.jsp`).
   - El servlet **PerfilServlet** maneja la solicitud **GET**, obtiene los datos del usuario desde la base de datos y los muestra en la página JSP.

2. **Edición del Perfil**:
   - El usuario hace clic en el botón "Editar Datos" para modificar su perfil.
   - Se redirige al formulario de edición (`editar.jsp`), donde puede modificar los campos de su perfil.
   - Cuando el formulario se envía, el servlet **EditarServlet** procesa la solicitud **POST**, actualiza los datos en la base de datos y redirige al usuario de nuevo al perfil.

---

## Instrucciones para la Ejecución

1. **Configuración de la Base de Datos**:
   - Crear una base de datos llamada `perfil_datos` en **MySQL**.
   - Crear una tabla `edicion_datos` con los campos mencionados anteriormente.

2. **Configuración del Servidor**:
   - Colocar el código en un servidor **Apache Tomcat**.
   - Asegurarse de que las credenciales y la configuración de la base de datos en `UsuarioDAO.java` estén correctas.

3. **Ejecución**:
   - Iniciar el servidor **Tomcat**.
   - Acceder a la aplicación a través de la URL configurada.
   - Visualizar y editar el perfil de usuario.

---

## Conclusión

Este proyecto me ha permitido aplicar los conocimientos adquiridos sobre **servlets** y **JSP** para construir una aplicación web simple pero funcional. Durante su desarrollo, he aprendido a gestionar peticiones HTTP utilizando los métodos **GET** y **POST**, y a interactuar con una base de datos **MySQL** para almacenar y actualizar información. Además, he utilizado el patrón **MVC** para separar la lógica de negocio de la presentación y mejorar la organización del código.

---

## Requisitos

- **JDK 17 o superior**
- **Apache Tomcat** 9.x o superior
- **MySQL** 5.7 o superior

---

## Herramientas Utilizadas

- **IDE/Editor de Código**: Visual Studio Code
- **Versionamiento**: GitHub (https://github.com/SenaEdu608/perfil_usuario_AA2_EV02.git)
- **Base de Datos**: MySQL