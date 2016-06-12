package by.htp.liblary.dao;

import by.htp.liblary.dao.connection_pool.ConnectionPool;
import by.htp.liblary.dao.connection_pool.ConnectionPoolException;
import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.Auther;
import by.htp.liblary.entity.Book;
import by.htp.liblary.entity.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        DBBookOperationDAO dbBookOperationDAO=new DBBookOperationDAO();
        try {
            List<Book> books=dbBookOperationDAO.takeBookInformation();
            for(Book book:books){
            Set<Auther> autherSet=book.getAuthers();
            StringBuilder  authers=new StringBuilder();
                String result="";
            for(Auther auther:autherSet){

            authers.append(auther.getName());
                authers.append(",");

            }
               result=authers.substring(0,authers.length()-1);
                System.out.println(result);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }


    }
}