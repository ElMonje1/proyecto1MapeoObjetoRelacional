package org.example.torneofut.presentación;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "menuControlador", value = "/menu-controlador")
public class MenuControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // simplemente redirige a la jsp del menu
        request.getRequestDispatcher("/vista/menu.jsp").forward(request, response);
    }

}