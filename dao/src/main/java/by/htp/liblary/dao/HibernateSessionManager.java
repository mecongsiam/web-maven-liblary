package by.htp.liblary.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by meco on 09.06.2016.
 */
public class HibernateSessionManager {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    public static final ThreadLocal local = new ThreadLocal();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    public static Session currentSession() {
        Session session = (Session) local.get();
        if (session == null) {
            session = sessionFactory.openSession();
            local.set(session);
        }

        return session;
    }
}
