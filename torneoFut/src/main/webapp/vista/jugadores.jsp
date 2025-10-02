<%@ page import="org.example.torneofut.persistencia.Equipo" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.torneofut.persistencia.Posicion" %>
<%@ page import="org.example.torneofut.persistencia.Jugador" %><%--
  Created by IntelliJ IDEA.
  User: juan-
  Date: 01/10/2025
  Time: 08:45 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Jugadores</title>
</head>
<body>
<%-- Barra de navegación --%>
<div style="background-color:#f0f0f0; padding:10px;">
    <a href="menu-controlador">Menú Principal</a> |
    <span style="font-weight:bold; color:#00a6ff;">Jugadores</span> |
    <a href="equipo-controlador">Equipos</a> |
    <a href="posicion-controlador">Posiciones</a> |
    <a href="partido-controlador">Partidos</a> |
    <a href="gol-controlador">Goles</a>
</div>

<%-- Contenido --%>
<h1>Bienvenidos a la gestión de jugadores</h1><br>
<h2>Lista de Jugadores</h2>
<table border="3">
    <tr>
        <th>Nombre</th>
        <th>Fecha Nacimiento</th>
        <th>Equipo</th>
        <th>Posición</th>
        <th>Elige la opción prefieras</th>
    </tr>
    <%
        List<Jugador> jugadores = (List<Jugador>) request.getAttribute("jugadores");
        for (Jugador j : jugadores) {
    %>
    <tr>
        <td><%= j.getNombre() %></td>
        <td><%= j.getFechaNacimiento() %></td>
        <td><%= j.getEquipo().getNombre() %></td>
        <td><%= j.getPosicion().getNombre() %></td>
        <td>
            <form method="post" action="jugador-controlador" style="display:inline;">
                <input type="hidden" name="id" value="<%= j.getIdJugador() %>"/>
                <input type="hidden" name="accion" value="editar"/>
                <input type="submit" value="Editar"/>
            </form>
            <form method="post" action="jugador-controlador" style="display:inline;" onsubmit="return confirm('¿Eliminar este jugador?');">
                <input type="hidden" name="id" value="<%= j.getIdJugador() %>"/>
                <input type="hidden" name="accion" value="eliminar"/>
                <input type="submit" value="Eliminar"/>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

<h3><%= request.getAttribute("modoEdicion") != null ? "Editar Jugador" : "Agregar Jugador" %></h3>
<form method="post" action="jugador-controlador">
    <%
        Jugador jugadorEditar = (Jugador) request.getAttribute("jugadorEditar");
        boolean modoEdicion = jugadorEditar != null;
    %>
    <input type="hidden" name="accion" value="<%= modoEdicion ? "actualizar" : "crear" %>"/>
    <% if (modoEdicion) { %>
    <input type="hidden" name="id" value="<%= jugadorEditar.getIdJugador() %>"/>
    <% } %>
    Nombre: <input type="text" name="nombre" value="<%= modoEdicion ? jugadorEditar.getNombre() : "" %>"/><br/>
    Fecha de Nacimiento: <input type="date" name="fechaNacimiento" value="<%= modoEdicion ? jugadorEditar.getFechaNacimiento() : "" %>"/><br/>
    Equipo:
    <select name="idEquipo">
        <%
            List<Equipo> equipos = (List<Equipo>) request.getAttribute("equipos");
            for (Equipo e : equipos) {
                boolean seleccionado = modoEdicion && jugadorEditar.getEquipo().getIdEquipo().equals(e.getIdEquipo());
        %>
        <option value="<%= e.getIdEquipo() %>" <%= seleccionado ? "selected" : "" %>><%= e.getNombre() %></option>
        <%
            }
        %>
    </select><br/>
    Posición:
    <select name="idPosicion">
        <%
            List<Posicion> posiciones = (List<Posicion>) request.getAttribute("posiciones");
            for (Posicion p : posiciones) {
                boolean seleccionado = modoEdicion && jugadorEditar.getPosicion().getIdPosicion().equals(p.getIdPosicion());
        %>
        <option value="<%= p.getIdPosicion() %>" <%= seleccionado ? "selected" : "" %>><%= p.getNombre() %></option>
        <%
            }
        %>
    </select><br/>
    <input type="submit" value="<%= modoEdicion ? "Actualizar" : "Guardar" %>"/>
</form>
</body>
</html>
