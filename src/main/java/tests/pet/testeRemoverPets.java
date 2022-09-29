package tests.pet;

import br.edu.ifsul.model.Pet;
import tests.raca.*;
import br.edu.ifsul.model.Raca;
import javax.persistence.*;

/**
 *
 * @author Izolante
 */
public class testeRemoverPets {
    
    public static void main (String[] args) {
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("petshopPW");
        EntityManager em = emf.createEntityManager();
        Pet p = em.find(Pet.class, 1);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
