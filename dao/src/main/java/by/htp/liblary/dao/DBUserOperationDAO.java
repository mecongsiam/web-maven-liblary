package by.htp.liblary.dao;


import java.util.List;

import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.Abonement;
import by.htp.liblary.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class DBUserOperationDAO extends OperationDAO implements UserOperationDAO {


    public User login(String login, String password) {


        Session session = HibernateSessionManager.currentSession();
        Criteria criteria = session.createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("login", login));
        criteria.add(Restrictions.eq("password", login));
        User user = (User) criteria.uniqueResult();
        session.close();

        return user;

    }

    public boolean register(String login, String password, String name, String email, String address, String phone,
                            String role, String surname) throws DAOException {

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        Abonement abonement = new Abonement();
        abonement.setName(name);
        abonement.setSurname(surname);
        abonement.setEmail(email);
        abonement.setAddress(address);
        abonement.setPhone(phone);
        user.setAbonement(abonement);
        abonement.setUser(user);

        create(user);


        return true;
    }


    public boolean checkLoginDuality(String login) throws DAOException {
        Session session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("login", login));

        if (criteria.uniqueResult() != null) {
            return false;
        }
        return true;
    }

    public boolean checkEmailDuality(String email) throws DAOException {
        Session session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Abonement.class);
        criteria.add(Restrictions.eq("email", email));

        if (criteria.uniqueResult() != null) {
            return true;
        }
        return false;
    }


    @Override
    public List<User> takeUserInformation() throws DAOException {
        Session session = HibernateSessionManager.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> userList = query.list();
        session.close();
        return userList;

    }

    @Override
    public Class getPersistentClass() {
        return User.class;
    }
}