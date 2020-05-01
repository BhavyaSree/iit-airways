package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.TicketDetailsModel;


public class TicketDetailsDao extends DBConnect{
	// Declare DB objects
			DBConnect connection = new DBConnect();
			
			// Fetch the data from table
			public ArrayList<TicketDetailsModel> getCustomer(String txtUsername)
			{
				String Sql1 = "Select MAX(BOOKINGID) from ars_ticketdetails  where UNAME = " 
												+ "'" + txtUsername +"'" ;	
				ResultSet rs1 =null;
                
				try
				{
					Statement stmt1 = connection.getConnection().createStatement();
					
					rs1 = stmt1.executeQuery(Sql1);
					Integer Bookid;
					if(rs1.next()){Bookid = rs1.getInt(1);}
					else{ Bookid = 0;}
					
				String Sql = "Select LNAME,FNAME,EMAIL,PHONE,FROMDEST,TODEST,TRAVELDATE,TRAVELTIME,CLASS,PRICE,STATUS,BOOKINGID from ars_ticketdetails  where BOOKINGID = " 
						+ "'" + Bookid +"'" ;	
				ArrayList<TicketDetailsModel> ticket = new ArrayList<TicketDetailsModel>();
				ResultSet rs = null;
				
				try
				{
					Statement stmt = connection.getConnection().createStatement();
					
					System.out.println(Sql);
					
					rs = stmt.executeQuery(Sql);						
					if(rs.next())
					{						
						TicketDetailsModel t1 = new TicketDetailsModel();
						// set result set to the text fields
						t1.setlblLname(rs.getString(1));
						t1.setlblFname(rs.getString(2));
						t1.setlblEmail(rs.getString(3));
						t1.setlblPhone(rs.getLong(4));
						t1.setlblFrom(rs.getString(5));
						t1.setlblTo(rs.getString(6));
						t1.setlblDate(rs.getString(7));
						t1.setlblTime(rs.getString(8));
						t1.setlblClass(rs.getString(9));
						t1.setlblPrice(rs.getString(10));
						t1.setlblStatus(rs.getString(11));
						t1.setlblBookingId(rs.getInt(12));
						ticket.add(t1);
						System.out.println("Sucessfully fetched ticket details from database");
					}
					return ticket;		
				}
				catch (SQLException e) 
				{
					System.out.println("Error while fetching the user Information: " + e.getMessage());
					return null;
				}
				}catch (SQLException e) 
				{
					System.out.println("Error while fetching latest booking Id: " + e.getMessage());
					return null;
				}
			   
			}
			
	

}
