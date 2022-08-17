package org.hibernatePractise.udemy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernatePractise.udemy.entity.Employee;

import java.text.ParseException;
import java.util.Date;

public class Servises {
    public Date dayOfBirth(String dayOfBirthStr) throws ParseException {
        return DateUtil.parseDate(dayOfBirthStr);
    }

    public void saveData() throws ParseException {
        // create new object
        Employee employee1 = new Employee("Iva", "Fryshchyn", "ivanna@gmail.com", dayOfBirth("20/01/1994"));
        Employee employee2 = new Employee("Olha", "Kutash", "ola@gmail.com", dayOfBirth("10/02/1995"));
        Employee employee3 = new Employee("Katrin", "Myhailych", "katrin@gmail.com", dayOfBirth("11/11/1993"));
        Employee employee4 = new Employee("Solomiya", "Soma", "solomiya@gmail.com", dayOfBirth("30/05/1968"));
        Employee employee5 = new Employee("Nadiya", "Fryshchyn", "nadiya@gmail.com", dayOfBirth("10/10/1965"));
        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        session.save(employee5);
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
        sessionFactory.close();
    }
}
