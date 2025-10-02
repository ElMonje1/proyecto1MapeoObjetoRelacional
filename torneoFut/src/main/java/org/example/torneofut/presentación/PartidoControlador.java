package org.example.torneofut.presentación;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.torneofut.persistencia.Equipo;
import org.example.torneofut.persistencia.Partido;
import org.example.torneofut.servicio.EquipoServicio;
import org.example.torneofut.servicio.EquipoServicioImpl;
import org.example.torneofut.servicio.PartidoServicio;
import org.example.torneofut.servicio.PartidoServicioImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "partidoControlador", value = "/partido-controlador")
public class PartidoControlador extends HttpServlet {
    private PartidoServicio partidoService = new PartidoServicioImpl();
    private EquipoServicio equipoService = new EquipoServicioImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cargarDatos(request);
        request.getRequestDispatcher("/vista/partidos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("crear".equals(accion)) {
            Long idLocal = Long.parseLong(request.getParameter("idLocal"));
            Long idVisitante = Long.parseLong(request.getParameter("idVisitante"));
            int golesLocal = Integer.parseInt(request.getParameter("golesLocal"));
            int golesVisitante = Integer.parseInt(request.getParameter("golesVisitante"));
            LocalDateTime fechaHora = LocalDateTime.parse(request.getParameter("fecha"));

            Equipo equipoLocal = equipoService.buscarEquipo(idLocal);
            Equipo equipoVisitante = equipoService.buscarEquipo(idVisitante);

            Partido partido = new Partido();
            partido.setEquipoLocal(equipoLocal);
            partido.setEquipoVisitante(equipoVisitante);
            partido.setGolesLocal(golesLocal);
            partido.setGolesVisitante(golesVisitante);
            partido.setFechaPartido(fechaHora);

            partidoService.crearPartido(partido);
        }

        cargarDatos(request);
        request.getRequestDispatcher("/vista/partidos.jsp").forward(request, response);
    }

    private void cargarDatos(HttpServletRequest request) {
        List<Partido> partidos = partidoService.listarPartidos();
        List<Equipo> equipos = equipoService.listarEquipos();

        request.setAttribute("partidos", partidos);
        request.setAttribute("equipos", equipos);
    }
}
