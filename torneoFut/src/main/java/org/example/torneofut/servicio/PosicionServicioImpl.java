package org.example.torneofut.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.example.torneofut.persistencia.Posicion;

import java.util.List;

public class PosicionServicioImpl implements PosicionServicio {
    private EntityManager em;
    public PosicionServicioImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("torneoPU");
        this.em = emf.createEntityManager();
    }

    @Override
    public void crearPosicion(Posicion posicion) {
        em.getTransaction().begin();         //Inicia la transacción
        em.persist(posicion);                //Guarda la entidad
        em.getTransaction().commit();        //Confirma cambios
    }

    @Override
    public Posicion buscarPosicion(Long id) {
        return em.find(Posicion.class, id);
    }

    @Override
    public List<Posicion> listarPosiciones() {
        return em.createQuery("SELECT p FROM Posicion p", Posicion.class).getResultList();
    }
}
