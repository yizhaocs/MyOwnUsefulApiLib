package main.java.com.yizhao.main;

import main.java.com.yizhao.dto.UserDetails;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.Date;

/**
 * Created by YZ on 10/23/15.
 */
public class HibernateMain {
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setUserId(1);
        user.setUserName("Yi Zhao");
        user.setAddress("245 WOODWARD DR");
        user.setJoinedDateTime(new Date());
        user.setJoinedDate(new Date());
        user.setJoinedTime(new Date());
        user.setDescription("Yi Zhao's home");

        /* Configure for the Hibernate */
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails user2 = (UserDetails) session.get(UserDetails.class, 1); // pass into (Object.class, primary key)
        System.out.println("User Name retrieved is :" + user2.getUserName());
    }
}
