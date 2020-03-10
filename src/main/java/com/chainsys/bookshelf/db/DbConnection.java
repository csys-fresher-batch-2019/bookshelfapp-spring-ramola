package com.chainsys.bookshelf.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getConnection() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");

		// Connection
		// connection=DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE","ramola","ramola");

		// System.out.println(connection);
		return connection;
	}
}
