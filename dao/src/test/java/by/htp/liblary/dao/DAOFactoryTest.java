package by.htp.liblary.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by meco on 21.05.2016.
 */
public class DAOFactoryTest {
    UserOperationDAO userOpDao;
    BookOperationDAO bookOpDao;
    DAOFactory daoFactory;

    @Before
    public void setUp() throws Exception {
         daoFactory=DAOFactory.getInstance();
          userOpDao = new DBUserOperationDAO();
          bookOpDao = new DBBookOperationDAO();

    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(DAOFactory.getInstance());

    }

    @Test
    public void getUserOpDao() throws Exception {
        assertSame(userOpDao.getClass(),daoFactory.getUserOpDao().getClass());


    }



    @Test
    public void getBookOpDao() throws Exception {
        assertEquals(bookOpDao.getClass(),daoFactory.getBookOpDao().getClass());

    }



}