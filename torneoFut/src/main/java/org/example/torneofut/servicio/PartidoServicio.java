package org.example.torneofut.servicio;

import org.example.torneofut.persistencia.Partido;
import java.util.List;

public interface PartidoServicio {
    void crearPartido(Partido partido);
    Partido buscarPartido(Long id);
    List<Partido> listarPartidos();
}
