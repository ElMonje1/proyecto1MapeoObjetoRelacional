package org.example.torneofut.persistencia;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jugadores")
public class Jugador {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Long idJugador;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne                  //muchos jugadores a un equipo
    @JoinColumn(name = "id_equipo", nullable = false)//esta columna referencia a la tabla equipo
    private Equipo equipo;

    @ManyToOne                  //muchos jugadores a una posicion
    @JoinColumn(name = "id_posicion")//nombre de columna que referencia a otra tabla
    private Posicion posicion;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)//un jugador a muchos goles
    private List<Gol> goles = new ArrayList<>();


    //Constructores
    public Jugador() {
    }

    public Jugador(Long idJugador, String nombre, Equipo equipo, Posicion posicion, LocalDate fechaNacimiento, List<Gol> goles) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.equipo = equipo;
        this.posicion = posicion;
        this.fechaNacimiento = fechaNacimiento;
        this.goles = goles;
    }


    //getters y setters
    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Gol> getGoles() {
        return goles;
    }

    public void setGoles(List<Gol> goles) {
        this.goles = goles;
    }
}
