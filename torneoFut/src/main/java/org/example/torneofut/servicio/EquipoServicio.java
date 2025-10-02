package org.example.torneofut.servicio;

import org.example.torneofut.persistencia.Equipo;
import java.util.List;

public interface EquipoServicio {
    void crearEquipo(Equipo equipo);
    void actualizarEquipo(Equipo equipo);
    void eliminarEquipo(Long id);
    Equipo buscarEquipo(Long id);
    List<Equipo> listarEquipos();
}
