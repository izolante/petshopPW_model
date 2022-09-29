/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.raca;

import br.edu.ifsul.model.Raca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

/**
 *
 * @author Izolante
 */
public class testePersistirRacas {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("petshopPW");
        EntityManager em = emf.createEntityManager();
        Raca r = new Raca();
        r.setNome("Poodle");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
