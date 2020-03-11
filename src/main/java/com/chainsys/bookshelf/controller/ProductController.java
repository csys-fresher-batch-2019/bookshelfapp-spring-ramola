package com.chainsys.bookshelf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.bookshelf.dto.MessageDTO;
import com.chainsys.bookshelf.implementations.BooksDAOImpl;
import com.chainsys.bookshelf.implementations.LoginDAOImpl;
import com.chainsys.bookshelf.model.Book;
import com.chainsys.bookshelf.model.User;

@RestController
@RequestMapping("api")
public class ProductController {
	@GetMapping("/Register")
	public MessageDTO register(@RequestParam("uname") String uName, @RequestParam("email") String eMail,
			@RequestParam("pno") long phoneNo, @RequestParam("ptype") String preType,
			@RequestParam("password") String password) throws Exception {
		MessageDTO msg = new MessageDTO();
		User l1 = new User();

		l1.setUserName(uName);
		l1.seteMail(eMail);
		l1.setPhoneNo(phoneNo);
		l1.setPreferenceType(preType);
		l1.setPassword(password);

		LoginDAOImpl li = new LoginDAOImpl();
		int a = li.saveUser(l1);
		if (a == 1) {
			msg.setInfoMessage("Successfully registered");
		} else {
			msg.setErrorMessage("Registration Failed");
		}
		return msg;

	}

	@GetMapping("/Login")
	public MessageDTO login(@RequestParam("email") String eMail, @RequestParam("password") String password)
			throws Exception {
		MessageDTO msg = new MessageDTO();
		User l1 = new User();

		String email = l1.seteMail(eMail);
		String pwd = l1.setPassword(password);

		LoginDAOImpl li = new LoginDAOImpl();
		String a = li.userLogin(email, pwd);
		if (a.equals("success") || a.equals("admin")) {
			msg.setInfoMessage("Logged in Successful");
		} else {
			msg.setErrorMessage("Login Failed");
		}
		return msg;

	}

	@GetMapping("/viewbooks")
	public List<Book> viewbooks() throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Book> l = new ArrayList<Book>();

		l = bl.viewAllBooks();

		return l;

	}

	@GetMapping("/ExtractAuthorSpecificBooks")
	public List<Book> AuthorSpecificBooks(@RequestParam("author") String bookAuthor) throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Book> l = new ArrayList<Book>();
		Book b = new Book();
		String author = b.setBookAuthor(bookAuthor);
		l = bl.findByAuthor(author);

		return l;

	}

	@GetMapping("/ExtractTypeSpecificBooks")
	public List<Book> TypeSpecificBooks(@RequestParam("type") String bookType) throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Book> l = new ArrayList<Book>();
		Book b = new Book();
		String type = b.setBookType(bookType);
		l = bl.findByBookType(type);

		return l;

	}

	@GetMapping("/ExtractLanguageSpecificBooks")
	public List<Book> LanguageSpecificBooks(@RequestParam("language") String bookLanguage) throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Book> l = new ArrayList<Book>();
		Book b = new Book();
		String language = b.setBookLanguage(bookLanguage);
		l = bl.findByLanguage(language);

		return l;

	}

	@GetMapping("/ExtractRelatedBooks")
	public List<Book> ExtractRelatedBooks(@RequestParam("name") String bookName) throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Book> l = new ArrayList<Book>();
		Book b = new Book();
		String name = b.setBookName(bookName);
		l = bl.findRelatedBookName(name);

		return l;

	}

	@GetMapping("/viewHighlyRatedBooks")
	public List<Book> viewHighlyRatedBooks() throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Book> l = new ArrayList<Book>();

		l = bl.findHighlyRatedBooks();

		return l;

	}

	@GetMapping("/viewTodaysSpecial")
	public List<Book> viewTodaysSpecial() throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Book> l = new ArrayList<Book>();

		l = bl.findTodaysSpecial();

		return l;
	}

}
