package org.example.torneofut.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.example.torneofut.persistencia.Gol;

import java.util.List;

public class GolServicioImpl implements GolServicio{
    private EntityManager em;
    public GolServicioImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("torneoPU");
        this.em = emf.createEntityManager();
    }

    @Override
    public void crearGol(Gol gol) {
        em.getTransaction().begin();
        em.persist(gol);
        em.getTransaction().commit();
    }

    @Override
    public List<Gol> listarGoles() {
        return em.createQuery("SELECT g FROM Gol g", Gol.class).getResultList();
    }
}
