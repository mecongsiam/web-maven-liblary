package by.htp.liblary.service;

import java.util.ArrayList;

import by.htp.liblary.dao.BookOperationDAO;
import by.htp.liblary.dao.DAOFactory;
import by.htp.liblary.dao.DBBookOperationDAO;
import by.htp.liblary.dao.UserOperationDAO;
import by.htp.liblary.dao.connection_pool.ConnectionPool;
import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.Abonement;
import by.htp.liblary.entity.Book;
import by.htp.liblary.entity.User;
import by.htp.liblary.service.exception.ServiceException;

public final class UserService {


	public final static User checkLogin(String login, String password) throws ServiceException {

		User result = null;
		if (!Validator.loginValidator(login, password)) {

			throw new ServiceException("Invalid login or password");
		}
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserOperationDAO userOpDAO = daoFactory.getUserOpDao();
		try {
			result = userOpDAO.login(login, password);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(), e);
		}

		return result;

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
			result = userOpDAO.register(login, password, name, email, address, phone, role, surname);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(), e);
		}

		return result;
	}

	public static ArrayList<Abonement> showUsers() throws ServiceException {
		ArrayList<Abonement> result;
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserOperationDAO userOpDAO = daoFactory.getUserOpDao();
		try {
			result = userOpDAO.takeUserInformation();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(), e);
		}
		return result;

	}

	public static ArrayList<Book> showBooks() throws ServiceException {
		ArrayList<Book> result;
		DAOFactory daoFactory = DAOFactory.getInstance();
		BookOperationDAO bookOpDAO = daoFactory.getBookOpDao();
		try {
			result = bookOpDAO.takeBookInformation();
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
			result = userOpDAO.checkLoginDuality(login);
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
			result = userOpDAO.checkEmailDuality(email);
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
