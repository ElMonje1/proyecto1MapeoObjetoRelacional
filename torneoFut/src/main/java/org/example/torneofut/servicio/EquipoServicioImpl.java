package org.example.torneofut.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.example.torneofut.persistencia.Equipo;

import java.util.List;

public class EquipoServicioImpl implements EquipoServicio{
    private EntityManager em;
    public EquipoServicioImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("torneoPU");
        this.em = emf.createEntityManager();
    }
    @Override
    public void crearEquipo(Equipo equipo) {
        em.getTransaction().begin();         //Inicia la transacción
        em.persist(equipo);                  //Guarda la entidad
        em.getTransaction().commit();        //Confirma cambios
    }

    @Override
    public void actualizarEquipo(Equipo equipo) {
        em.getTransaction().begin();         //Inicia la transacción
        em.merge(equipo);                    //Modifica la entidad
        em.getTransaction().commit();        //Confirma cambios
    }

    @Override
    public void eliminarEquipo(Long id) {
        em.getTransaction().begin();
        Equipo equipo = em.find(Equipo.class, id);
        if (equipo != null) em.remove(equipo);
        em.getTransaction().commit();
    }

    @Override
    public Equipo buscarEquipo(Long id) {
        return em.find(Equipo.class, id);
    }

    @Override
    public List<Equipo> listarEquipos() {
        return em.createQuery("SELECT e FROM Equipo e", Equipo.class).getResultList();
    }
}
