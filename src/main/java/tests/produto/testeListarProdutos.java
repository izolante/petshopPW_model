package tests.pet;

import br.edu.ifsul.model.Pet;
import br.edu.ifsul.model.Produto;
import br.edu.ifsul.model.Raca;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.time.ZoneId;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Izolante
 */
public class testeListarProdutos {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("petshopPW");
        EntityManager em = emf.createEntityManager();
        List<Produto> lista =
                em.createQuery("from Produto order by id").getResultList();
            System.out.println("\n\n\n");
            
        for(Produto p : lista) {
            
            System.out.println(" | ID: " + p.getId() + "\n\n\n");
        }
        em.close();
        emf.close();
    }
}
