package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class pstmtInsertApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Succesfully......");

		Connection conn = DriverManager.getConnection(url, username, password);
		if (conn != null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter name, email, contact");
			String name = sc.nextLine();
			String email = sc.nextLine();
			String contact = sc.nextLine();

			PreparedStatement pstmt = conn.prepareStatement("insert into register values (?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, contact);

			int val = pstmt.executeUpdate();
			if (val > 0) {
				System.out.println("Saved Succefully...!");

			} else {
				System.out.println("There is some issue...");
			}
			pstmt.close();
			sc.close();
			System.out.println();
			System.out.println("Connection closed succesfully...!");

		} else {
			System.out.println("Not Connected....!");
		}

		conn.close();

	}

}
