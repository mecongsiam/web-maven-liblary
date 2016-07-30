package by.htp.liblary.service;

import by.htp.liblary.entity.Book;
import by.htp.liblary.entity.User;
import by.htp.liblary.service.exception.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by meco on 01.07.2016.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public interface IUserService<T> {
    User checkLogin(String login, String password) throws ServiceException;

    boolean regUser(String login, String password, String name, String surname, String email,
                    String address, String phone, String role) throws ServiceException;

    List<Book> showBooks() throws ServiceException;

    List<User> showUsers(int page, int interval) throws ServiceException;

    int countAllUsers() throws ServiceException;
    boolean regEmailDualityValidatoe(String email) throws ServiceException;
    boolean reqLoginDualityValidator(String login) throws ServiceException;
    User getUserByLogin(String login);
}
