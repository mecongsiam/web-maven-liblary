package by.htp.liblary.service;


import java.util.List;

import by.htp.liblary.dao.*;

import by.htp.liblary.dao.exception.DAOException;

import by.htp.liblary.entity.Book;
import by.htp.liblary.entity.User;
import by.htp.liblary.service.exception.ServiceException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public final class UserService {


    public static User checkLogin(String login, String password) throws ServiceException {

        User result = null;
        if (!Validator.loginValidator(login, password)) {

            throw new ServiceException("Invalid login or password");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserOperationDAO userOpDAO = daoFactory.getUserOpDao();
        Session session = HibernateSessionManager.currentSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = userOpDAO.login(login, password);
            transaction.commit();
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }
        if (result == null) {
            return new User();
        } else {

            return result;
        }

    }

    static class Validator {
        public static boolean loginValidator(String login, String password) {
            if (login.isEmpty()) {
                return false;
            }
            if (password.isEmpty()) {
                return false;
            }
            return true;
        }

    }

    public static boolean regUser(String login, String password, String name, String surname, String email,
                                  String address, String phone, String role) throws ServiceException {
        boolean result = false;
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserOperationDAO userOpDAO = daoFactory.getUserOpDao();
        try {

            Session session = HibernateSessionManager.currentSession();

            Transaction transaction = session.beginTransaction();

            result = userOpDAO.register(login, password, name, email, address, phone, role, surname);
            transaction.commit();
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }

        return result;
    }

    public static List<User> showUsers(int page,int interval) throws ServiceException {
        List<User> result;
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserOperationDAO userOpDAO = daoFactory.getUserOpDao();
        try {
            Session session = HibernateSessionManager.currentSession();
            Transaction transaction = session.beginTransaction();
            result = userOpDAO.takeUserInformation(page,interval);
            transaction.commit();
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }
        return result;

    }
    public static int countAllUsers() throws ServiceException{
        int countAllUsers;
        DAOFactory daoFactory=DAOFactory.getInstance();
        UserOperationDAO userOpDao=daoFactory.getUserOpDao();
        Session session=HibernateSessionManager.currentSession();
        Transaction transaction=session.beginTransaction();
        try {
             countAllUsers= userOpDao.countAllUsers();

            transaction.commit();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        System.out.println(countAllUsers+"service");
        return countAllUsers;
    }

    public static List<Book> showBooks() throws ServiceException {
        List<Book> result;
        DAOFactory daoFactory = DAOFactory.getInstance();
        BookOperationDAO bookOpDAO = daoFactory.getBookOpDao();
        try {
            Session session = HibernateSessionManager.currentSession();
            Transaction transaction = session.beginTransaction();
            result = bookOpDAO.takeBookInformation();
            transaction.commit();
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }
        return result;

    }

    public static boolean regLoginValidator(String login) {
        if (login.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean regPasswordValidator(String password) {
        if (password.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean reqNameValidator(String name) {
        if (name.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean reqSurnameValidator(String surname) {
        if (surname.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean reqEmailValidator(String email) {
        if (email.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean reqAdressValidator(String address) {
        if (address.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean reqPhoneValidator(String phone) {
        if (phone.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean reqRoleValidator(String userRole) {
        if (userRole.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean reqLoginDualityValidator(String login) throws ServiceException {
        boolean result = false;
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserOperationDAO userOpDAO = daoFactory.getUserOpDao();
        try {
            Session session = HibernateSessionManager.currentSession();
            Transaction transaction = session.beginTransaction();
            result = userOpDAO.checkLoginDuality(login);
            transaction.commit();
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }

        if (!result) {
            return false;
        }

        return true;
    }

    public static boolean regEmailDualityValidatoe(String email) throws ServiceException {
        boolean result;
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserOperationDAO userOpDAO = daoFactory.getUserOpDao();
        try {
            Session session = HibernateSessionManager.currentSession();
            Transaction transaction = session.beginTransaction();
            result = userOpDAO.checkEmailDuality(email);
            transaction.commit();
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }

        if (result) {
            return false;
        }

        return true;
    }

}
