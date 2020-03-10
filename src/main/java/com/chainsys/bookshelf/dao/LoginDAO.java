package com.chainsys.bookshelf.dao;

import com.chainsys.bookshelf.model.Login;

public interface LoginDAO {
	public int newLogin(Login ab) throws Exception;

	public String userLoginValidation(String eMail, String password) throws Exception;

	public Login getUserDetails(String email) throws Exception;
}
