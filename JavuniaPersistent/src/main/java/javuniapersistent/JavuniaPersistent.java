package javuniapersistent;

import entities.PersonEntity;

public class JavuniaPersistent {
    public static void main(String[] args) {
        
        PersonEntity p = new PersonEntity();
        p.SetName("Adam");
        p.SetSurname("Por");
        p.SetId(12345);
        p.SetAge(22);
        
        Demo d = new Demo();
        d.persist(p);
        d.fromDB();
    }
}
