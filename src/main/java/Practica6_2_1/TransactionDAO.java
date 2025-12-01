package Practica6_2_1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TransactionDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ProductoPU");

    public static void create (BankingTransaction transaction) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(transaction);
            et.commit();
        } catch (Exception e){
            et.rollback();
        } finally {
            em.close();
        }
    }
}
