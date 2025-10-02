package org.example.torneofut.servicio;

import org.example.torneofut.persistencia.Posicion;
import java.util.List;

public interface PosicionServicio {
    void crearPosicion(Posicion posicion);
    Posicion buscarPosicion(Long id);
    List<Posicion> listarPosiciones();
}
