package by.htp.liblary.dao;

import by.htp.liblary.dao.connection_pool.ConnectionPool;
import by.htp.liblary.dao.connection_pool.ConnectionPoolException;
import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.User;

/**
 * Created by meco on 09.06.2016.
 */
public class Tets {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            connectionPool.initPoolData();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
        DBUserOperationDAO dbUserOperationDAO = new DBUserOperationDAO();
        try {
            User user=dbUserOperationDAO.login("admin","admin");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}