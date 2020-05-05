/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: AdminHistoryDao-Fetch admin Profile from database
 * Date: 05/09/2020
 * File: AdminHistoryDao.java*/

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import models.AdminProfileModel;

public class AdminProfileUpdateDao extends DBConnect {

	// Declare DB objects
	DBConnect connection = new DBConnect();

	// Method to fetch admin profile data from table
	public ArrayList<AdminProfileModel> getCustomer(String atxtUsername) { // passing user name, to get the details of
																			// the logged in user
		String Sql = "Select LNAME, FNAME, DOB, EMAIL, PHONE, ADDRESS, CITY, STATE, ZIPCODE from ars_customers1 where UNAME = "
				+ "'" + atxtUsername + "'";
		ArrayList<AdminProfileModel> admin = new ArrayList<AdminProfileModel>();
		ResultSet rs = null;

		try {
			Statement stmt = connection.getConnection().createStatement();


			rs = stmt.executeQuery(Sql);

			if (rs.next()) {
				AdminProfileModel a1 = new AdminProfileModel();
				// set result set to the text fields
				a1.setatxtLname(rs.getString(1));
				a1.setatxtFname(rs.getString(2));
				a1.setatxtDob(LocalDate.parse(rs.getString(3)));
				a1.setatxtEmail(rs.getString(4));
				a1.setatxtPhone(rs.getLong(5));
				a1.setatxtAddress(rs.getString(6));
				a1.setatxtCity(rs.getString(7));
				a1.setatxtState(rs.getString(8));
				a1.setatxtZipcode(rs.getString(9));
				admin.add(a1);
				System.out.println("Sucessfully fetched data from database"); // success message if the profile is
																				// fetched successfully
			}
			return admin;
		} catch (SQLException e) { // Error if the profile is fetched successfully
			System.out.println("Error while fetching the user Information: " + e.getMessage());
			return null;
		}
	}

	// Update the database after the profile is updated by user or admin
	public AdminProfileModel update(String txtUsername, AdminProfileModel admin) {
		// Query to update the customer info in database
		String query = "Update ars_customers1 set LNAME=?, FNAME =?, DOB=?, EMAIL=?, PHONE=?, ADDRESS=?, CITY=?, STATE=?, ZIPCODE=? "
				+ "where UNAME = " + "'" + txtUsername + "'";


		// Use sql prepared statement for dynamic sql
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, admin.getatxtLname());
			statement.setString(2, admin.getatxtFname());
			statement.setDate(3, java.sql.Date.valueOf(admin.getatxtDob()));
			statement.setString(4, admin.getatxtEmail());
			statement.setLong(5, admin.getatxtPhone());
			statement.setString(6, admin.getatxtAddress());
			statement.setString(7, admin.getatxtCity());
			statement.setString(8, admin.getatxtState());
			statement.setString(9, admin.getatxtZipcode());

			// Execute the update
			statement.executeUpdate();

			System.out.println("Sucessfully updated customer info in the database"); // success message if the profile
																						// is updated successfully in
																						// data base

		} catch (SQLException e) { // error if the profile is not updated successfully
			admin = null;
			System.out.println("Error Updating customer Info: " + e.getMessage());
		}

		return admin; // return the values
	}

}
