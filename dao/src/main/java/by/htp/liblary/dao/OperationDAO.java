package by.htp.liblary.dao;

import by.htp.liblary.dao.exception.DAOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by meco on 09.06.2016.
 */
public abstract class OperationDAO<T> {
    @Autowired
    private SessionFactory sessionFactory;
    Session session;

    public T create(T t) {
        System.out.println(session);
        Session session = getCurrentSession();
        System.out.println(session.hashCode());
        session.save(t);
        return t;
    }

    public T read(int id) throws DAOException {
        T t = null;
        Session session = getCurrentSession();
        try {
            t = (T) session.get(getPersistentClass(), id);
        } catch (Exception e) {
            throw new DAOException(e.getMessage().toString());
        }
        return t;
    }

    public T update(T t) {
        Session session = getCurrentSession();
        session.saveOrUpdate(t);
        return t;
    }


    public T delete(T t) {
        Session session = getCurrentSession();
        session.delete(t);
        return t;
    }

    public abstract Class getPersistentClass();

    public Session getCurrentSession() {

        return sessionFactory.getCurrentSession();
    }
}
