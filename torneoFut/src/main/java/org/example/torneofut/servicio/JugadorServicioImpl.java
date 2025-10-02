package org.example.torneofut.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.example.torneofut.persistencia.Jugador;
import org.example.torneofut.persistencia.Posicion;

import java.util.List;

public class JugadorServicioImpl implements JugadorServicio {
    private EntityManager em;
    public JugadorServicioImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("torneoPU");
        this.em = emf.createEntityManager();
    }

    @Override
    public void crearJugador(Jugador jugador) {
        em.getTransaction().begin();
        em.persist(jugador);
        em.getTransaction().commit();
    }

    @Override
    public void actualizarJugador(Jugador jugador) {
        em.getTransaction().begin();
        em.merge(jugador);
        em.getTransaction().commit();
    }

    @Override
    public void eliminarJugador(Long id) {
        em.getTransaction().begin();
        Jugador jugador = em.find(Jugador.class, id);
        if (jugador != null) em.remove(jugador);
        em.getTransaction().commit();
    }

    @Override
    public void asignarPosicion(Long idJuga, Long idPosi) {
        Jugador jugador = em.find(Jugador.class, idJuga);
        Posicion posicion = em.find(Posicion.class, idPosi);

        if (jugador != null && posicion != null) {
            jugador.setPosicion(posicion);
            em.merge(jugador);
        }

    }

    @Override
    public Jugador buscarJugador(Long id) {
        return em.find(Jugador.class, id);
    }

    @Override
    public List<Jugador> listarJugadores() {
        return em.createQuery("SELECT j FROM Jugador j", Jugador.class).getResultList();
    }
}
