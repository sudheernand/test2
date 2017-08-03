package com.indus.training.persist.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.indus.training.persist.entity.EmployeeDetails;
import com.indus.training.persist.exception.EmployeeDAOException;

public class EmployeeDAO {
	public String select(int id) throws EmployeeDAOException{
		

		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		String details = null;
		try {
	       
			Class.forName("org.postgresql.Driver");
			dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "postgres",
					"27406298");
			stmt = dbConnection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = " + id + ";");

			while (rs.next()) {
//				System.out.println("FIST_NAME:" + rs.getString("FIRST_NAME"));
				details=rs.getString("FIRST_NAME");
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

		return details;

	}

	public void create(EmployeeDetails empDetailsObj) throws EmployeeDAOException {

		Connection dbConnection = null;
		Statement stmt = null;
		String fName = empDetailsObj.getFirstName();
		int idVal = empDetailsObj.getEmployee_id();

		try {

			dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "postgres", "27406298");
			stmt = dbConnection.createStatement();
			// stmt.execute("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = " +
			// id);
			stmt.execute("INSERT INTO EMPLOYEES VALUES ('" + idVal + "','" + fName + "','" + empDetailsObj.getLastName()
					+ "','" + empDetailsObj.getEmail() + "','" + empDetailsObj.getPhoneNumber() + "','"
					+ empDetailsObj.getHireDate() + "','" + empDetailsObj.getJobID() + "','" + empDetailsObj.getSalary()
					+ "','" + empDetailsObj.getCommission_pct() + "','" + empDetailsObj.getManagerId() + "','"
					+ empDetailsObj.getDepartmentId() + "');");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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
	public void update(EmployeeDetails empDetailsObj) {

		Connection dbConnection = null;
		Statement stmt = null;
		String fName = empDetailsObj.getFirstName();
		int idVal = empDetailsObj.getEmployee_id();

		try {

			dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "postgres", "27406298");
			stmt = dbConnection.createStatement();
			// stmt.execute("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = " +
			// id);
			stmt.execute
			("UPDATE  employees SET  first_name ='" + fName +"',last_name='" +empDetailsObj.getLastName()+"' WHERE employee_id ="+empDetailsObj.getEmployee_id()+";");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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
