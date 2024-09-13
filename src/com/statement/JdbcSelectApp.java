package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectApp {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String username = "root";
		String password = "root";
		String query = "SELECT * FROM register";

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
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString(1);
				String email = rs.getString(2);
				String contact = rs.getString(3);

				System.out.println(name + " \t " + email + " \t " + contact);

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
