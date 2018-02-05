package com.lin.utils;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBconn {

	public static Connection conn;
	private static String user = "root";
	private static String url = "jdbc:mysql:///messageBoard";
	private static String password = "admin";

	// get connnection
	public static Connection getConn() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void CloseConn() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
