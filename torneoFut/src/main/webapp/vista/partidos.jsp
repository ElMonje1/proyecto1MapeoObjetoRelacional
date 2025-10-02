<%@ page import="org.example.torneofut.persistencia.Equipo" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.torneofut.persistencia.Partido" %><%--
  Created by IntelliJ IDEA.
  User: juan-
  Date: 01/10/2025
  Time: 08:46 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Partidos</title>
</head>
<body>
<%-- Barra de navegación --%>
<div style="background-color:#f0f0f0; padding:10px;">
    <a href="menu-controlador">Menú Principal</a> |
    <a href="jugador-controlador">Jugadores</a> |
    <a href="equipo-controlador">Equipos</a> |
    <a href="posicion-controlador">Posiciones</a> |
    <span style="font-weight:bold; color:#00a6ff;">Partidos</span> |
    <a href="gol-controlador">Goles</a>
</div>

<%-- Contenido --%>
<h1>Bienvenidos a la gestión de partidos</h1><br>
<h2>Lista de Partidos</h2>
<table border="3">
    <tr>
        <td>Equipo Local</td>
        <td>Equipo Visitante</td>
        <td>Goles</td>
        <td>Fecha y hora</td>
    </tr>
    <%
        List<Partido> partidos = (List<Partido>) request.getAttribute("partidos");
        for (Partido p : partidos) {
    %>
    <tr>
        <td><%= p.getEquipoLocal().getNombre() %></td>
        <td><%= p.getEquipoVisitante().getNombre() %></td>
        <td><%= p.getGolesLocal() %> - <%= p.getGolesVisitante() %></td>
        <td><%= p.getFechaPartido() %></td>
    </tr>
    <%
        }
    %>
</table>

<h3>Agregar Partido</h3>
<form method="post" action="partido-controlador">
    <input type="hidden" name="accion" value="crear" />
    Equipo Local:
    <select name="idLocal">
        <%
            List<Equipo> equipos = (List<Equipo>) request.getAttribute("equipos");
            for (Equipo e : equipos) {
        %>
        <option value="<%= e.getIdEquipo() %>"><%= e.getNombre() %></option>
        <%
            }
        %>
    </select><br/>
    Equipo Visitante:
    <select name="idVisitante">
        <%
            for (Equipo e : equipos) {
        %>
        <option value="<%= e.getIdEquipo() %>"><%= e.getNombre() %></option>
        <%
            }
        %>
    </select><br/>
    Goles Local: <input type="number" name="golesLocal"/><br/>
    Goles Visitante: <input type="number" name="golesVisitante"/><br/>
    Fecha del Partido: <input type="datetime-local" name="fecha"/>
    <input type="submit" value="Guardar"/>
</form>
</body>
</html>
