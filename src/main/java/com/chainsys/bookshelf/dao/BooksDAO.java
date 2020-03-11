package com.chainsys.bookshelf.dao;

import java.util.List;

import com.chainsys.bookshelf.exception.DBException;

//import org.jdbi.v3.sqlobject.customizer.BindBean;
//import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.bookshelf.model.Book;

public interface BooksDAO {
	List<Book> findByAuthor(String bookAuthor) throws DBException;

	List<Book> findByBookType(String bookType) throws DBException;

	List<Book> findByLanguage(String bookLanguage) throws DBException;

	List<Book> findHighlyRatedBooks() throws DBException;

	List<Book> viewAllBooks() throws DBException;

	List<Book> findTodaysSpecial() throws DBException;

	List<Book> findRelatedBookName(String bookName) throws DBException;

	public int addBook(Book ab) throws DBException;

	public void updateBookLanguage(Book ab) throws DBException;

	public int deleteBook(Book ab) throws DBException;

}
