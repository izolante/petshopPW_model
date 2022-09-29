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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

/**
 *
 * @author Izolante
 */
public class testePersistirPets {
    
    public static void main(String[] args) throws ParseException {
        
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("petshopPW");
        EntityManager em = emf.createEntityManager();
        Raca r = em.find(Raca.class, 1);
        Pet p = new Pet();
        p.setEspecie("Canino");
        
        SimpleDateFormat sdfInput = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdfInput.parse("10-10-2010");
        Calendar ca1 = Calendar.getInstance();
        ca1.setTime(date1);
        p.setNascimento(ca1);
        
        p.setNome("Keity");
        p.setPeso(7.5);
        p.setRaca(r);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
