package org.example.torneofut.presentación;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.torneofut.persistencia.Equipo;
import org.example.torneofut.persistencia.Jugador;
import org.example.torneofut.persistencia.Posicion;
import org.example.torneofut.servicio.*;

import java.io.IOException;


import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "jugadorControlador", value = "/jugador-controlador")
public class JugadorControlador extends HttpServlet {
    private JugadorServicio jugadorServicio = new JugadorServicioImpl();
    private EquipoServicio equipoServicio = new EquipoServicioImpl();
    private PosicionServicio posicionServicio = new PosicionServicioImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cargarDatos(request);
        request.getRequestDispatcher("/vista/jugadores.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("crear".equals(accion)) {
            String nombre = request.getParameter("nombre");
            LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
            Long idEquipo = Long.parseLong(request.getParameter("idEquipo"));
            Long idPosicion = Long.parseLong(request.getParameter("idPosicion"));

            Equipo equipo = equipoServicio.buscarEquipo(idEquipo);
            Posicion posicion = posicionServicio.buscarPosicion(idPosicion);

            Jugador jugador = new Jugador();
            jugador.setNombre(nombre);
            jugador.setFechaNacimiento(fechaNacimiento);
            jugador.setEquipo(equipo);
            jugador.setPosicion(posicion);

            jugadorServicio.crearJugador(jugador);

        } else if ("actualizar".equals(accion)) {
            Long id = Long.parseLong(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fechaNacimiento"));
            Long idEquipo = Long.parseLong(request.getParameter("idEquipo"));
            Long idPosicion = Long.parseLong(request.getParameter("idPosicion"));

            Jugador jugador = new Jugador();
            jugador.setIdJugador(id);
            jugador.setNombre(nombre);
            jugador.setFechaNacimiento(fechaNacimiento);
            jugador.setEquipo(new Equipo());
            jugador.getEquipo().setIdEquipo(idEquipo);
            jugador.setPosicion(new Posicion());
            jugador.getPosicion().setIdPosicion(idPosicion);

            jugadorServicio.actualizarJugador(jugador);

        } else if ("eliminar".equals(accion)) {
            Long id = Long.parseLong(request.getParameter("id"));
            jugadorServicio.eliminarJugador(id);

        } else if ("editar".equals(accion)) {
            Long id = Long.parseLong(request.getParameter("id"));
            Jugador jugadorEditar = jugadorServicio.buscarJugador(id);
            request.setAttribute("jugadorEditar", jugadorEditar);
            request.setAttribute("modoEdicion", true);
        }

        cargarDatos(request);
        request.getRequestDispatcher("/vista/jugadores.jsp").forward(request, response);
    }

    private void cargarDatos(HttpServletRequest request) {
        List<Jugador> jugadores = jugadorServicio.listarJugadores();
        List<Equipo> equipos = equipoServicio.listarEquipos();
        List<Posicion> posiciones = posicionServicio.listarPosiciones();

        request.setAttribute("jugadores", jugadores);
        request.setAttribute("equipos", equipos);
        request.setAttribute("posiciones", posiciones);
    }
}
