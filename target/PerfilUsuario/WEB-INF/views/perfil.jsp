
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Perfil de Usuario</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/css/nav.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/css/perfil.css">
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
    <h1>Perfil</h1>
    <p><strong>Nombre:</strong> <c:out value="${usuario.nombre}" /></p>
    <p><strong>Correo:</strong> <c:out value="${usuario.correo}" /></p>
    <p><strong>Teléfono:</strong> <c:out value="${usuario.telefono}" /></p>
    <p><strong>Dirección:</strong> <c:out value="${usuario.direccion}" /></p>
    <a class="boton" href="${pageContext.request.contextPath}/editar">Editar Datos</a>
  </div>

  <div class="main"></div>

  <script src="${pageContext.request.contextPath}/frontend/js/perfil.js"></script>
</body>
</html>