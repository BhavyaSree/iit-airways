package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import models.FlightsModel;

public class FlightsDao extends DBConnect
{
	
	// Declare DB objects
	DBConnect connection = new DBConnect();
	
	public ArrayList<FlightsModel> getFlights(String from_place, String to_place, LocalDate date, String in_class)
	{
		
		System.out.println("Starting to fetch the Flights details");
		ArrayList<FlightsModel> flights = new ArrayList<FlightsModel>();
		
		ResultSet rs = null;
		
		
		String Sql = "Select FROM_DES, TO_DES, DATE, TIME, CLASS, PRICE  from ars_flights where FROM_DES = ? AND TO_DES = ? "
				    + "AND DATE= ? AND CLASS = ? AND AVAILABLE = 'YES' ORDER BY DATE, TIME" ;
				
		try
		{
			PreparedStatement statement = connection.getConnection().prepareStatement(Sql,Statement.RETURN_GENERATED_KEYS);
			
			System.out.println("Entered in to DB to fetch the Flights details");
			
			statement.setString(1, from_place);
			statement.setString(2, to_place);
			statement.setDate(3, java.sql.Date.valueOf(date));
			statement.setString(4, in_class);
					
			rs = statement.executeQuery();
			
			while(rs.next())
			{			
				System.out.println("Started to fetch the flight details");
				FlightsModel F1 = new FlightsModel();

				F1.setFromId(rs.getString(1));
				F1.setToId(rs.getString(2));
				F1.setDateId(rs.getString(3));
				F1.setTimeId(rs.getString(4));
				F1.setClassId(rs.getString(5));
				F1.setPriceId(rs.getString(6));
				

				flights.add(F1);
				
				System.out.println("Sucessfully fetched flights data from database");
				//return flights;
	
			}

			
		}
		catch (SQLException e)
		{
			System.out.println("Error while fetching flight details: " + e.getMessage());
			flights = null;
			
		}
		
		return flights;

		
	}
}
