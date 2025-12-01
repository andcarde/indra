package Practica6;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProductoPU");

    public void create (Producto producto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(Producto producto) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            em.merge(producto);
            tx.commit();
            System.out.println("Se pudo modificar");
        } catch (Exception e){
            tx.rollback();
            System.out.println("No se pudo modificar");
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Producto p= em.find(Producto.class, id);
            em.remove(p);
            em.getTransaction().commit();
            System.out.println("Se pudo borrar");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("no se pudo borrar");
        }finally {
            em.close();
        }
    }

    public Producto find(Long id) {
        EntityManager em = emf.createEntityManager();
        Producto p = null;
        try {
            p= em.find(Producto.class, id);
        } catch (Exception e) {
            System.out.println("no se pudo encontrar");
        }finally {
            em.close();
        }
        return p;
    }
}

