package tests.raca;

import br.edu.ifsul.model.Raca;
import javax.persistence.*;

/**
 *
 * @author Izolante
 */
public class testeRemoverRacas {
    
    public static void main (String[] args) {
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("petshopPW");
        EntityManager em = emf.createEntityManager();
        Raca r = em.find(Raca.class, 1);
        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
