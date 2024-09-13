package com.uservalidation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultsetMetaDtataApp {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Succesfully...!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Succesfull...!");

			PreparedStatement pstmt = con.prepareStatement("select *from register");
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int ncolumn = rsmd.getColumnCount();
			System.out.println("Number of column in table : " + ncolumn);

			for (int i = 1; i <= ncolumn; i++) {
				System.out.println(
						rsmd.getColumnName(i) + "\t" + rsmd.getColumnTypeName(i) + "\t" + rsmd.getColumnDisplaySize(i));
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
