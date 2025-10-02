package org.example.torneofut.presentación;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.torneofut.persistencia.Equipo;
import org.example.torneofut.servicio.EquipoServicio;
import org.example.torneofut.servicio.EquipoServicioImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "equipoControlador", value = "/equipo-controlador")
public class EquipoControlador  extends HttpServlet {
    private EquipoServicio equipoService = new EquipoServicioImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Equipo> equipos = equipoService.listarEquipos();
        request.setAttribute("equipos", equipos);
        request.getRequestDispatcher("/vista/equipos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("crear".equals(accion)) {
            String nombre = request.getParameter("nombre");
            Equipo equipo = new Equipo();
            equipo.setNombre(nombre);
            equipoService.crearEquipo(equipo);
        } else if ("actualizar".equals(accion)) {
            Long id = Long.parseLong(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(id);
            equipo.setNombre(nombre);
            equipoService.actualizarEquipo(equipo);
        } else if ("eliminar".equals(accion)) {
            Long id = Long.parseLong(request.getParameter("id"));
            equipoService.eliminarEquipo(id);
        } else if ("editar".equals(accion)) {
            Long id = Long.parseLong(request.getParameter("id"));
            Equipo equipoEditar = equipoService.buscarEquipo(id);
            request.setAttribute("equipoEditar", equipoEditar);
            request.setAttribute("modoEdicion", true);
        }

        List<Equipo> equipos = equipoService.listarEquipos();
        request.setAttribute("equipos", equipos);
        request.getRequestDispatcher("/vista/equipos.jsp").forward(request, response);
    }
}
