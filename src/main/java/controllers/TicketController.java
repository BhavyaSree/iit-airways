/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: Ticket controller to enable user or admin to view ticket details they just booked
 * Date: 05/09/2020
 * File: Ticket Controller.java*/

package controllers;

import java.util.ArrayList;
import application.Main;
import dao.TicketViewDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.UserProfileModel;
import models.TicketViewModel;

public class TicketController {
	@FXML
	private Label lblBookingId;
	@FXML
	private Label lblFname;
	@FXML
	private Label lblLname;
	@FXML
	private Label lblEmail;
	@FXML
	private Label lblPhone;
	@FXML
	private Label lblFrom;
	@FXML
	private Label lblTo;
	@FXML
	private Label lblDate;
	@FXML
	private Label lblTime;
	@FXML
	private Label lblClass;
	@FXML
	private Label lblStatus;
	@FXML
	private Label lblPrice;
	@FXML
	private Pane pane1; // pane 1 which shows ticket details

	static UserProfileModel c = new UserProfileModel();
	static String user_name = c.gettxtUsername();

	// set user name
	public static void setUsername(String username) {
		user_name = username;
		System.out.println("Welcome User: " + user_name + "!");
	}

	// method to view ticket details that was recently booked by user or admin when
	// clicked on view ticket button
	public void viewTicket() {
		pane1.setVisible(true); // set pane 1 as visible
		// Create a DAO instance of the model
		TicketViewDao TicketDetailsDao = new TicketViewDao();
		ArrayList<TicketViewModel> arrayList = TicketDetailsDao.getCustomer(user_name);
		// set the values fetched from data based
		try {
			for (TicketViewModel ticket : arrayList) {
				System.out.println("Displaying Ticket details");
				lblBookingId.setText(Integer.toString(ticket.getlblBookingId()));
				lblLname.setText(ticket.getlblLname());
				lblFname.setText(ticket.getlblFname());
				lblEmail.setText(ticket.getlblEmail());
				lblPhone.setText(Long.toString(ticket.getlblPhone()));
				lblFrom.setText(ticket.getlblFrom());
				lblTo.setText(ticket.getlblTo());
				lblDate.setText(ticket.getlblDate());
				lblTime.setText(ticket.getlblTime());
				lblStatus.setText(ticket.getlblStatus());
				lblClass.setText(ticket.getlblClass());
				lblPrice.setText(ticket.getlblPrice());
			}
		} catch (Exception e) { // error when launching next screen
			System.out.println("Error in setting ticket details: " + e.getMessage());
		}
	}

	// method to log out when clicked on logout from login screen and display home
	// screen
	public void logout() {
		// Alert message to logout
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank you Message");
		alert.setHeaderText("Illinois Tech Airways");
		alert.setContentText("Thank you for choosing us! Please visit again!");
		alert.showAndWait();
		// launch home screen
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
			Scene scene = new Scene(root, 800, 600);
			Main.stage.setScene(scene);
			System.out.println("Launched Iliinois Tech Airways Home Screen");
			Main.stage.setTitle("Illinois Tech Airways Home Page");
			Main.stage.show();
		} catch (Exception e) { // error when launching home screen
			System.out.println("Error in inflating view: " + e.getMessage());
		}
	}

}
