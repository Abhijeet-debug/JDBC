package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDeleteApp {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String username = "root";
		String password = "root";
		String query = "DELETE FROM register WHERE name = 'Abhijeet'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Succesfully....!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Succesfully...!");

			Statement stmt = con.createStatement();
			int rowsAffected = stmt.executeUpdate(query);
			if (rowsAffected > 0) {
				System.out.println("Deletion Succesfull...! " + rowsAffected + "rows affected.");
			} else {
				System.out.println("Deletion Failed...!");
			}
			stmt.close();
			con.close();
			System.out.println();
			System.out.println("Connection closed Succesfully....");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
