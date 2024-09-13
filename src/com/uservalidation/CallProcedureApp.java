package com.uservalidation;

import java.sql.*;

//import com.mysql.cj.jdbc.CallableStatement;

public class CallProcedureApp {

	public static void main(String[] args) {

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

			CallableStatement cstmt = conn.prepareCall("{call saverecord(?,?,?)}");
			cstmt.setString(1, "shyam");
			cstmt.setString(2, "shyam@gmail.com");
			cstmt.setString(3, "986454");

			boolean b = cstmt.execute();
			if (!b) {
				System.out.println("Procedure executed succesfully....!");
			} else {
				System.out.println("Procedure Not executed...!");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
