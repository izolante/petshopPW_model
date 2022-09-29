package tests.raca;

import br.edu.ifsul.model.Raca;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Izolante
 */
public class testeListarRacas {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("petshopPW");
        EntityManager em = emf.createEntityManager();
        List<Raca> lista =
                em.createQuery("from Raca order by id").getResultList();
            System.out.println("\n\n\n");
        for(Raca r : lista) {
            System.out.println(" | ID: " + r.getId() + " | Nome: " + r.getNome() + "\n\n\n");
        }
        em.close();
        emf.close();
    }
}
