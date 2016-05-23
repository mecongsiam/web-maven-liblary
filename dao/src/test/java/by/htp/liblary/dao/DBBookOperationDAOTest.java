package by.htp.liblary.dao;

import by.htp.liblary.dao.connection_pool.ConnectionPool;
import by.htp.liblary.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by meco on 21.05.2016.
 */
public class DBBookOperationDAOTest {
    ConnectionPool connectionPool = null;
    DBBookOperationDAO dbBookTest;
    @Before
    public void setUp() throws Exception {
        connectionPool = ConnectionPool.getInstance();
        connectionPool.initPoolData();
        dbBookTest=new DBBookOperationDAO();

    }

    @Test
    public void takeBookInformation() throws Exception {
        assertSame(new ArrayList<Book>().getClass(),dbBookTest.takeBookInformation().getClass());


    }

}