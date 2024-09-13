package com.preparedstatement;

import java.sql.*;
import java.util.Scanner;

public class pstmtDeleteApp {

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

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter name: ");
			String name = sc.nextLine();

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM register WHERE name = ?");
			pstmt.setString(1, name);

			int val = pstmt.executeUpdate();
			if (val > 0) {
				System.out.println("Deleted Succesfully.....!");
			} else {
				System.out.println("Deletion failed....!");
			}
			pstmt.close();
			conn.close();
			sc.close();
			System.out.println();
			System.out.println("Connection closed succesfully...!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
