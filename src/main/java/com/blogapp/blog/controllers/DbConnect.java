package com.blogapp.blog.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnect {
	
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","hello123");
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
