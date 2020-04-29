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
import models.TicketDetailsModel;


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
	
	
public void display(String user_name)
{
	
	// Create a DAO instance of the model
	TicketDetailsDao TicketDetailsDao = new TicketDetailsDao();
	ArrayList<TicketDetailsModel> arrayList = TicketDetailsDao.getCustomer(user_name);
	 
	try {
	for (@SuppressWarnings("unused") TicketDetailsModel ticket : arrayList) 
	{
		System.out.println("Displaying Ticket details");
		//lblBookingId.setText(Integer.toString(Ticket.getlblBookingId()));
		//lblLname.setText(ticket.getlblLname());
		/*lblFname.setText(Ticket.getlblFname());
		lblEmail.setText(Ticket.getlblEmail());
		lblPhone.setText(Long.toString(Ticket.getlblPhone()));
		lblFrom.setText(Ticket.getlblFrom());
		lblTo.setText(Ticket.getlblTo());
		lblDate.setText(Ticket.getlblDate());
		lblTime.setText(Ticket.getlblTime());
		lblStatus.setText(Ticket.getlblStatus());
		lblClass.setText(Ticket.getlblClass());*/
	}
	}catch(Exception e) {
		System.out.println("Error in fetching ticket details: " + e.getMessage());
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
