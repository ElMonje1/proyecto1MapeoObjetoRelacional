package org.example.torneofut.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.example.torneofut.persistencia.Partido;
import org.example.torneofut.persistencia.Posicion;

import java.util.List;

public class PartidoServicioImpl implements PartidoServicio{
    private EntityManager em;
    public PartidoServicioImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("torneoPU");
        this.em = emf.createEntityManager();
    }
    @Override
    public void crearPartido(Partido partido) {
        em.getTransaction().begin();
        em.persist(partido);
        em.getTransaction().commit();
    }

    @Override
    public Partido buscarPartido(Long id) {
        return em.find(Partido.class, id);
    }

    @Override
    public List<Partido> listarPartidos() {
        return em.createQuery("SELECT p FROM Partido p", Partido.class).getResultList();
    }
}
