package org.example.torneofut.persistencia;

import jakarta.persistence.*;

@Entity
@Table(name = "goles")
public class Gol {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gol")
    private Long idGol;

    @ManyToOne
    @JoinColumn(name = "id_partido", nullable = false)
    private Partido partido;

    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    private Jugador jugador;

    @Column(nullable = false)
    private int minuto;


    //Constructor
    public Gol() {
    }

    public Gol(Long idGol, Partido partido, Jugador jugador, int minuto) {
        this.idGol = idGol;
        this.partido = partido;
        this.jugador = jugador;
        this.minuto = minuto;
    }


    //getters y setters
    public Long getIdGol() {
        return idGol;
    }

    public void setIdGol(Long idGol) {
        this.idGol = idGol;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}
