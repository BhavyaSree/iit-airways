/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: UserProfileViewDao-Dtech user profile infromation from db
 * Date: 05/09/2020
 * File: UserProfileViewDao.java*/

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import models.CustomerProfileModel;

public class CustomerProfileViewDao extends DBConnect {

	// Declare DB objects
	DBConnect connection = new DBConnect();

	// method to fetch the user profile details from table
	public ArrayList<CustomerProfileModel> getCustomer(String txtUsername) {
		String Sql = "Select LNAME, FNAME, DOB, EMAIL, PHONE, ADDRESS, CITY, STATE, ZIPCODE from itr_user_details where UNAME = "
				+ "'" + txtUsername + "'";
		ArrayList<CustomerProfileModel> customer = new ArrayList<CustomerProfileModel>();
		ResultSet rs = null;

		try {
			Statement stmt = connection.getConnection().createStatement();

			rs = stmt.executeQuery(Sql);

			if (rs.next()) {
				CustomerProfileModel c1 = new CustomerProfileModel();
				// set result set to the text fields
				c1.settxtLname(rs.getString(1));
				c1.settxtFname(rs.getString(2));
				c1.settxtDob(LocalDate.parse(rs.getString(3)));
				c1.settxtEmail(rs.getString(4));
				c1.settxtPhone(rs.getLong(5));
				c1.settxtAddress(rs.getString(6));
				c1.settxtCity(rs.getString(7));
				c1.settxtState(rs.getString(8));
				c1.settxtZipcode(rs.getString(9));
				customer.add(c1);
				System.out.println("Sucessfully fetched profile data from database"); // success message if the profile
																						// data is fetched successfully
			}
			return customer;
		} catch (SQLException e) { // error if the profile data is not fetched successfully
			System.out.println("Error while fetching the user profile info: " + e.getMessage());
			return null;
		}
	}

	// Update the database with the user profile details
	public CustomerProfileModel update(String txtUsername, CustomerProfileModel customer) {
		// Query to update the customer info in database
		String query = "Update itr_user_details set LNAME=?, FNAME =?, DOB=?, EMAIL=?, PHONE=?, ADDRESS=?, CITY=?, STATE=?, ZIPCODE=? "
				+ "where UNAME = " + "'" + txtUsername + "'";

		// Use sql prepared statement for dynamic sql
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, customer.gettxtLname());
			statement.setString(2, customer.gettxtFname());
			statement.setDate(3, java.sql.Date.valueOf(customer.gettxtDob()));
			statement.setString(4, customer.gettxtEmail());
			statement.setLong(5, customer.gettxtPhone());
			statement.setString(6, customer.gettxtAddress());
			statement.setString(7, customer.gettxtCity());
			statement.setString(8, customer.gettxtState());
			statement.setString(9, customer.gettxtZipcode());

			// Execute the update
			statement.executeUpdate();

			System.out.println("Sucessfully updated profile in the database"); // success message if the profile is
																				// updated in the database successfully

		} catch (SQLException e) { // error if the profile is not updated in the database successfully
			customer = null;
			System.out.println("Error updating profile information in database: " + e.getMessage());
		}

		return customer;  //return profile details
	}

}
