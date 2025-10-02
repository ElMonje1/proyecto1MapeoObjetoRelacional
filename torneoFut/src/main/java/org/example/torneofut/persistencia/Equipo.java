package org.example.torneofut.persistencia;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "equipos")
public class Equipo {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para poder generar id de manera automática y serial y unica
    @Column(name = "id_equipo")
    private Long idEquipo;

    @Column(nullable = false, unique = true)    //para que los nombres no sean nulos o se repitan pues son nombres de equipos de futbol
    private String nombre;

                                                                //Cascade = CascadeType.ALL si se guarda actualiza o elimina un equipo afecta a sus jugadores
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)  //uno a muchos un equipo tiene muchos jugadores
    private List<Jugador> jugadores = new ArrayList<>();


    //Constructores
    public Equipo(Long idEquipo, String nombre, List<Jugador> jugadores) {
        this.idEquipo = idEquipo;
    }

    public Equipo() {
    }


    //getters y setters
    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
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
