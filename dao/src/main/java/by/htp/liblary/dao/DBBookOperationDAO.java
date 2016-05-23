package by.htp.liblary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import by.htp.liblary.dao.connection_pool.ConnectionPool;
import by.htp.liblary.dao.connection_pool.ConnectionPoolException;
import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.Book;

public class DBBookOperationDAO implements BookOperationDAO {
	private static final String SQL_BOOK_CATALOG="SELECT id_book,book_auther.name,"
			+ "group_concat(surname),year as surname from book_auther group by id_book";


	public ArrayList<Book> takeBookInformation() throws DAOException {
		// TODO Auto-generated method stub
		ArrayList<Book> arr = new ArrayList<Book>();
		Book book;

		ConnectionPool p = ConnectionPool.getInstance();
		Connection con = null;

		ResultSet rs = null;

		try {
			
			con = p.takeConnection();
			try {

				PreparedStatement pr = con.prepareStatement(SQL_BOOK_CATALOG);

				rs = pr.executeQuery();
				while (rs.next()) {
					book = new Book();
					book.setId(Integer.parseInt(rs.getString(1)));
					book.setName(rs.getString(2));
					book.setAuther(rs.getString(3));
					book.setYear(Integer.parseInt(rs.getString(4)));

					arr.add(book);

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

}
