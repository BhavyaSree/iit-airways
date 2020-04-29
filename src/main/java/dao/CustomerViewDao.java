package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import models.Customer;
//import models.ViewCustomer;

public class CustomerViewDao extends DBConnect
{
	 // Declare DB objects
	DBConnect connection = new DBConnect();
	
	// Fetch the data from table
	public ArrayList<Customer> getCustomer(String txtUsername)
	{
		String Sql = "Select LNAME, FNAME, DOB, EMAIL, PHONE, ADDRESS, CITY, STATE, ZIPCODE from ars_customers1 where UNAME = " 
				+ "'" + txtUsername +"'" ;	
		
		ArrayList<Customer> customer = new ArrayList<Customer>();
		ResultSet rs = null;
		
		try
		{
			Statement stmt = connection.getConnection().createStatement();
			
			System.out.println(Sql);
			
			rs = stmt.executeQuery(Sql);						
			
			if(rs.next())
			{						
				Customer c1 = new Customer();
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
				
				System.out.println("Sucessfully fetched customer data from database");
	
			}
			return customer;	
			
		}
		catch (SQLException e) 
		{
			System.out.println("Error while fetching the user Information: " + e.getMessage());
			return null;
		}
	}
	
	// Update the database
	public Customer update(String txtUsername, Customer customer)
	{
		// Query to update the customer info in database		
		String query = "Update ars_customers1 set LNAME=?, FNAME =?, DOB=?, EMAIL=?, PHONE=?, ADDRESS=?, CITY=?, STATE=?, ZIPCODE=? "
						+ "where UNAME = "+ "'" + txtUsername +"'" ;
		
		// Use sql prepared statement for dynamic sql
		try  
		{
			PreparedStatement statement = connection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);			
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
			
			System.out.println("Sucessfully updated customer info in the database");
			
		}
		catch (SQLException e)
		{
			customer = null;
			System.out.println("Error Updating customer Info: " + e);
		}
	
		return customer;
	}

	
}
