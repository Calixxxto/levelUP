package calixxxto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        try {

            em.getTransaction().begin();

            try {
                createSubject(em, new Engineer("user1"), "78:000001:1111", "Street 1");
//                Subject subj = new Subject("78:000001:1111", "Street 1");
//                em.persist(subj);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                throw e;
            }
        } finally {
            em.close();
            factory.close();
        }
    }

    private static Subject createSubject(EntityManager em, Engineer engineer, String cadNum, String address){
        Subject subj = new Subject(engineer, cadNum, address);
        em.persist(subj);
        return subj;
    }
}
