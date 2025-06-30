<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Definición de la página como una página JSP que utiliza Java y UTF-8 como codificación de caracteres -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Inclusión de la biblioteca JSTL (JavaServer Pages Standard Tag Library) para trabajar con etiquetas como <c:out> -->

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Editar Perfil</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/css/nav.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/css/editar.css">
</head>
<body>

  <header class="contenedor-navegacion">
    <nav class="navegacion">
      <a href="#" onclick="mostrarSeccion('principal')" class="peluqueria-text">Peluquería Denis</a>

      <ul>

        <li><a href="#" id="b-tarea">PERFIL</a></li>
        <li><a href="#" onclick="mostrarSeccion('cita')">CITA</a></li>
        <li><a href="#" onclick="mostrarSeccion('serviciosDeshboard')">SERVICIOS</a></li>
        <li><a href="#" id="menu-admin" onclick="mostrarSeccion('video-cliente')">ADMIN</a></li>
        <li><a href="#" id="menu-gestion" onclick="mostrarSeccion('gestion-citas')">GESTIÓN</a></li>
        <li><a href="#" onclick="mostrarSeccion('pago')">PAGO</a></li>
        <li><a href="#" onclick="cerrarSesion()">SALIR</a></li>
  
      </ul>
    </nav>
  </header>

  <!-- Contenedor lateral de la sección de editar perfil -->
  <div class="sidebar">
    <h1>Editar Perfil</h1>
    <form action="${pageContext.request.contextPath}/editar" method="post">
      <!-- Formulario que enviará los datos al servlet 'editar' -->
      
      <label for="nombre">Nombre:</label>
      <input type="text" id="nombre" name="nombre" value="<c:out value='${usuario.nombre}' />" required />
      <!-- Campo de texto para el nombre del usuario. Se rellena con el valor actual del nombre, proveniente del objeto 'usuario' -->

      <label for="correo">Correo:</label>
      <input type="email" id="correo" name="correo" value="<c:out value='${usuario.correo}' />" required />
      <!-- Campo de texto para el correo del usuario. Se rellena con el valor actual del correo -->

      <label for="telefono">Teléfono:</label>
      <input type="tel" id="telefono" name="telefono" value="<c:out value='${usuario.telefono}' />" required />
      <!-- Campo de texto para el teléfono del usuario. Se rellena con el valor actual del teléfono -->

      <label for="direccion">Dirección:</label>
      <input type="text" id="direccion" name="direccion" value="<c:out value='${usuario.direccion}' />" required />
      <!-- Campo de texto para la dirección del usuario. Se rellena con el valor actual de la dirección -->

      <button type="submit" class="boton">Guardar</button>
      <!-- Botón para enviar el formulario -->

      <a href="${pageContext.request.contextPath}/perfil" class="boton volver" style="text-align:center; display:block; text-decoration: none;">Volver</a>
      
    </form>
  </div>

  <!-- Contenedor principal de la página -->
  <div class="main"></div>


 
</body>
</html>
