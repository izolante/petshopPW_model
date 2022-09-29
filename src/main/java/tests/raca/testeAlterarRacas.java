/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.raca;

import br.edu.ifsul.model.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Izolante
 */
public class testeAlterarRacas {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("petshopPW");
        EntityManager em = emf.createEntityManager();
        Raca r = em.find(Raca.class, 1);
        r.setNome("Pinscher");
        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
