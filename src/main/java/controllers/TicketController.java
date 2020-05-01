package controllers;

import java.util.ArrayList;

import application.Main;
import dao.TicketDetailsDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Customer;
import models.TicketDetailsModel;
import models.User;


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
	private Pane pane1;
	
	static Customer c = new Customer();
	static String user_name = c.gettxtUsername();
	
	public static void setUsername(String username) {
		user_name = username;
		System.out.println("Welcome User: " + user_name + "!");
	}

public void viewTicket()
{
	  //TicketDetailsModel cust = new TicketDetailsModel();
	 // String user_name = cust.gettxtUsername();

      System.out.println(user_name);
	  pane1.setVisible(true);
	  //String user_name = "admin";
	  // Create a DAO instance of the model
	  TicketDetailsDao TicketDetailsDao = new TicketDetailsDao();
	  ArrayList<TicketDetailsModel> arrayList = TicketDetailsDao.getCustomer(user_name);
	 
	try {
	for (TicketDetailsModel ticket : arrayList) 
	{
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
	}catch(Exception e) {
		System.out.println("Error in setting ticket details: " + e.getMessage());
	}
}


	public void logout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank you Message");
		alert.setHeaderText("Illinois Tech Airways");
		alert.setContentText("Thank you for choosing us! Please visit again!");
		alert.showAndWait();
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
			Scene scene = new Scene(root, 800, 600);
			Main.stage.setScene(scene);
			System.out.println("Launched Home Screen");
			Main.stage.setTitle("Illinois Tech Airways Home Page");
			Main.stage.show();
		} catch (Exception e) {
			System.out.println("Error in inflating view: " + e.getMessage());
		}
	}

}
