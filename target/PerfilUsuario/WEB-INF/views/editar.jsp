<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

  <div class="sidebar">
    <h1>Editar Perfil</h1>
    <form action="${pageContext.request.contextPath}/editar" method="post">
      <label for="nombre">Nombre:</label>
      <input type="text" id="nombre" name="nombre" value="<c:out value='${usuario.nombre}' />" required />

      <label for="correo">Correo:</label>
      <input type="email" id="correo" name="correo" value="<c:out value='${usuario.correo}' />" required />

      <label for="telefono">Teléfono:</label>
      <input type="tel" id="telefono" name="telefono" value="<c:out value='${usuario.telefono}' />" required />

      <label for="direccion">Dirección:</label>
      <input type="text" id="direccion" name="direccion" value="<c:out value='${usuario.direccion}' />" required />

      <button type="submit" class="boton">Guardar</button>
      <a href="${pageContext.request.contextPath}/perfil" class="boton volver" style="text-align:center; display:block; text-decoration: none;">Volver</a>
    </form>
  </div>

  <div class="main"></div>

  <script src="${pageContext.request.contextPath}/frontend/js/editar.js"></script>
</body>
</html>