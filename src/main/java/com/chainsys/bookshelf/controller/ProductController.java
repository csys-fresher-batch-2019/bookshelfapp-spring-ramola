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
import com.chainsys.bookshelf.model.Books;
import com.chainsys.bookshelf.model.Login;

@RestController
@RequestMapping("api")
public class ProductController {
	@GetMapping("/Register")
	public MessageDTO register(@RequestParam("uname") String uName, @RequestParam("email") String eMail,
			@RequestParam("pno") long phoneNo, @RequestParam("ptype") String preType,
			@RequestParam("password") String password) throws Exception {
		MessageDTO msg = new MessageDTO();
		Login l1 = new Login();

		l1.setUserName(uName);
		l1.seteMail(eMail);
		l1.setPhoneNo(phoneNo);
		l1.setPreferenceType(preType);
		l1.setPassword(password);

		LoginDAOImpl li = new LoginDAOImpl();
		int a = li.newLogin(l1);
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
		Login l1 = new Login();

		String email = l1.seteMail(eMail);
		String pwd = l1.setPassword(password);

		LoginDAOImpl li = new LoginDAOImpl();
		String a = li.userLoginValidation(email, pwd);
		if (a.equals("success") || a.equals("admin")) {
			msg.setInfoMessage("Logged in Successful");
		} else {
			msg.setErrorMessage("Login Failed");
		}
		return msg;

	}

	@GetMapping("/viewbooks")
	public List<Books> viewbooks() throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Books> l = new ArrayList<Books>();

		l = bl.viewAllBooks();

		return l;

	}

	@GetMapping("/ExtractAuthorSpecificBooks")
	public List<Books> AuthorSpecificBooks(@RequestParam("author") String bookAuthor) throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Books> l = new ArrayList<Books>();
		Books b = new Books();
		String author = b.setBookAuthor(bookAuthor);
		l = bl.extractAuthorSpecificBooks(author);

		return l;

	}

	@GetMapping("/ExtractTypeSpecificBooks")
	public List<Books> TypeSpecificBooks(@RequestParam("type") String bookType) throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Books> l = new ArrayList<Books>();
		Books b = new Books();
		String type = b.setBookType(bookType);
		l = bl.extractTypeSpecificBooks(type);

		return l;

	}

	@GetMapping("/ExtractLanguageSpecificBooks")
	public List<Books> LanguageSpecificBooks(@RequestParam("language") String bookLanguage) throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Books> l = new ArrayList<Books>();
		Books b = new Books();
		String language = b.setBookLanguage(bookLanguage);
		l = bl.extractLanguageSpecificBooks(language);

		return l;

	}

	@GetMapping("/ExtractRelatedBooks")
	public List<Books> ExtractRelatedBooks(@RequestParam("name") String bookName) throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Books> l = new ArrayList<Books>();
		Books b = new Books();
		String name = b.setBookName(bookName);
		l = bl.extractRelatedBooks(name);

		return l;

	}

	@GetMapping("/viewHighlyRatedBooks")
	public List<Books> viewHighlyRatedBooks() throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Books> l = new ArrayList<Books>();

		l = bl.extractHighlyRatedBooks();

		return l;

	}

	@GetMapping("/viewTodaysSpecial")
	public List<Books> viewTodaysSpecial() throws Exception {
		BooksDAOImpl bl = new BooksDAOImpl();
		List<Books> l = new ArrayList<Books>();

		l = bl.extractTodaysSpecial();

		return l;
	}

}
