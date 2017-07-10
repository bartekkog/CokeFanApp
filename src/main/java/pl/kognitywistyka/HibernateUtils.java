package pl.kognitywistyka;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Anna on 10.07.2017.
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private static void buildSessionFactory(){
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) buildSessionFactory();
        return sessionFactory;
    }

    public static void closeSessionFactory(){
        if(sessionFactory!= null){
            sessionFactory.close();
        }
    }
}
