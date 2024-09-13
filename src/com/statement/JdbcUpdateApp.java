package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdateApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String username = "root";
		String password = "root";
		String query = "UPDATE register SET contact = '9979879' WHERE name = 'Paras'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully....!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Succesfully.....!");
			Statement stmt = con.createStatement();
			int rowsAffected = stmt.executeUpdate(query);
			if (rowsAffected > 0) {
				System.out.println("Updated Succesfully...! " + rowsAffected + " rows affected.");
			} else {
				System.out.println("Updation failed...!");
			}

			stmt.close();
			con.close();
			System.out.println();
			System.out.println("Connection Closed Succesfully....!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
