package by.htp.liblary.dao;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();


	private UserOperationDAO userOpDao = new DBUserOperationDAO();
	private BookOperationDAO bookOpDao = new DBBookOperationDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {

		return instance;
	}

	public UserOperationDAO getUserOpDao() {
		return userOpDao;
	}



	public BookOperationDAO getBookOpDao() {
		return bookOpDao;
	}



}
