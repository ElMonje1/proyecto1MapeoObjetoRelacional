<%@ page import="org.example.torneofut.persistencia.Partido" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.torneofut.persistencia.Jugador" %>
<%@ page import="org.example.torneofut.persistencia.Gol" %><%--
  Created by IntelliJ IDEA.
  User: juan-
  Date: 01/10/2025
  Time: 08:45 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Goles</title>
</head>
<body>
<%-- Barra de navegación --%>
<div style="background-color:#f0f0f0; padding:10px;">
    <a href="menu-controlador">Menú Principal</a> |
    <a href="jugador-controlador">Jugadores</a> |
    <a href="equipo-controlador">Equipos</a> |
    <a href="posicion-controlador">Posiciones</a> |
    <a href="partido-controlador">Partidos</a> |
    <span style="font-weight:bold; color:#00a6ff;">Goles</span>
</div>

<%-- Contenido --%>
<h1>Bienvenidos a la gestión de goles</h1><br>
<h2>Lista de Goles</h2>
<table border="3">
    <tr>
        <td>Nombre</td>
        <td>Numero de partido</td>
        <td>Minuto del gol</td>
    </tr>
    <%
        List<Gol> goles = (List<Gol>) request.getAttribute("goles");
        for (Gol g : goles) {
    %>
    <tr>
        <td><%= g.getJugador().getNombre() %></td>
        <td><%= g.getPartido().getIdPartido() %></td>
        <td><%= g.getMinuto() %></td>
    </tr>
    <%
        }
    %>
</table>

<h3>Registrar Gol</h3>
<form method="post" action="gol-controlador">
    <input type="hidden" name="accion" value="crear" />
    Partido:
    <select name="idPartido">
        <%
            List<Partido> partidos = (List<Partido>) request.getAttribute("partidos");
            for (Partido p : partidos) {
        %>
        <option value="<%= p.getIdPartido() %>">Partido #<%= p.getIdPartido() %></option>
        <%
            }
        %>
    </select><br/>
    Jugador:
    <select name="idJugador">
        <%
            List<Jugador> jugadores = (List<Jugador>) request.getAttribute("jugadores");
            for (Jugador j : jugadores) {
        %>
        <option value="<%= j.getIdJugador() %>"><%= j.getNombre() %></option>
        <%
            }
        %>
    </select><br/>
    Minuto: <input type="number" name="minuto"/><br/>
    <input type="submit" value="Registrar Gol"/>
</form>
</body>
</html>
