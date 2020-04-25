package controllers;

import java.util.Optional;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;



public class AdminController {
	
	@FXML
	private Pane pane1;
	@FXML
	private Pane pane2;
	@FXML
	private Pane pane3;
	@FXML
	private Pane pane4;

	static String user_name;

	public void logout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank you Message");
		alert.setHeaderText("Illinois Tech Airways");
		alert.setContentText("Thank you for choosing us! Please visit again!");
		alert.showAndWait();
		 try {
			 AnchorPane root = (AnchorPane) 
					   FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
			 Scene scene = new Scene(root,800,600);
		   Main.stage.setScene(scene);
		   Main.stage.setTitle("Illinois Tech Airways Home Page");
		System.out.println("Launched Illinois Tech Airways Home Screen");
		   Main.stage.show();
		  } catch (Exception e) {
		  System.out.println("Error in inflating view: " + e.getMessage());
		  }
	}

	public static void setUsername(String username) {
		user_name = username;
		System.out.println("Welcome Admin: " + user_name+"!");
	}

	public AdminController() {
	
	}
	public void bookticket() {
		pane4.setVisible(true);
		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(false);
	}
	
	public void addadminuser() {
		pane4.setVisible(false);
		pane3.setVisible(false);
		pane2.setVisible(true);
		pane1.setVisible(false);
	}
	
	public void viewprofile() {
		pane4.setVisible(false);
		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(true);
	}
	
	public void viewhistory() {
		pane4.setVisible(false);
		pane3.setVisible(true);
		pane2.setVisible(false);
		pane1.setVisible(false);
	}
	
	public void book() {
		TextInputDialog dialog = new TextInputDialog("Enter payment details");
		dialog.setTitle("Payment Details");
		dialog.setHeaderText("Debit/Credit Card");
		dialog.setContentText("Please enter your card number");
		Optional<String> cardno = dialog.showAndWait();
		if (cardno.isPresent()) {
			String cardnumber = cardno.get();
			System.out.println("Card number entered: "+ cardnumber);
			}
		try {
			 AnchorPane root = (AnchorPane) 
					   FXMLLoader.load(getClass().getResource("/views/TicketView.fxml"));
				System.out.println("Launched TicketDeatils Screen");
			 Scene scene = new Scene(root,800,600);
		   Main.stage.setScene(scene);
		   Main.stage.setTitle("Ticket Details");
		   Main.stage.show();
	} catch (Exception e) {
		System.out.println("Error in inflating view: " + e.getMessage());
	}
	}
		
	public void create() {}
	public void update() {}
	public void search() {}
	
}