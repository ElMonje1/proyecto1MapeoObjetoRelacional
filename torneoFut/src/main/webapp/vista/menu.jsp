<%--
  Created by IntelliJ IDEA.
  User: juan-
  Date: 01/10/2025
  Time: 08:53 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menú del torneo</title>
</head>
<body>
<%-- Barra de navegación --%>
<div style="background-color:#f0f0f0; padding:10px;">
    <span style="font-weight:bold; color:#00a6ff;">Menú Principal</span> |
    <a href="jugador-controlador">Jugadores</a> |
    <a href="equipo-controlador">Equipos</a> |
    <a href="posicion-controlador">Posiciones</a> |
    <a href="partido-controlador">Partidos</a> |
    <a href="gol-controlador">Goles</a>
</div>

<%-- Contenido --%>
<h1>Sistema de Gestión de Torneo</h1><br>
<h2>Bienvenidos al menú principal seleccione una opción</h2>
<ul>
    <li><a href="jugador-controlador">Gestión de Jugadores</a></li>
    <li><a href="equipo-controlador">Gestión de Equipos</a></li>
    <li><a href="posicion-controlador">Gestión de Posiciones</a></li>
    <li><a href="partido-controlador">Alta de Partidos</a></li>
    <li><a href="gol-controlador">Registro de Goles</a></li>
</ul>

</body>
</html>
