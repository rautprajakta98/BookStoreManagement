package com.onlinebookstore.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener("/MyServletContext")
public class MyServletContext implements ServletContextListener{

	public static Connection dbConnection;
	
	private Connection getDbConnection() {
		if (dbConnection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookstore", "root", "praja#123");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}
		return dbConnection;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		dbConnection  = this.getDbConnection();
		ServletContext context = sce.getServletContext();
		context.setAttribute("getDbConnection", dbConnection);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
