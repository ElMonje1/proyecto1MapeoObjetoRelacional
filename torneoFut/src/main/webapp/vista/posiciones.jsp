<%@ page import="java.util.List" %>
<%@ page import="org.example.torneofut.persistencia.Posicion" %>
<%--
  Created by IntelliJ IDEA.
  User: juan-
  Date: 01/10/2025
  Time: 08:20 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Posiciones</title>
</head>
<body>
    <%-- Barra de navegación --%>
    <div style="background-color:#f0f0f0; padding:10px;">
        <a href="menu-controlador">Menú Principal</a> |
        <a href="jugador-controlador">Jugadores</a> |
        <a href="equipo-controlador">Equipos</a> |
        <span style="font-weight:bold; color:#00a6ff;">Posiciones</span> |
        <a href="partido-controlador">Partidos</a> |
        <a href="gol-controlador">Goles</a>
    </div>

    <%-- Contenido --%>
    <h1>Bienvenidos a la gestión de posiciones</h1><br>
    <h2>Lista de Posiciones</h2>
    <table border="3">
        <%
            List<Posicion> posiciones = (List<Posicion>) request.getAttribute("posiciones");
            for (Posicion p : posiciones) {
        %>
        <tr>
            <td><%= p.getNombre() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <h3>Agregar Posición</h3>
    <form method="post" action="posicion-controlador">
        Nombre: <input type="text" name="nombre"/><br/>
        <input type="submit" value="Guardar"/>
    </form>
</body>
</html>
