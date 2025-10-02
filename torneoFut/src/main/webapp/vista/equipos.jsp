<%@ page import="org.example.torneofut.persistencia.Equipo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: juan-
  Date: 01/10/2025
  Time: 08:45 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Equipos</title>
</head>
<body>
<%-- Barra de navegación --%>
<div style="background-color:#f0f0f0; padding:10px;">
    <a href="menu-controlador">Menú Principal</a> |
    <a href="jugador-controlador">Jugadores</a> |
    <span style="font-weight:bold; color:#00a6ff;">Equipos</span> |
    <a href="posicion-controlador">Posiciones</a> |
    <a href="partido-controlador">Partidos</a> |
    <a href="gol-controlador">Goles</a>
</div>

<%-- Contenido --%>
<h1>Bienvenidos a la gestión de equipos</h1><br>
<h2>Lista de Equipos</h2>
<table border="3">
    <tr>
        <th>Nombre</th>
        <th>Elige la opción que prefieras</th>
    </tr>
    <%
        List<Equipo> equipos = (List<Equipo>) request.getAttribute("equipos");
        for (Equipo e : equipos) {
    %>
    <tr>
        <td><%= e.getNombre() %></td>
        <td>
            <form method="post" action="equipo-controlador" style="display:inline;">
                <input type="hidden" name="id" value="<%= e.getIdEquipo() %>"/>
                <input type="hidden" name="accion" value="editar"/>
                <input type="submit" value="Editar"/>
            </form>
            <form method="post" action="equipo-controlador" style="display:inline;" onsubmit="return confirm('¿Eliminar este equipo?');">
                <input type="hidden" name="id" value="<%= e.getIdEquipo() %>"/>
                <input type="hidden" name="accion" value="eliminar"/>
                <input type="submit" value="Eliminar"/>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

<h3><%= request.getAttribute("modoEdicion") != null ? "Editar Equipo" : "Agregar Equipo" %></h3>
<form method="post" action="equipo-controlador">
    <%
        Equipo equipoEditar = (Equipo) request.getAttribute("equipoEditar");
        boolean modoEdicion = equipoEditar != null;
    %>
    <input type="hidden" name="accion" value="<%= modoEdicion ? "actualizar" : "crear" %>"/>
    <%
        if (modoEdicion) {
    %>
    <input type="hidden" name="id" value="<%= equipoEditar.getIdEquipo() %>"/>
    <% } %>
    Nombre: <input type="text" name="nombre" value="<%= modoEdicion ? equipoEditar.getNombre() : "" %>"/><br/>
    <input type="submit" value="<%= modoEdicion ? "Actualizar" : "Guardar" %>"/>
</form>
</body>
</html>
