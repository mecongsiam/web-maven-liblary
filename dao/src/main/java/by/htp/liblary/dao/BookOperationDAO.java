package by.htp.liblary.dao;

import java.util.ArrayList;
import java.util.List;

import by.htp.liblary.dao.exception.DAOException;
import by.htp.liblary.entity.Book;

public interface BookOperationDAO<T> {

	T  update(T t);
	T  create(T t);
	T read(int id) throws DAOException;
	T delete(T t);
	List<Book> takeBookInformation() throws DAOException;

}
