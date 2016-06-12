package by.htp.liblary.dao;


import java.util.List;


import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.Book;
import org.hibernate.Query;
import org.hibernate.Session;

public class DBBookOperationDAO extends OperationDAO implements BookOperationDAO {
    @Override
    public Class getPersistentClass() {
        return Book.class;
    }

    @Override
    public List<Book> takeBookInformation() throws DAOException {
        Session session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Book");
        List<Book> bookList = (List<Book>) query.list();
        session.close();
        return bookList;

    }


}
