package dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import models.Customer;
import models.User;

public class CustomerDao extends DBConnect
{
	// Declare DB objects
	DBConnect connection = new DBConnect();

	public void CreateDetails(Customer customer)
	{
		// Query to insert new customer into database
		String sql1 = "INSERT INTO ars_customers1(UNAME, LNAME, FNAME, DOB, EMAIL, PHONE, ADDRESS, CITY, STATE, ZIPCODE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Use sql prepared statement for dynamic sql
		try  
		{
			PreparedStatement statement = connection.getConnection().prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
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
			
			System.out.println("Sucessfully added new customer");
			
		}
		catch (SQLException e) 
		{
			customer = null;
			System.out.println("Error while adding new customer: " + e);
		}
	}
	
	
	public void CreateUser(User user)
	{					
		// Query to insert new customer into database
		String sql2 = "INSERT INTO ars_users(username, password, admin) VALUES (?, ?, ?)";
			
		try  
		{
				
			PreparedStatement statement1 = connection.getConnection().prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			// Set the parameters to the query
			statement1.setString(1, user.gettxtUsername());
			statement1.setString(2, user.gettxtPassword());
			statement1.setInt(3, 0);
												
			// Execute the insert for users
			statement1.executeUpdate();
				
			System.out.println("Sucessfully added new user");
			connection.getConnection().close();
		}			
		catch (SQLException e) 		
		{
			user = null;
			System.out.println("Error while adding new user: " + e.getMessage());
			
		}		
	}
}
