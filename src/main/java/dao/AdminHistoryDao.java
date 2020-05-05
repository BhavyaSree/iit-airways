/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: AdminHistoryDao-Fetch latest History details of users from database
 * Date: 05/09/2020
 * File: AdminHistoryDao.java*/

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.HistoryModel;

public class AdminHistoryDao extends DBConnect {
	// Declare DB objects
	DBConnect connection = new DBConnect();

	//method to get the history details for admin
	public ArrayList<HistoryModel> getHistory() {

		System.out.println("Starting to fetch the Tickets History");
		ArrayList<HistoryModel> history = new ArrayList<HistoryModel>();

		ResultSet rs = null;

		String Sql = "Select LNAME, FROMDEST, TODEST, TRAVELDATE, TRAVELTIME, CLASS, BOOKINGID from ars_ticketdetails order by TRAVELDATE, TRAVELTIME ,BOOKINGID;";

		try {
			Statement stmt = connection.getConnection().createStatement();

			rs = stmt.executeQuery(Sql);

			while (rs.next()) { //get all the records based on booking id, last name  and other fields
				HistoryModel H1 = new HistoryModel();

				H1.setLNameId(rs.getString(1));
				H1.setFromId(rs.getString(2));
				H1.setToId(rs.getString(3));
				H1.setDateId(rs.getString(4));
				H1.setTimeId(rs.getString(5));
				H1.setClassId(rs.getString(6));
				H1.setBookId(rs.getString(7));

				history.add(H1);

			}

			System.out.println("Sucessfully fetched ticket history from database"); // success message of the details
																					// are fetched

		} catch (SQLException e) { // Error if the details are not fetched
			System.out.println("Error while fetching travel history: " + e.getMessage());
			history = null;

		}
		return history; //return the details
	}

}
