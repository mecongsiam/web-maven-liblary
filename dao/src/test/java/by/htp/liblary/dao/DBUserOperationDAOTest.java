package by.htp.liblary.dao;

import by.htp.liblary.dao.connection_pool.ConnectionPool;
import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.User;

import junit.framework.TestCase;


import java.sql.SQLException;

/**
 * Created by meco on 20.05.2016.
 */
public class DBUserOperationDAOTest extends TestCase {
    DBUserOperationDAO test;
    ConnectionPool connectionPool = null;


    public void setUp() throws Exception {
        super.setUp();
        connectionPool = ConnectionPool.getInstance();
        connectionPool.initPoolData();
        test = new DBUserOperationDAO();


    }


    public void testLogin() throws Exception {


        User us = new User();
        us.setLogin("admin");
       // us.setIdUser(12);
        us.setRole("admin");

        assertEquals(us, test.login("admin", "admin"));


    }

    public void testNoLogin() throws Exception {
        User us = new User();
        us.setLogin("admin");
       // us.setIdUser(12);
        us.setRole("admin");

        assertNotSame(us, test.login("pp", "pp"));


    }

    public void testRegister() throws Exception {

        // assertEquals(true,test.register("jimmy","qweasd","lexa","lexa@gmail.com","minsk","2222222","admin","pushkin"));

    }

    public void testRegisterSQLException() throws DAOException {
        try {

            assertEquals(new SQLException(), test.register("admino", "admin", "lexa", "admin@gamil.com", "minsk", "2222222", "admin", "pushkin"));
        } catch (DAOException e) {
            System.out.println(e.toString());

        }
        ;

    }

    public void testTakeUserInformation() throws Exception {
        assertNotNull(test.takeUserInformation());


    }

    public void testCheckLoginDuality() throws Exception {
        assertEquals(false, test.checkLoginDuality("admin"));

    }


    public void testCheckEmailDuality() throws Exception {
        assertEquals(true, test.checkEmailDuality("pup@gmail.com"));

    }

}