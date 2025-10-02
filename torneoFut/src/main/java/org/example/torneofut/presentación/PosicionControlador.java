package org.example.torneofut.presentación;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.torneofut.persistencia.Posicion;
import org.example.torneofut.servicio.PosicionServicio;
import org.example.torneofut.servicio.PosicionServicioImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "posicionControlador", value = "/posicion-controlador")
public class PosicionControlador  extends HttpServlet {
    private PosicionServicio posicionService = new PosicionServicioImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Posicion> posiciones = posicionService.listarPosiciones();
        request.setAttribute("posiciones", posiciones);
        request.getRequestDispatcher("/vista/posiciones.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");

        Posicion posicion = new Posicion();
        posicion.setNombre(nombre);

        posicionService.crearPosicion(posicion);
        response.sendRedirect("posicion-controlador");
    }
}
