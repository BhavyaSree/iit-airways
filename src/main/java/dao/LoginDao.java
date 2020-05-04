/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: LoginDao-Validate login credentials
 * Date: 05/09/2020
 * File: LoginDao.java*/

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends DBConnect {

	private Boolean admin;

	public Boolean isAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	// method to validate login credentials entered
	public Boolean getCredentials(String username, String password) {

		String query = "SELECT * FROM ars_users WHERE username = ? and password = ?;";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			//System.out.println(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				setAdmin(rs.getBoolean("admin"));  //set admin/user
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error while validating credentials: " + e.getMessage());
		}
		return false;
	}

}
