package by.htp.liblary.dao;

import java.util.ArrayList;

import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.Book;

public interface BookOperationDAO {
	public ArrayList<Book> takeBookInformation() throws DAOException;

}
