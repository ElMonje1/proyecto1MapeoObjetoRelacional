package org.example.torneofut.presentación;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.torneofut.persistencia.Gol;
import org.example.torneofut.persistencia.Jugador;
import org.example.torneofut.persistencia.Partido;
import org.example.torneofut.servicio.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "golControlador", value = "/gol-controlador")
public class GolControlador  extends HttpServlet {
    private GolServicio golService = new GolServicioImpl();

    private PartidoServicio partidoService = new PartidoServicioImpl();
    private JugadorServicio jugadorService = new JugadorServicioImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cargarDatos(request);
        request.getRequestDispatcher("/vista/goles.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("crear".equals(accion)) {
            Long idPartido = Long.parseLong(request.getParameter("idPartido"));
            Long idJugador = Long.parseLong(request.getParameter("idJugador"));
            int minuto = Integer.parseInt(request.getParameter("minuto"));

            Partido partido = partidoService.buscarPartido(idPartido);
            Jugador jugador = jugadorService.buscarJugador(idJugador);

            Gol gol = new Gol();
            gol.setPartido(partido);
            gol.setJugador(jugador);
            gol.setMinuto(minuto);

            golService.crearGol(gol);
        }
        cargarDatos(request);
        request.getRequestDispatcher("/vista/goles.jsp").forward(request, response);
    }

    private void cargarDatos(HttpServletRequest request) {
        List<Gol> goles = golService.listarGoles();
        List<Partido> partidos = partidoService.listarPartidos();
        List<Jugador> jugadores = jugadorService.listarJugadores();

        request.setAttribute("goles", goles);
        request.setAttribute("partidos", partidos);
        request.setAttribute("jugadores", jugadores);
    }
}
