/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: Establish connection to database
 * Date: 05/09/2020
 * File: DBConnect.java*/

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	protected Connection connection;

	public Connection getConnection() {
		return connection;
	}


	private static String url = "jdbc:mysql://www.papademas.net:3307/510fp?autoReconnect=true&useSSL=false";
	private static String username = "fp510";
	private static String password = "510";

	// method to establish connection
	public DBConnect() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) { // error if there is any issue in establishing connection
			System.out.println("Error creating connection to database: " + e.getMessage());
			System.exit(-1);
		}
	}
}
