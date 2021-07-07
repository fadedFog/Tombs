package ru.fadedfog.tombs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CallerQueriesDB {
	private static final String URL = "jdbc:mysql://localhost:3306/tombs";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private Connection connection;
	private Statement statement;
	
	public CallerQueriesDB() {
		initConnectionDB();
		checkTables();
	}
	
	private void initConnectionDB() {
		try {
			connectDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	private void connectDB() throws SQLException {
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		statement = connection.createStatement();
	}
	
	private void checkTables() {
		try {
			checkTableSteps();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	private void checkTableSteps() throws SQLException {
		ResultSet resultSet = statement.executeQuery(ListQueries.COUNT_ALL_STEPS);
		resultSet.next();
		int count = resultSet.getInt(1);
		if (count == 0) {
			statement.executeUpdate(ListQueries.INIT_LINE_STEPS);
		}
	}

	public void saveNumberSteps(int numberSteps) {
		try {
			statement.executeUpdate(String.format(ListQueries.UPDATE_LINE_STEPS, numberSteps));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
