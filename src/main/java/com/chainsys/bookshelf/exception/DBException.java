package com.chainsys.bookshelf.exception;

public class DBException extends Exception {

	private static final long serialVersionUID = 1L;

	public DBException(String msg) {
		super(msg);
	}
}