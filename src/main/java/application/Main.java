
/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Date: 05/09/2020
 * File: Main.java*/

package application;

import java.sql.Timestamp;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	public static Stage stage; // Set global stage object

	@Override
	public void start(Stage primaryStage) {      
		try {
			Date date = new Date();   // Get current date              
			Timestamp timeStamp=new Timestamp(date.getTime());    //To get time stamp and displaying programmer name
			System.out.println("FINAL PROJECT-AIRLINE RESERVATION SYSTEM\n");
			System.out.println("Current Date & Time is " + timeStamp + "\nProgrammed by BhavyaSree Bindela and Sneha Rajulapally.\n");	
			stage = primaryStage;                //Set primary stage
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/views/HomeView.fxml"));  //Launch Home screen
			AnchorPane root = (AnchorPane) loader.load(); //Load Anchor pane
			Scene scene = new Scene(root, 800, 600);  //Create Scene builder with dimensions of height:800 and width:600
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //add CSS application
			primaryStage.setTitle("Illinois Tech Airways Home Page"); //Set page title
			System.out.println("Launched Illinois Tech Airways Home Screen");
			primaryStage.setScene(scene);     //Set scene
			primaryStage.show();              //Show the page
		} catch (Exception e) {
			System.out.println("Error in inflating view: " + e.getMessage());    //Error in launching application
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);  //Launch screen
	}
}
