/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: Login controller to enable user or admin to login using the credentials
 * Date: 05/09/2020
 * File: Home Controller.java*/

package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import application.Main;
import dao.LoginDao;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class LoginController {
	@FXML
	private TextField txtUsername; // set text field for username
	@FXML
	private PasswordField txtPassword; // set password field for password
	@FXML
	private Label lblError; // set label for error
	private LoginDao model; // initialize login dao

	// login controller constructor
	public LoginController() {
		model = new LoginDao();
	}

	// method to log out when clicked on home from login screen and display home
	// screen
	public void home() {
		// Alert message to logout
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank you Message");
		alert.setHeaderText("Illinois Tech Airways");
		alert.setContentText("Thank you for choosing us!Please visit again!");
		alert.showAndWait();
		// launch home screen
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
			Scene scene = new Scene(root, 800, 600);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Illinois Tech Airways Home Page");
			Main.stage.show();
			System.out.println("Launched Illinois Tech Airways Home Screen");
		} catch (Exception e) { // error when launching home screen
			System.out.println("Error in inflating view: " + e.getMessage());
		}
	}

	private String hashText(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
		return sb.toString();
	}
	// method to login when clicked on login button in login screen after giving
	// credentials
	public void login() throws NoSuchAlgorithmException {

		lblError.setText("");
		String username = this.txtUsername.getText(); // get username entered
		String password = this.txtPassword.getText(); // get password entered
		// validation for input values
		// check if there are any spaces or if the input is invalid
		if (username == null || username.trim().equals("")) {
			lblError.setText("Error: Invalid Username!");
			txtUsername.setText("");
			txtPassword.setText("");
			return;
		} // check if there are any spaces or if the input is invalid
		if (password == null || password.trim().equals("")) {
			lblError.setText("Error: Invalid Password!");
			txtUsername.setText("");
			txtPassword.setText("");
			return;
		} // check if there are any spaces or if the input is invalid
		if (username == null || username.trim().equals("") && (password == null || password.trim().equals(""))) {
			lblError.setText("Error: Spaces are not allowed. Please Re-enter!");
			txtUsername.setText("");
			txtPassword.setText("");
			return;
		}
		String password1 = hashText(password);
		checkCredentials(username, password1); // validate credentials
	}

	// when clicked on cancel button, username and password fields should be
	// refreshed
	public void cancel() {
		lblError.setText("");
		txtUsername.setText("");
		txtPassword.setText("");
	}

	// method to validate the credentials
	public void checkCredentials(String username, String password) {
		Boolean isValid = model.getCredentials(username, password);
		if (!isValid) {
			lblError.setText("Error: Invalid User!"); // throw error if they are invalid
			return;
		}
		// launch next screen based on the user/admin
		try {
			AnchorPane root;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Welcome Message");
			alert.setHeaderText("Illinois Tech Airways");
			alert.setContentText("Welcome " + username + "!");
			alert.showAndWait();
			// if the credentials are admin's, launch admin view
			if (model.isAdmin() && isValid) {
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/AdminView.fxml"));
				Main.stage.setTitle("Admin View");
				System.out.println("Launched Admin Screen");
				AdminController.setUsername(username);
			} else {
				// if the credentials are user's, launch user view
				root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/CustomerView.fxml"));
				Main.stage.setTitle("Customer View");
				System.out.println("Launched User Screen");
				CustomerController.setUsername(username);
			}
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (Exception e) { // error in launching screen
			System.out.println("Error in inflating view: " + e.getMessage());
		}

	}
}
