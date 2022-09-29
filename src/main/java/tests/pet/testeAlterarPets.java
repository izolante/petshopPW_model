/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.pet;

import br.edu.ifsul.model.Pet;
import tests.raca.*;
import br.edu.ifsul.model.Raca;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Izolante
 */
public class testeAlterarPets {
    
    public static void main(String[] args) throws ParseException {
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("petshopPW");
        EntityManager em = emf.createEntityManager();
        Pet p = em.find(Pet.class, 1);
        p.setNome("Sophia");
        p.setPeso(5.0);
        p.setEspecie("Felino");
        
        SimpleDateFormat sdfInput = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdfInput.parse("25-07-2012");
        Calendar ca1 = Calendar.getInstance();
        ca1.setTime(date1);
        p.setNascimento(ca1);
        
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
