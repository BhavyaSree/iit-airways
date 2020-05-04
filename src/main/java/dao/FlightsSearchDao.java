/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: FlightSearchDao-Fetch flight details based on selection criteria from database
 * Date: 05/09/2020
 * File: FlightSearchDao.java*/

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.FlightSearchModel;

public class FlightsSearchDao extends DBConnect {

	// Declare DB objects
	DBConnect connection = new DBConnect();

	// method to get flights data from data base based on the selection criteria
	public ArrayList<FlightSearchModel> getFlights(String from_place, String to_place, String date, String in_class) {

		System.out.println("Starting to fetch the Flights details");
		ArrayList<FlightSearchModel> flights = new ArrayList<FlightSearchModel>();

		ResultSet rs = null;

		String Sql = "Select FROM_DES, TO_DES, DATE, TIME, CLASS, PRICE  from ars_flights where FROM_DES = ? AND TO_DES = ? "
				+ " AND DATE = ? AND CLASS = ? AND AVAILABLE = 'YES' ORDER BY DATE, TIME";

		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(Sql,
					Statement.RETURN_GENERATED_KEYS);
			System.out.println(Sql);
			System.out.println("Fetching Flights details");

			statement.setString(1, from_place);
			statement.setString(2, to_place);
			statement.setString(3, date);
			statement.setString(4, in_class);

			rs = statement.executeQuery();

			while (rs.next()) { // get all the flights info based on selection criteria
				FlightSearchModel F1 = new FlightSearchModel();

				F1.setFromId(rs.getString(1));
				F1.setToId(rs.getString(2));
				F1.setDateId(rs.getString(3));
				F1.setTimeId(rs.getString(4));
				F1.setClassId(rs.getString(5));
				F1.setPriceId(rs.getString(6));

				flights.add(F1);

				System.out.println("Sucessfully fetched flights data from database"); // Success message if the flight
																						// details are successfully
																						// fetched

			}
		} catch (SQLException e) { // error if the flight details are not successfully fetched
			System.out.println("Error while fetching flight details: " + e.getMessage());
			flights = null;

		}

		return flights; // return flights data

	}
}