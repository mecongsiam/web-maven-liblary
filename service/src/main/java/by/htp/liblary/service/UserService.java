package by.htp.liblary.service;


import java.util.List;

import by.htp.liblary.dao.*;

import by.htp.liblary.dao.exception.DAOException;

import by.htp.liblary.entity.Book;
import by.htp.liblary.entity.User;
import by.htp.liblary.service.exception.ServiceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserService<T> implements IUserService {
    @Autowired
    private UserOperationDAO dbUserOperationDAO;
    @Autowired
    private BookOperationDAO bookOperationDAO;
    @Autowired
    private SessionFactory sessionFactory;


    public User checkLogin(String login, String password) throws ServiceException {

        User result = null;
        if (!Validator.loginValidator(login, password)) {

            throw new ServiceException("Invalid login or password");
        }


        try {

            result = dbUserOperationDAO.login(login, password);


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

    public boolean regUser(String login, String password, String name, String surname, String email,
                           String address, String phone, String role) throws ServiceException {
        boolean result = false;

        try {

            result = dbUserOperationDAO.register(login, password, name, email, address, phone, role, surname);

        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }
        return result;
    }

    public  List<User> showUsers(int page, int interval) throws ServiceException {
        List<User> result;
        try {

            result = dbUserOperationDAO.takeUserInformation(page, interval);

        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }
        return result;

    }

    public  int countAllUsers() throws ServiceException {
        int countAllUsers;

        try {
            countAllUsers = dbUserOperationDAO.countAllUsers();

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        System.out.println(countAllUsers + "service");
        return countAllUsers;
    }

    public  List<Book> showBooks() throws ServiceException {
        List<Book> result;

        try {

            result = bookOperationDAO.takeBookInformation();

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

    public  boolean reqLoginDualityValidator(String login) throws ServiceException {
        boolean result = false;

        try {

            result = dbUserOperationDAO.checkLoginDuality(login);

        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }

        if (!result) {
            return false;
        }

        return true;
    }

    @Override
    public User getUserByLogin(String login) {
        User user;
        user=dbUserOperationDAO.readByLogin(login);
        return user;
    }

    public  boolean regEmailDualityValidatoe(String email) throws ServiceException {
        boolean result;

        try {

            result = dbUserOperationDAO.checkEmailDuality(email);

        } catch (DAOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(e.getMessage(), e);
        }

        if (result) {
            return false;
        }

        return true;
    }
    public UserOperationDAO getDbUserOperationDAO() {
        return dbUserOperationDAO;
    }



}
