package by.htp.liblary.dao;

import java.util.ArrayList;

import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.Abonement;
import by.htp.liblary.entity.User;

public interface UserOperationDAO {

	User login(String login, String password) throws DAOException;

	boolean register(String login, String password, String name, String email, String address, String phone,
			String role, String surname) throws DAOException;
	public boolean checkLoginDuality(String login) throws DAOException;
	public boolean checkEmailDuality(String email) throws DAOException;
	public ArrayList<Abonement> takeUserInformation() throws DAOException;

}
