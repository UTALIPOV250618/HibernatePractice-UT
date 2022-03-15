package peaksoft.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import peaksoft.models.Auto;
import peaksoft.models.User;


import java.sql.SQLException;
/** Начнем с утилитного класса HibernateSessionFactoryUtil.
 * У него всего одна задача — создавать для нашего приложения фабрику сессий для работы с БД */

public class HibernateSessionFactoryUtil {

    private static final SessionFactory session = buildSession();

    public static SessionFactory buildSession(){
        try{
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e){
            System.out.println("Session not created");
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        return session;
    }

    public static void  shutDown(){
        getSessionFactory().close();
    }


}
