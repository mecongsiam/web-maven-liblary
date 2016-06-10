package by.htp.liblary.dao;

import by.htp.liblary.dao.exception.DAOException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by meco on 09.06.2016.
 */
public abstract class OperationDAO<T> {
    public T create(T t) {
        Session session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(t);
        session.getTransaction().commit();
        session.close();

        return t;

    }

    public T read( int id) throws DAOException {
        T t=null;
        Session session = HibernateSessionManager.getSessionFactory().openSession();

        Transaction transaction=session.beginTransaction();
        System.out.print(getClass().getTypeParameters()[0]);

        try{

            t = (T) session.get(getPersistentClass(), id);}catch(Exception e){
            throw new DAOException(e.getMessage().toString());
        }
        transaction.commit();
        session.close();
        return t;


    }

    public T update(T t) {
        Session session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
        return t;
    }


    public T delete(T t) {
        Session session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(t);
        session.getTransaction().commit();
        session.close();
        return t;

    }
    public abstract   Class getPersistentClass();

}
