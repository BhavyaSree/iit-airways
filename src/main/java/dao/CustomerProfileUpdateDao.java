/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: UserProfileUpdateDao-Create new user/admin or update profile
 * Date: 05/09/2020
 * File: UserProfileUpdateDao.java*/

package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import models.CustomerProfileModel;
import models.LoginModel;

public class CustomerProfileUpdateDao extends DBConnect {
	// Declare DB objects
	DBConnect connection = new DBConnect();

	// method to create user/admin by user
	public void CreateDetails(CustomerProfileModel customer) {
		// Query to insert new customer into database
		String sql1 = "INSERT INTO ars_customers1(UNAME, LNAME, FNAME, DOB, EMAIL, PHONE, ADDRESS, CITY, STATE, ZIPCODE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// Use sql prepared statement for dynamic sql
		try {
			PreparedStatement statement = connection.getConnection().prepareStatement(sql1,
					Statement.RETURN_GENERATED_KEYS);

			// Set the parameters to the query
			statement.setString(1, customer.gettxtUsername());
			statement.setString(2, customer.gettxtLname());
			statement.setString(3, customer.gettxtFname());
			statement.setDate(4, java.sql.Date.valueOf(customer.gettxtDob()));
			statement.setString(5, customer.gettxtEmail());
			statement.setLong(6, customer.gettxtPhone());
			statement.setString(7, customer.gettxtAddress());
			statement.setString(8, customer.gettxtCity());
			statement.setString(9, customer.gettxtState());
			statement.setString(10, customer.gettxtZipcode());

			// Execute the insert
			statement.executeUpdate();

			System.out.println("Sucessfully added new customer"); // success message after creating customer in db

		} catch (SQLException e) { // error if the customer is not created successfully
			customer = null;
			System.out.println("Error while adding new customer: " + e.getMessage());
		}
	}

	// method to create login details in db
	public void CreateUser(LoginModel user) {
		String sql2 = "INSERT INTO ars_users(username, password, admin) VALUES (?, ?, ?)";

		try {
			PreparedStatement statement1 = connection.getConnection().prepareStatement(sql2,
					Statement.RETURN_GENERATED_KEYS);

			// Set the parameters to the query
			statement1.setString(1, user.gettxtUsername());
			statement1.setString(2, user.gettxtPassword());
			System.out.println(user.getUserType());
			int usertype;
			if (user.getUserType() == "Admin") { // get usertype admin/user
				usertype = 1;
			} else {
				usertype = 0;
			}
			statement1.setInt(3, usertype);
			// Execute the insert for users
			statement1.executeUpdate();

			System.out.println("Sucessfully added new user credential details"); // success message if the user
																					// credentials are created
			connection.getConnection().close();
		} catch (SQLException e) { // error if the user credentials are not created
			user = null;
			System.out.println("Error while adding new user credential details: " + e.getMessage());
		}
	}

}
