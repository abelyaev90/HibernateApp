package org.example;


import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();


            //товары для человека
  /*          Person person = session.get(Person.class, 3);
            System.out.println(person);
            List<Item> items = person.getItems();
            System.out.println();
            System.out.println(items);*/

            //Владелец товара по товару
 /*           Item item = session.get(Item.class, 5);
            System.out.println(item);

            Person person = item.getOwner();
            System.out.println(person);*/

            //Добавляем новый товар существующему клиенту
/*            Person person = session.get(Person.class, 2);
            Item newItem = new Item("Item from Hibernate", person);
            person.getItems().add(newItem);
            session.persist(newItem);*/

            //создаем нового человека + создаем и добавляем к нему новый товар
            Person person = new Person("Test person", 30);
            Item newItem = new Item("Item from Hibernate 2", person);

            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));

            session.persist(person);
            session.persist(newItem);

            session.getTransaction().commit();


        }
        finally {
            sessionFactory.close();
        }
    }
}
