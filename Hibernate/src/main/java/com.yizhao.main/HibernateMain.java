package main.java.com.yizhao.main;

import main.java.com.yizhao.dto.Address;
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
        /*
        * store the user object
        * */
        UserDetails user = new UserDetails();
        user.setUserId(1);
        user.setUserName("Yi Zhao");

        Address yizhaoAddress = new Address();
        yizhaoAddress.setCity("Milpitas");
        yizhaoAddress.setPinCode("95035");
        yizhaoAddress.setState("CA");
        yizhaoAddress.setStreet("245 WOODWARD DR");

        Address yizhaoHomeAddress = new Address();
        yizhaoHomeAddress.setCity("Milpitas");
        yizhaoHomeAddress.setPinCode("95035");
        yizhaoHomeAddress.setState("CA");
        yizhaoHomeAddress.setStreet("245 WOODWARD DR");

        Address yizhaoOfficeAddress = new Address();
        yizhaoOfficeAddress.setCity("Milpitas");
        yizhaoOfficeAddress.setPinCode("95035");
        yizhaoOfficeAddress.setState("CA");
        yizhaoOfficeAddress.setStreet("245 WOODWARD DR");

        user.setAddress(yizhaoAddress);
        user.setHomeAddress(yizhaoHomeAddress);
        user.setOfficeAddress(yizhaoOfficeAddress);
        user.setJoinedDateTime(new Date());
        user.setJoinedDate(new Date());
        user.setJoinedTime(new Date());
        user.setDescription("Yi Zhao's home");

        UserDetails user2 = new UserDetails();
        user2.setUserId(2);
        user2.setUserName("Wang Wu");

        Address wantwuAddress = new Address();
        wantwuAddress.setCity("SAN FRAN");
        wantwuAddress.setPinCode("95035");
        wantwuAddress.setState("CA");
        wantwuAddress.setStreet("777 PARK");

        Address wantwuHomeAddress = new Address();
        wantwuHomeAddress.setCity("SAN FRAN");
        wantwuHomeAddress.setPinCode("95035");
        wantwuHomeAddress.setState("CA");
        wantwuHomeAddress.setStreet("777 PARK");

        Address wantwuOfficeAddress = new Address();
        wantwuOfficeAddress.setCity("SAN FRAN");
        wantwuOfficeAddress.setPinCode("95035");
        wantwuOfficeAddress.setState("CA");
        wantwuOfficeAddress.setStreet("777 PARK");

        user2.setAddress(wantwuAddress);
        user2.setHomeAddress(wantwuHomeAddress);
        user2.setOfficeAddress(wantwuOfficeAddress);
        user2.setJoinedDateTime(new Date());
        user2.setJoinedDate(new Date());
        user2.setJoinedTime(new Date());
        user2.setDescription("Wang Wu's home");

        /* Configure for the Hibernate */
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.getTransaction().commit();
        session.close();


        /*
        * retrieve the user object
        * */
        session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails user3 = (UserDetails) session.get(UserDetails.class, 1); // pass into (Object.class, primary key)
        System.out.println("User Name retrieved is :" + user3.getUserName());
    }
}
