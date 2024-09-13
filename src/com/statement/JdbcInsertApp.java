package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcInsertApp {

	public static void main(String[] args) throws SQLException {

		// First load the driver
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		// Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded succesfully.......");

		// make the connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb", "root", "root");
		if (conn != null) {
			System.out.println("Connected....");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter name , gmail and Contact..");
			String name = sc.nextLine();
			String gmail = sc.nextLine();
			String contact = sc.nextLine();

			Statement stmt = conn.createStatement();
//			int val = stmt.executeUpdate("insert into register values ('Abhijeet', 'Abhi@gmail.com', '12345')");
			int val = stmt
					.executeUpdate("insert into register values ('" + name + "', '" + gmail + "', '" + contact + "')");
			if (val > 0) {
				System.out.println("record saved succesfully....");
			} else {
				System.out.println("some issues is there..");
			}
			sc.close();
		} else {
			System.out.println("Not Connected.....");
		}

	}

}
