package by.htp.liblary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import by.htp.liblary.dao.connection_pool.ConnectionPool;
import by.htp.liblary.dao.connection_pool.ConnectionPoolException;
import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.Abonement;
import by.htp.liblary.entity.User;

public class DBUserOperationDAO implements UserOperationDAO {
	final private static String SQL_LOGIN = "SELECT role.user_role,users.name,users.id_user "
			+ "FROM liblary.users,liblary.role where name= ? and password= ? "
			+ "and liblary.users.id_user=liblary.role.id_user";
	private static final String SQL_REGISTER_INSERT_USERS = "INSERT users (name,password) VALUES(?,?)";
	private static final String SQL_REGISTER_TAKE_ID = "SELECT id_user FROM users WHERE name= ?";
	private static final String SQL_REGISTER_INSERT_ROLE = "INSERT role (id_user,user_role) VALUES(?,?)";
	private static final String SQL_REGISTER_INSERT_ABONEMENT = "INSERT abonement (id_user,name,surname,email,adress,phone) VALUES(?,?,?,?,?,?)";
	private static final String SQL_CHECK_LOGIN = "SELECT name FROM users WHERE name= ?";
	private static final String SQL_CHECK_EMAIL = "SELECT email FROM abonement WHERE email= ?";
	//private static final String SQL_TAKE_USERS="";


	public User login(String login, String password) throws DAOException {
		ConnectionPool p = ConnectionPool.getInstance();
		Connection con = null;

		ResultSet rs = null;

		try {

			con = p.takeConnection();

			try {

				PreparedStatement pr = con.prepareStatement(SQL_LOGIN);

				pr.setString(1, login);
				pr.setString(2, password);
				rs = pr.executeQuery();
				User user = new User();
				while (rs.next()) {

					user.setRole(rs.getString(1));
					user.setLogin(rs.getString(2));
					user.setIdUser(rs.getInt(3));

				}

				con.close();

				return user;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DAOException(e.getMessage(),e);
			}

		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage(),e);
		}

	}

	public boolean register(String login, String password, String name, String email, String address, String phone,
			String role, String surname) throws DAOException {
		int id = 0;
		ConnectionPool p = ConnectionPool.getInstance();
		Connection con = null;

		ResultSet rs = null;

		try {

			con = p.takeConnection();


			try {
				con.setAutoCommit(false);

				PreparedStatement pr = con.prepareStatement(SQL_REGISTER_INSERT_USERS);

				pr.setString(1, login);
				pr.setString(2, password);
				pr.executeUpdate();

				pr = con.prepareStatement(SQL_REGISTER_TAKE_ID);
				pr.setString(1, login);
				rs = pr.executeQuery();
				while (rs.next()) {
					id = Integer.parseInt(rs.getString(1));
				}

				pr = con.prepareStatement(SQL_REGISTER_INSERT_ROLE);
				pr.setInt(1, id);
				pr.setString(2, role);
				pr.executeUpdate();

				pr = con.prepareStatement(SQL_REGISTER_INSERT_ABONEMENT);
				pr.setInt(1, id);
				pr.setString(2, name);
				pr.setString(3, surname);
				pr.setString(4, email);
				pr.setString(5, address);
				pr.setString(6, phone);
				pr.executeUpdate();
				con.commit();

				con.close();
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DAOException(e.getMessage(),e);
			}

		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage(),e);
		}
		

	}

	public ArrayList<Abonement> takeUserInformation() throws DAOException  {
		ArrayList<Abonement> arr = new ArrayList<Abonement>();
		Abonement abonement;

		ConnectionPool p = ConnectionPool.getInstance();
		Connection con = null;

		ResultSet rs = null;

		try {
		
			con = p.takeConnection();
			try {

				String sql = "SELECT users.name,id_abonement,abonement.name," + "surname,email,adress,phone "
						+ "from users,abonement where users.id_user=abonement.id_user";
				PreparedStatement pr = con.prepareStatement(sql);

				rs = pr.executeQuery();
				while (rs.next()) {
					abonement = new Abonement();
					abonement.setLogin(rs.getString(1));
					abonement.setIdAbonement(Integer.parseInt(rs.getString(2)));
					abonement.setName(rs.getString(3));
					abonement.setSurname(rs.getString(4));
					abonement.setEmail(rs.getString(5));
					abonement.setAddress(rs.getString(6));
					abonement.setPhone(rs.getString(7));
					arr.add(abonement);


				}

				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DAOException(e.getMessage(),e);
			}

		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage(),e);
		}
		return arr;
	}

	public boolean checkLoginDuality(String login) throws DAOException {
		String resultLogin = null;
		boolean result = false;
		ConnectionPool p = ConnectionPool.getInstance();
		Connection con = null;

		ResultSet rs = null;

		try {
			con = p.takeConnection();
			try {

				PreparedStatement pr = con.prepareStatement(SQL_CHECK_LOGIN);
				pr.setString(1, login);
				rs = pr.executeQuery();
				while (rs.next()) {
					resultLogin = rs.getString(1);
				}

				if (resultLogin == null) {
					result = true;
				}

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DAOException(e.getMessage(),e);
			}

		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage(),e);
		}

		return result;
	}

	public boolean checkEmailDuality(String email) throws DAOException {
		String resultEmail = null;
		boolean result = false;
		ConnectionPool p = ConnectionPool.getInstance();
		Connection con = null;

		ResultSet rs = null;

		try {
			con = p.takeConnection();
			try {

				PreparedStatement pr = con.prepareStatement(SQL_CHECK_EMAIL);
				pr.setString(1, email);
				rs = pr.executeQuery();
				while (rs.next()) {
					resultEmail = rs.getString(1);
				}

				if (resultEmail != null) {

					result = true;

				}

				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DAOException(e.getMessage(),e);
			}

		} catch (ConnectionPoolException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e.getMessage(),e);
		}

		return result;
	}
}