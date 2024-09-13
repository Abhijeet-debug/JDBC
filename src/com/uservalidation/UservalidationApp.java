package com.uservalidation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UservalidationApp {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String usernamedb = "root";
		String passworddb = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drriver Loaded Succesfully....!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection conn = DriverManager.getConnection(url, usernamedb, passworddb);
			System.out.println("Connection Succesfull.....!");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter username and password ");
			String username = sc.nextLine();
			String password = sc.nextLine();

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("Valid user..!");
			} else {
				System.out.println("Invalid username and password");
			}
			pstmt.close();
			conn.close();
			sc.close();
			System.out.println();
			System.out.println("Connection closed Succesfully...!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
