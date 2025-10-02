package org.example.torneofut.servicio;

import org.example.torneofut.persistencia.Gol;
import java.util.List;

public interface GolServicio {
    void crearGol(Gol gol);
    List<Gol> listarGoles();
}
