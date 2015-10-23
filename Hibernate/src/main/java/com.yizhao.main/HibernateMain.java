package main.java.com.yizhao.main;

import main.java.com.yizhao.dto.UserDetails;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by YZ on 10/23/15.
 */
public class HibernateMain {
    public static void main(String[] args){
        UserDetails user = new UserDetails();
        user.setId(1);
        user.setName("First Name");

        /* Configure for the Hibernate */
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

    }
}
