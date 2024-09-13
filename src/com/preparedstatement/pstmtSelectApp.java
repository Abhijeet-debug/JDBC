package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pstmtSelectApp {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Succesfully....!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Succesfull.....!");

			PreparedStatement pstmt = conn.prepareStatement("SELECT *FROM register");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}

			pstmt.close();
			conn.close();
			System.out.println();
			System.out.println("Connection closed succesfully...!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
