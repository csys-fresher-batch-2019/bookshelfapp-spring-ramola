package com.chainsys.bookshelf.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.LoggerFactory;

import com.chainsys.bookshelf.controller.IndexController;
import com.chainsys.bookshelf.dao.LoginDAO;
import com.chainsys.bookshelf.util.DbConnection;
import com.chainsys.bookshelf.exception.DBException;
import com.chainsys.bookshelf.exception.ErrorConstant;
import com.chainsys.bookshelf.model.User;

public class LoginDAOImpl implements LoginDAO {

	// private static final Logger log=Logger.getInstance();
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(IndexController.class);

	public int saveUser(User ab) throws DBException {
		int rows = 0;
		String query = "insert into login(login_no,user_name,email,phone_no,preference_type,password)values (login_sqc.nextval,?,?,?,?,?)";

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
			pst.setString(1, ab.getUserName());
			pst.setString(2, ab.geteMail());
			pst.setLong(3, ab.getPhoneNo());
			pst.setString(4, ab.getPreferenceType());
			pst.setString(5, ab.getPassword());

			rows = pst.executeUpdate();
			log.debug("No of rows inserted :" + rows);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_ADD);
		}
		return rows;
	}

	public String userLogin(String email, String password) throws DBException {
		String query = "select email,password from login where email=? and password=?";
		String s = null;

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query);)

		{

			pst.setString(1, email);
			pst.setString(2, password);
			System.out.println(email);
			System.out.println(password);
			if (email.equals("admin@gmail.com") && password.equals("admin")) {
				s = "admin";
			} else {
				try (ResultSet rs = pst.executeQuery();) {
					if (rs.next()) {
						s = "success";
					}

					else {
						s = "failure";
					}
				} catch (Exception e) {

				}
				con.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}

		System.out.println(s);

		return (s);
	}

	@Override
	public User getUserDetails(String email) throws DBException {
		String query = "select * from login where email=? ";
		User l = new User();

		try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query);)

		{

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					l.setLoginNo(rs.getInt(1));
					l.setUserName(rs.getString(2));
					l.seteMail(rs.getString(3));
					l.setPhoneNo(rs.getLong(4));
					l.setPreferenceType(rs.getString(5));
					l.setPassword(rs.getString(6));
				}

			}

			catch (Exception e) {

			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(ErrorConstant.INVALID_SELECT);

		}

		return (l);
	}
}
