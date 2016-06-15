package by.htp.liblary.dao;


import java.util.List;

import by.htp.liblary.dao.exception.DAOException;

import by.htp.liblary.entity.User;

public interface UserOperationDAO<T> {

    User login(String login, String password) throws DAOException;

    T update(T t);

    T create(T t);

    T read(int id) throws DAOException;

    T delete(T t);

    boolean register(String login, String password, String name, String email, String address, String phone,
                     String role, String surname) throws DAOException;

     boolean checkLoginDuality(String login) throws DAOException;

     boolean checkEmailDuality(String email) throws DAOException;

     List<User> takeUserInformation(int page,int interval) throws DAOException;

    int countAllUsers() throws DAOException;



}
