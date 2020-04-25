package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import models.Customer;
import models.User;

public class CustomerDao extends DBConnect
{
	// Declare DB objects
	DBConnect connection = new DBConnect();;

	public void CreateDetails(Customer customer)
	{
		// Query to insert new customer into database
		String sql1 = "INSERT INTO ars_customers1(LNAME, FNAME, DOB, EMAIL, PHONE, ADDRESS, CITY, STATE, ZIPCODE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Use sql prepared statement for dynamic sql
		try  
		{
			PreparedStatement statement = connection.getConnection().prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			// Set the parameters to the query
			statement.setString(1, customer.getTxtLname());
			statement.setString(2, customer.getTxtFname());
			statement.setDate(3, java.sql.Date.valueOf(customer.getDob()));
			statement.setString(4, customer.getTxtEmail());
			statement.setLong(5, customer.getTxtPhone());
			statement.setString(6, customer.getTxtAddress());
			statement.setString(7, customer.getTxtCity());
			statement.setString(8, customer.getTxtState());
			statement.setString(9, customer.getTxtZipcode());
			
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
		ResultSet rs = null;
		
		try
		{
			Statement statement = connection.getConnection().createStatement();
							
			String Sql2 = "Select max(Id) from ars_customers1";
			rs = statement.executeQuery(Sql2);
				
			// Query to insert new customer into database
			String sql3 = "INSERT INTO ars_users(username, password, admin, CustomerId) VALUES (?, ?, ?, ?)";
			
			try  
			{
				PreparedStatement statement1 = connection.getConnection().prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
				// Set the parameters to the query
				statement1.setString(1, user.getTxtUname());
				statement1.setString(2, user.getTxtPassword());
				statement1.setInt(3, 0);
				if(rs.next())
				statement1.setInt(4, rs.getInt(1));
												
				// Execute the insert for users
				statement1.executeUpdate();
				
				System.out.println("Sucessfully added new user");
				connection.getConnection().close();
			}
			catch (SQLException e) 
			{
				user = null;
				System.out.println("Error while adding new user: " + e);
			}
		}
		
		catch (SQLException e)
		{
				System.out.println("Error in fectching the customer Id" + e);
		}
		
	}
}
