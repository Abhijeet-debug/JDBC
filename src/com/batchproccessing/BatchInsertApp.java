package com.batchproccessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchInsertApp {

	public static void main(String[] args) {

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
			System.out.println("Connection Successful....!");
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.addBatch("insert into register values ('Diksha', 'diksha@gmail.com','465327')");
			stmt.addBatch("insert into register values ('Preeti', 'preeti@gmail.com','787345327')");
			stmt.addBatch("insert into register values ('Shalu', 'shalu@gmail.com','76757327')");
			int[] executeBatch = stmt.executeBatch();
			conn.commit();
			System.out.println("Batch executed succesfully....!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
