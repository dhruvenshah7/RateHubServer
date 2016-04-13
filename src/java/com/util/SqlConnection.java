package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/ratehub";
	private static String userName = "root";
	private static String password = "root";

	public static Connection getConnection() {

		Connection conn = null;

		try {

			Class.forName(driverName);

			conn = DriverManager.getConnection(url, userName, password);

			if (conn != null) {

				System.out.println("Connected");

			} else {

				System.out.println("Not Connected");

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {

		SqlConnection.getConnection();

	}

}
