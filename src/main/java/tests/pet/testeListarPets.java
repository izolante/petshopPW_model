package tests.pet;

import br.edu.ifsul.model.Pet;
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
public class testeListarPets {
    
    public static void main(String[] args) {
        
        //inicializa duas localDates para calcular a idade
        LocalDate nasc = null;
        LocalDate hoje = LocalDate.now();
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("petshopPW");
        EntityManager em = emf.createEntityManager();
        List<Pet> lista =
                em.createQuery("from Pet order by id").getResultList();
            System.out.println("\n\n\n");
            
        for(Pet p : lista) {
            
            nasc = p.getNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            //calcula o tempo durante as duas datas, pegando o ano no sout
            Period idade = Period.between(nasc, hoje);
            
            System.out.println(" | ID: " + p.getId() + " | Nome: " + p.getNome() +
                    " | Especie: " + p.getEspecie() + " | Raça: " + p.getRaca() + 
                    " | Peso: " + p.getPeso() + " | Idade: " + idade.getYears() + " | Nascimento: " + p.getNascimento().getTime() + "\n\n\n");
        }
        em.close();
        emf.close();
    }
}
