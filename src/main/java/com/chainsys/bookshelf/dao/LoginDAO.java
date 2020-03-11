package com.chainsys.bookshelf.dao;

import com.chainsys.bookshelf.exception.DBException;
import com.chainsys.bookshelf.model.User;

public interface LoginDAO {
	public int saveUser(User ab) throws DBException;

	public String userLogin(String email, String password) throws DBException;

	public User getUserDetails(String email) throws DBException;
}
