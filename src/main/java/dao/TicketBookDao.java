/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: TicketDao-Update booking details in database
 * Date: 05/09/2020
 * File: TicketDao.java*/

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.TicketBookModel;

public class TicketBookDao extends DBConnect {
	// Declare DB objects
	DBConnect connection = new DBConnect();

	// method to get booked details from data base and displaying
	public ArrayList<TicketBookModel> getCustomer(String user_name) {
		// Query to select customer details
		String sql = "SELECT LNAME, FNAME, EMAIL, PHONE FROM ARS_CUSTOMERS1 WHERE UNAME = " + "'" + user_name + "'";

		ArrayList<TicketBookModel> TBook = new ArrayList<TicketBookModel>();
		ResultSet rs = null;

		try {
			Statement stmt = connection.getConnection().createStatement();

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				TicketBookModel B1 = new TicketBookModel();
				// set result set to the text fields
				B1.setFirst_name(rs.getString(1));
				B1.setLast_name(rs.getString(2));
				B1.setEmail(rs.getString(3));
				B1.setPhone(rs.getString(4));

				TBook.add(B1);
				System.out.println("Sucessfully fetched booked ticket data from database"); // success message if the
																							// booked ticket data is
																							// fetched successfully
			}
			return TBook;
		} catch (SQLException e) { // error if the booked ticket data is not fetched successfully
			System.out.println("Error while fetching the booked detail information: " + e.getMessage());
			return null;
		}

	}

	// method to insert the new booked ticket details into database
	public void BookTicket(String user_name, String last_name, String first_name, String email, long phone, String from,
			String to, String date, String time, String class1, String price) {
		// Query to insert new customer into database
		String sql1 = "INSERT INTO ars_ticketdetails(UNAME, LNAME, FNAME, EMAIL, PHONE, FROMDEST, TODEST, TRAVELDATE, TRAVELTIME,"
				+ "CLASS, PRICE, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			// Use sql prepared statement for dynamic sql
			PreparedStatement statement = connection.getConnection().prepareStatement(sql1,
					Statement.RETURN_GENERATED_KEYS);
			// Set the parameters to the query
			statement.setString(1, user_name);
			statement.setString(2, last_name);
			statement.setString(3, first_name);
			statement.setString(4, email);
			statement.setString(5, Long.toString(phone));
			statement.setString(6, from);
			statement.setString(7, to);
			statement.setString(8, date);
			statement.setString(9, time);
			statement.setString(10, class1);
			statement.setString(11, price);
			statement.setString(12, "Confirmed");

			// Execute the insert
			statement.executeUpdate();

			System.out.println("Sucessfully Booked a ticket"); // success message after booked details are inserted
																// successfully in db

		} catch (SQLException e) { // Error if after booked details are not inserted successfully in db

			System.out.println("Error while booking a ticket: " + e.getMessage());
		}
	}

	// method to delete ticket history by admin
	public void deleteTicket(String last_name, String from, String to, String date, String time, String class1,
			String bookId) {
		// Query to insert new customer into database
		String sql2 = "DELETE FROM ARS_TICKETDETAILS WHERE LNAME = ? AND FROMDEST= ? AND TODEST = ? AND TRAVELDATE = ? AND +"
				+ "TRAVELTIME = ? AND CLASS = ?  AND BOOKINGID = ?;";

		try {
			// Use sql prepared statement for dynamic sql
			PreparedStatement statement = connection.getConnection().prepareStatement(sql2,
					Statement.RETURN_GENERATED_KEYS);
			// Set the parameters to the query
			statement.setString(1, last_name);
			statement.setString(2, from);
			statement.setString(3, to);
			statement.setString(4, date);
			statement.setString(5, time);
			statement.setString(6, class1);
			statement.setString(7, bookId);

			// Execute the delete
			statement.executeUpdate();

			System.out.println("Deleted the ticket"); // success message if the ticket record is successfully deleted
														// form database

		} catch (SQLException e) { // error if the ticket record is not successfully deleted form database

			System.out.println("Error while deleting a ticket: " + e.getMessage());
		}
	}

}
