package com.chainsys.bookshelf.dao;

import java.util.List;

//import org.jdbi.v3.sqlobject.customizer.BindBean;
//import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.bookshelf.model.Books;

public interface BooksDAO {
	List<Books> extractAuthorSpecificBooks(String bookAuthor) throws Exception;

	List<Books> extractTypeSpecificBooks(String bookType) throws Exception;

	List<Books> extractLanguageSpecificBooks(String bookLanguage) throws Exception;

	List<Books> extractHighlyRatedBooks() throws Exception;

	List<Books> viewAllBooks() throws Exception;

	List<Books> extractTodaysSpecial() throws Exception;

	List<Books> extractRelatedBooks(String bookName) throws Exception;

	public void addBook(Books ab) throws Exception;

	public void updateBookLanguage(Books ab) throws Exception;

	public void deleteBook(Books ab) throws Exception;

}
