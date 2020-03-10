package com.chainsys.bookshelf.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.chainsys.bookshelf.controller.IndexController;
import com.chainsys.bookshelf.dao.BooksDAO;
import com.chainsys.bookshelf.db.DbConnection;
import com.chainsys.bookshelf.exception.DBException;
import com.chainsys.bookshelf.exception.ErrorConstant;
import com.chainsys.bookshelf.model.Books;

public class BooksDAOImpl implements BooksDAO {
	// private static final Logger log=Logger.getInstance();
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(IndexController.class);

	public List<Books> extractAuthorSpecificBooks(String bookAuthor) throws Exception {

		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_author=lower(?)";

		List<Books> l = new ArrayList<Books>();
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, bookAuthor);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					Books b = new Books();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(rs.getDate(8));
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

	public List<Books> extractTypeSpecificBooks(String bookType) throws Exception {

		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_Type=?";

		List<Books> l = new ArrayList<Books>();

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

			pst.setString(1, bookType);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Books b = new Books();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(rs.getDate(8));
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

	public List<Books> extractLanguageSpecificBooks(String bookLanguage) throws Exception {

		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_Language=?";
		List<Books> l = new ArrayList<Books>();
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

			pst.setString(1, bookLanguage);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Books b = new Books();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(rs.getDate(8));
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

	public List<Books> extractHighlyRatedBooks() throws Exception {

		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_rating>=4";
		List<Books> l = new ArrayList<Books>();
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			int rows = pst.executeUpdate(query);
			log.debug("Most Popular Books :" + rows);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Books b = new Books();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(rs.getDate(8));
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

	public List<Books> extractTodaysSpecial() throws Exception {

		String query = "select book_name,book_version,book_Author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where trunc(book_uploaded_on)=trunc(sysdate)";
		List<Books> l = new ArrayList<Books>();

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {

			int rows = pst.executeUpdate(query);
			log.debug("Today's Special Books :" + rows);

			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					Books b = new Books();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(rs.getDate(8));
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

	public List<Books> extractRelatedBooks(String bookName) throws Exception {

		String query = "select book_name,book_version,book_Author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books where book_name like ?";
		List<Books> l = new ArrayList<Books>();

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, "%" + bookName + "%");

			try (ResultSet rs = pst.executeQuery();) {

				while (rs.next()) {
					Books b = new Books();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(rs.getDate(8));
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

	public void addBook(Books ab) throws Exception {
		String query = "insert into books(book_id,book_name,book_version,book_author,book_language,book_type,book_publisher,book_published_date,booklink,imglink)values(BOOK_ID_SQC.nextval,lower(?),?,lower(?),?,?,?,?,?,?)";

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query);) {

			pst.setString(1, ab.getBookName());
			pst.setInt(2, ab.getBookVersion());
			pst.setString(3, ab.getBookAuthor());
			pst.setString(4, ab.getBookLanguage());
			pst.setString(5, ab.getBookType());
			pst.setString(6, ab.getBookPublisher());
			pst.setDate(7, ab.getBookPublishedDate());
			pst.setString(8, ab.getBookLink());
			pst.setString(9, ab.getImgLink());

			int rows = pst.executeUpdate();
			log.debug("No of rows inserted :" + rows);

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_ADD);

		}

	}

	public void updateBookLanguage(Books ab) throws Exception {
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

	public void deleteBook(Books ab) throws Exception {
		String sql = "delete from users where book_id=?";
		String query = "delete from books where book_id=?";

		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstm = con.prepareStatement(sql);
				PreparedStatement pst = con.prepareStatement(query)) {

			pstm.setInt(1, ab.getBookId());
			pst.setInt(1, ab.getBookId());

			int rows = pst.executeUpdate();
			pst.executeUpdate();
			log.debug("No of rows Deleted :" + rows);

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_DELETE);

		}

	}

	public List<Books> viewAllBooks() throws Exception {
		String query = "select book_name,book_version,book_author,book_language,book_rating,book_type,book_publisher,book_published_date,booklink,imglink from books ";
		List<Books> l = new ArrayList<Books>();
		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			int rows = pst.executeUpdate(query);
			log.debug("Total Books :" + rows);

			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					Books b = new Books();
					b.setBookName(rs.getString(1));
					b.setBookVersion(rs.getInt(2));
					b.setBookAuthor(rs.getString(3));
					b.setBookLanguage(rs.getString(4));
					b.setBookRating(rs.getInt(5));
					b.setBookType(rs.getString(6));
					b.setBookPublisher(rs.getString(7));
					b.setBookPublishedDate(rs.getDate(8));
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

}