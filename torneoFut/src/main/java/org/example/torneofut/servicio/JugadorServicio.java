package org.example.torneofut.servicio;

import org.example.torneofut.persistencia.Jugador;
import org.example.torneofut.persistencia.Posicion;

import java.util.List;

public interface JugadorServicio {
    void crearJugador(Jugador jugador);
    void actualizarJugador(Jugador jugador);
    void eliminarJugador(Long id);
    void asignarPosicion(Long idJuga, Long idPosi);
    Jugador buscarJugador(Long id);
    List<Jugador> listarJugadores();
}
