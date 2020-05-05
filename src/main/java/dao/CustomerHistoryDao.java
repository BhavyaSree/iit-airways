/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: UserHistory-Fetch the travel history of user
 * Date: 05/09/2020
 * File: UserHistoryDao.java*/

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.HistoryModel;

public class CustomerHistoryDao extends DBConnect {

	// Declare DB objects
	DBConnect connection = new DBConnect();

	// method to get travel history details of user
	public ArrayList<HistoryModel> getHistory(String user_name) {

		System.out.println("Starting to fetch the Tickets History");
		ArrayList<HistoryModel> history = new ArrayList<HistoryModel>();

		ResultSet rs = null;

		String Sql = "Select FROMDEST, TODEST, TRAVELDATE, TRAVELTIME, CLASS, BOOKINGID from itr_history where UNAME = "
				+ "'" + user_name + "'  ORDER BY TRAVELDATE, TRAVELTIME ";

		try {
			Statement stmt = connection.getConnection().createStatement();

			rs = stmt.executeQuery(Sql);

			while (rs.next()) {
				HistoryModel H1 = new HistoryModel();

				H1.setFromId(rs.getString(1));
				H1.setToId(rs.getString(2));
				H1.setDateId(rs.getString(3));
				H1.setTimeId(rs.getString(4));
				H1.setClassId(rs.getString(5));
				H1.setBookId(rs.getString(6));

				history.add(H1);

				System.out.println("Sucessfully fetched ticket history from database"); // success message if the ticket
																						// history is fetched
																						// successfully
			}

		} catch (SQLException e) { // error if the ticket history is not fetched successfully
			System.out.println("Error while fetching travel history: " + e.getMessage());
			history = null;

		}
		return history;  //return travel history
	}

}
