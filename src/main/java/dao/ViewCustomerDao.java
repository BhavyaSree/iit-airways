package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import models.Customer;
//import models.ViewCustomer;

public class ViewCustomerDao extends DBConnect
{
	 // Declare DB objects
	DBConnect connection = new DBConnect();
	
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
			}
			return customer;
			
		}
		catch (SQLException e) 
		{
			System.out.println("Error while fetching the user Information: " + e.getMessage());
			return null;
		}
	}
}
