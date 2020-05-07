/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: Home controller to enable user to login and signup
 * Date: 05/09/2020
 * File: Home Controller.java*/

package controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {

	// method to launch login screen when user clicks on login button
	public void login() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
		setSceneMethod(Main.stage, loader);
		Main.stage.setTitle("Login");
		System.out.println("Launched Login Screen");
	}

	// method to launch login screen when user clicks on signup button
	public void signup() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/SignUpView.fxml"));
		setSceneMethod(Main.stage, loader);
		Main.stage.setTitle("SignUp");
		System.out.println("Launched SignUp Screen");
	}
	
	
	private void setSceneMethod(Stage primaryStage, FXMLLoader loader) throws IOException {
		try {
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
		} catch (Exception e) { // Error when inflating view
			System.out.println("Error occured while inflating next view:" + e.getMessage());
		}

	}
}
