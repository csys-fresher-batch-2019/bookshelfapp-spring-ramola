package com.chainsys.bookshelf.model;

public class Logger {
	public static Logger getInstance() {
		Logger log = new Logger();
		return log;
	}

	public void debug(Object message) {
		System.out.println(message);
	}
}
