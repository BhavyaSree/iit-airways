/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: Signup controller to create a new account for first time users
 * Date: 05/09/2020
 * File: SignUp Controller.java*/

package controllers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import dao.CustomerProfileUpdateDao;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import models.CustomerProfileModel;
import models.LoginModel;

public class SignUpController {
	

	@FXML
	private TextField txtLname;

	@FXML
	private TextField txtFname;

	@FXML
	private DatePicker txtDob;

	@FXML
	private TextField txtPhone;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtAddress;

	@FXML
	private TextField txtCity;

	@FXML
	private TextField txtState;

	@FXML
	private TextField txtZipcode;

	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPassword;
	
	@FXML
	private Label lblError;
	
	
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


	// Method to submit the data to database
	public void submit() 
	{
		lblError.setText("");
		// Extract the data from the text fields of view
		// validate the input fields
		String LNAME = this.txtLname.getText();
		if (LNAME == null || LNAME.trim().equals("")) {
			lblError.setText("Error: Last Name should not be empty");	
			return;
		}

		String FNAME = this.txtFname.getText();
		if (FNAME == null || FNAME.trim().equals("")) {
			lblError.setText("Error: First Name should not be empty");
			return;
		}

		LocalDate DOB = this.txtDob.getValue();
		if (DOB == null) {
			lblError.setText("Error: Date of Birth should not be empty");
			return;
		}

		String EMAIL = this.txtEmail.getText();
		if (EMAIL == null || EMAIL.trim().equals("")) {
			lblError.setText("Error: Email should not be empty");
			return;
		}

		String PHONE = this.txtPhone.getText();
		if (!PHONE.matches("\\d*")) {
			lblError.setText("Error: Phone number should be a number");
			return;
		}
		
		String ADDRESS = this.txtAddress.getText(); 
		String CITY = this.txtCity.getText();
		String STATE = this.txtState.getText();
		String ZIPCODE = this.txtZipcode.getText(); 		



		String USERNAME = this.txtUsername.getText();
		if (USERNAME == null || USERNAME.trim().equals("")) {
			lblError.setText("Error: UserName should not be empty");
			return;
		}

		String PASSWORD = this.txtPassword.getText();
		if (PASSWORD == null || PASSWORD.trim().equals("")) {
			lblError.setText("Error: Password should not be empty");
			return;
		}

		// Create Customer Object
		CustomerProfileModel customer = new CustomerProfileModel();
		// Create User Object
		LoginModel user = new LoginModel();

		// Set the values from the view
		customer.settxtUsername(USERNAME);
		customer.settxtLname(LNAME);
		customer.settxtFname(FNAME);
		customer.settxtDob(DOB);
		customer.settxtEmail(EMAIL);
		customer.settxtPhone(Long.parseLong(PHONE));
		customer.settxtAddress(ADDRESS);
		customer.settxtCity(CITY);
		customer.settxtState(STATE);
		customer.settxtZipcode(ZIPCODE);
		user.settxtUsername(USERNAME);
		
		try 
		{
			user.settxtPassword(hashText(PASSWORD));
		} catch (NoSuchAlgorithmException e1) 
		{
			System.out.println("Error while setting hash password" + e1.getMessage());
		}
		
		

		// Create data access instance for customer object
		CustomerProfileUpdateDao C1 = new CustomerProfileUpdateDao();
		C1.CreateDetails(customer);

		C1.CreateUser(user);
		// Alert message for successful signup
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank you Message");
		alert.setHeaderText("Signup Successful");
		alert.setContentText("Thank you for signing up! Please Login!");
		alert.showAndWait();
		System.out.println("Signup Successful!");
		// Launch Login screen if the signup is successful
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Login");
			System.out.println("Launched Login Screen");
		} catch (Exception e) { // Error in launching screen
			System.out.println("Error occured while inflating Login view:" + e.getMessage());
		}

	}

	// method to log out when clicked on home from login screen and display home
	// screen
	public void home() throws IOException {
		try {
			// launch home screen
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HomeView.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Home");
			System.out.println("Launched Illinois Tech Airways Home Screen");
		} catch (Exception e) { // error when launching home screen
			System.out.println("Error occured while inflating Home view:" + e.getMessage());
		}

	}

}
