package com.chainsys.bookshelf.implementations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;

import com.chainsys.bookshelf.controller.IndexController;
import com.chainsys.bookshelf.dao.BooksDAO;
import com.chainsys.bookshelf.util.DbConnection;
import com.chainsys.bookshelf.exception.DBException;
import com.chainsys.bookshelf.exception.ErrorConstant;
import com.chainsys.bookshelf.model.Book;

public class BooksDAOImpl implements BooksDAO {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(IndexController.class);

	public List<Book> findByAuthor(String bookAuthor) throws DBException {

		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_author=lower(?)";

		List<Book> l = new ArrayList<Book>();
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, bookAuthor);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Book b = new Book();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(LocalDate.parse(rs.getDate(8)+""));
					b.setBookLink(rs.getString(9));
					b.setImgLink(rs.getString(10));

					l.add(b);
				}
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return (l);

	}

	public List<Book> findByBookType(String bookType) throws DBException {

		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_Type=?";

		List<Book> l = new ArrayList<Book>();

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

			pst.setString(1, bookType);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Book b = new Book();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(LocalDate.parse(rs.getDate(8)+""));
					b.setBookLink(rs.getString(9));
					b.setImgLink(rs.getString(10));

					l.add(b);
				}
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return (l);

	}

	public List<Book> findByLanguage(String bookLanguage) throws DBException {

		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_Language=?";
		List<Book> l = new ArrayList<Book>();
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

			pst.setString(1, bookLanguage);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Book b = new Book();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(LocalDate.parse(rs.getDate(8)+""));
					b.setBookLink(rs.getString(9));
					b.setImgLink(rs.getString(10));

					l.add(b);
				}
				con.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return (l);
	}

	public List<Book> findHighlyRatedBooks() throws DBException {

		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_rating>=4";
		List<Book> l = new ArrayList<Book>();
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			int rows = pst.executeUpdate(query);
			log.debug("Most Popular Books :" + rows);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Book b = new Book();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(LocalDate.parse(rs.getDate(8)+""));
					b.setBookLink(rs.getString(9));
					b.setImgLink(rs.getString(10));

					l.add(b);
				}
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return (l);
	}

	public List<Book> findTodaysSpecial() throws DBException {

		String query = "select book_name,book_version,book_Author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where trunc(book_uploaded_on)=trunc(sysdate)";
		List<Book> l = new ArrayList<Book>();

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

			int rows = pst.executeUpdate(query);
			log.debug("Today's Special Books :" + rows);

			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					Book b = new Book();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(LocalDate.parse(rs.getDate(8)+""));
					b.setBookLink(rs.getString(9));
					b.setImgLink(rs.getString(10));

					l.add(b);
				}
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}
		return (l);
	}

	public List<Book> findRelatedBookName(String bookName) throws DBException {

		String query = "select book_name,book_version,book_Author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_name like ?";
		List<Book> l = new ArrayList<Book>();

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, "%" + bookName + "%");

			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					Book b = new Book();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(LocalDate.parse(rs.getDate(8)+""));
					b.setBookLink(rs.getString(9));
					b.setImgLink(rs.getString(10));

					l.add(b);
				}
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return (l);
	}

	public int addBook(Book ab) throws DBException {
		String query = "insert into books(book_id,book_name,book_version,book_author,book_language,book_type,book_publisher,book_published_date,booklink,imglink)values(BOOK_ID_SQC.nextval,lower(?),?,lower(?),?,?,?,?,?,?)";
		int rows;
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query);) {

			pst.setString(1, ab.getBookName());
			pst.setInt(2, ab.getBookVersion());
			pst.setString(3, ab.getBookAuthor());
			pst.setString(4, ab.getBookLanguage());
			pst.setString(5, ab.getBookType());
			pst.setString(6, ab.getBookPublisher());
			pst.setDate(7,Date.valueOf(ab.getBookPublishedDate()));
			pst.setString(8, ab.getBookLink());
			pst.setString(9, ab.getImgLink());
			
			rows = pst.executeUpdate();
			if(rows==1)
			{
				log.debug("No of rows inserted :" + rows);
			}
			else
			{
				log.debug("Book not added");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.debug("Book not added");
			throw new DBException(ErrorConstant.INVALID_ADD);

		}return rows;

	}

	public void updateBookLanguage(Book ab) throws DBException {
		String query = "update books set book_language=? where book_name=?";

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

			pst.setString(1, ab.getBookLanguage());
			pst.setString(2, ab.getBookName());

			int rows = pst.executeUpdate();
			log.debug("No of rows Updated :" + rows);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_UPDATE);
		}

	}

	public int deleteBook(Book ab) throws DBException {
		String sql = "delete from users where book_id=?";
		String query = "delete from books where book_id=?";
		int rows = 0;

		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstm = con.prepareStatement(sql);
				PreparedStatement pst = con.prepareStatement(query)) {

			pstm.setInt(1, ab.getBookId());
			pst.setInt(1, ab.getBookId());

			rows = pst.executeUpdate();
			if (rows == 1) {
				pst.executeUpdate();
				log.debug("No of rows Deleted :" + rows);
			} else {
				log.debug("Book not found");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_DELETE);
		}
		return rows;

	}

	public List<Book> viewAllBooks() throws DBException {
		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink,book_id from books ";
		List<Book> l = new ArrayList<Book>();
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			int rows = pst.executeUpdate(query);
			log.debug("Total Books :" + rows);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Book b = new Book();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(LocalDate.parse(rs.getDate(8)+""));
					b.setBookLink(rs.getString(9));
					b.setImgLink(rs.getString(10));
					b.setBookId(rs.getInt(11));

					l.add(b);
				}
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);
		}

		return (l);

	}

}