package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class ProductInsertController {
	static Connection connection = null;

	public static void main(String[] args) {

		try {// step 1 load register

			Class.forName("com.mysql.jdbc.Driver");
			// step 2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user = "root";
			String pass = "devil15";
			connection = DriverManager.getConnection(url, user, pass);
			String insertQuery = "insert into product values(?,?,?,?)";
			// step3 create statement
			PreparedStatement preparedstatement = connection.prepareStatement(insertQuery);
			preparedstatement.setInt(1, 300);
			preparedstatement.setString(2, "table");
			preparedstatement.setDouble(3, 400);
			preparedstatement.setString(4, "black");
			preparedstatement.execute();
			System.out.println("DATE--Stored");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}