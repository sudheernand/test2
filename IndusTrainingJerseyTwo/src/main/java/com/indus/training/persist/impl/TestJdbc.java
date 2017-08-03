package com.indus.training.persist.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

	public static void main(String[] args) {

		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"27406298");
			stmt = dbConnection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = " + 100);

			while (rs.next()) {
				System.out.println("FIST_NAME:" + rs.getString("FIRST_NAME"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {

				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {

				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {

				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
