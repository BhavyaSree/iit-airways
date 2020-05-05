/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: TicketViewDao-Fetch booked ticket details from database
 * Date: 05/09/2020
 * File: TicketViewDao.java*/

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.TicketViewModel;

public class TicketViewDao extends DBConnect {
	// Declare DB objects
	DBConnect connection = new DBConnect();

	// Fetch the booked ticket data from table
	public ArrayList<TicketViewModel> getCustomer(String txtUsername) {
		String Sql1 = "Select MAX(BOOKINGID) from ars_ticketdetails  where UNAME = " + "'" + txtUsername + "'";
		ResultSet rs1 = null;

		try {
			Statement stmt1 = connection.getConnection().createStatement();

			rs1 = stmt1.executeQuery(Sql1);
			Integer Bookid;
			if (rs1.next()) { // get the latest booking id from data base for user
				Bookid = rs1.getInt(1);
			} else {
				Bookid = 0;
			}

			String Sql = "Select LNAME,FNAME,EMAIL,PHONE,FROMDEST,TODEST,TRAVELDATE,TRAVELTIME,CLASS,PRICE,STATUS,BOOKINGID from ars_ticketdetails  where BOOKINGID = "
					+ "'" + Bookid + "'";
			ArrayList<TicketViewModel> ticket = new ArrayList<TicketViewModel>();
			ResultSet rs = null;

			try {
				Statement stmt = connection.getConnection().createStatement();


				rs = stmt.executeQuery(Sql);
				if (rs.next()) {
					TicketViewModel t1 = new TicketViewModel();
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
					System.out.println("Sucessfully fetched ticket details from database"); // success message to get
																							// booked ticket details
				}
				return ticket; //return ticket details
			} catch (SQLException e) { // error if booked ticket details are fetched
				System.out.println("Error while fetching the booked ticket Information: " + e.getMessage());
				return null;
			}
		} catch (SQLException e) { // error if the latest booking id is fetched
			System.out.println("Error while fetching latest booking Id: " + e.getMessage());
			return null;
		}

	}

}
