package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Productupdate {

	public static void main(String[] args) {
		Connection connection = null;

		try {// step 1 load register

			Class.forName("com.mysql.cj.jdbc.Driver");
			// step 2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user = "root";
			String pass = "devil15";
			connection = DriverManager.getConnection(url, user, pass);
			String UpadateQuery  = "update product set productcolor=? where productid =?";
			// step3 create statement
			PreparedStatement preparedstatement = connection.prepareStatement(UpadateQuery );
			preparedstatement.setString(1, "White");
			preparedstatement.setInt(2, 100);
			
			int a=preparedstatement.executeUpdate();
			
			if(a==1) {
				System.out.println("Data is Updated");
			}else {
				System.err.println("given id is not present");
			}
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}