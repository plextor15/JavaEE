package javuniapersistent;

import entities.PersonEntity;
import java.awt.BorderLayout;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Demo {      
    public void persist(Object object) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("APor_JavuniaPersistent_jar");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } 
        catch (Exception e) {
            em.getTransaction().rollback();
        } 
        finally {
            em.close();
        }
    }

    public void fromDB (){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("APor_JavuniaPersistent_jar");
        EntityManager em = emf.createEntityManager();
        
        //Query query = em.createQuery("Select e from student e");
        Query query = em.createQuery("Select e from persons e where e.name = 'Adam'");

        List<PersonEntity> list = query.getResultList();
        for(PersonEntity e:list) {
            System.out.println("Person NAME :" + e.GetName()+" "+ e.GetSurname());
        }
    }
}