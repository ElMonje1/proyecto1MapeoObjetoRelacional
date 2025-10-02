package org.example.torneofut.persistencia;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posiciones")
public class Posicion {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_posicion")
    private Long idPosicion;

    @Column(nullable = false, unique = true)
    private String nombre;


    @OneToMany(mappedBy = "posicion", cascade = CascadeType.ALL)
    private List<Jugador> jugadores = new ArrayList<>();


    //Constructor
    public Posicion() {
    }

    public Posicion(Long idPosicion, String nombre, List<Jugador> jugadores) {
        this.idPosicion = idPosicion;
        this.nombre = nombre;
        this.jugadores = jugadores;
    }


    //getters y setters

    public Long getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(Long idPosicion) {
        this.idPosicion = idPosicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
