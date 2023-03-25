package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {

	public static Connection createSession() {
		
		Connection con = null;

		try {
		String url = "jdbc:mysql://localhost:3306/banking_application";
		String username = "root";
		String password = "Maddewfreekz@1";

		con = DriverManager.getConnection(url, username, password);
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

}
