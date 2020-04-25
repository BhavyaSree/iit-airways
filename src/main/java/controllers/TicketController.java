package controllers;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class TicketController {
	
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
			System.out.println("Launched Home Screen");
		   Main.stage.setTitle("Illinois Tech Airways Home Page");
		   Main.stage.show();
		  } catch (Exception e) {
		  System.out.println("Error in inflating view: " + e.getMessage());
		  }
	}

}
