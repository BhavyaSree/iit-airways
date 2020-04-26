package controllers;

import java.io.IOException;
import java.time.LocalDate;

//import java.time.Date;

import dao.CustomerDao;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import models.Customer;
import models.User;

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

	// Method to submit the data to database
	public void submit() {
		// Extract the data from the text fields of view
		String LNAME = this.txtLname.getText();
		if (LNAME == null || LNAME.trim().equals("")) {
			return;
		}

		String FNAME = this.txtFname.getText();
		if (FNAME == null || FNAME.trim().equals("")) {
			return;
		}

		LocalDate DOB = this.txtDob.getValue();
		if (DOB == null) {
			return;
		}

		String EMAIL = this.txtEmail.getText();
		if (EMAIL == null || EMAIL.trim().equals("")) {
			return;
		}

		String PHONE = this.txtPhone.getText();
		if (PHONE == null || PHONE.trim().equals("")) {
			return;
		}

		String ADDRESS = this.txtAddress.getText();
		if (ADDRESS == null || ADDRESS.trim().equals("")) {
			return;
		}

		String CITY = this.txtCity.getText();
		if (CITY == null || CITY.trim().equals("")) {
			return;
		}

		String STATE = this.txtState.getText();
		if (STATE == null || STATE.trim().equals("")) {
			return;
		}

		String ZIPCODE = this.txtZipcode.getText();
		if (ZIPCODE == null || ZIPCODE.trim().equals("")) {
			return;
		}

		String USERNAME = this.txtUsername.getText();
		if (USERNAME == null || USERNAME.trim().equals("")) {
			return;
		}

		String PASSWORD = this.txtPassword.getText();
		if (PASSWORD == null || PASSWORD.trim().equals("")) {
			return;
		}

		// Create Customer Object
		Customer customer = new Customer();
		// Create User Object
		User user = new User();

		// Set the values from the view
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
		user.settxtPassword(PASSWORD);

		// Create data access instance for customer object
		CustomerDao C1 = new CustomerDao();
		C1.CreateDetails(customer);

		C1.CreateUser(user);

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank you Message");
		alert.setHeaderText("Signup Successful");
		alert.setContentText("Thank you for signing up! Please Login!");
		alert.showAndWait();

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Login");
			System.out.println("Launched Login Screen");
		} catch (Exception e) {
			System.out.println("Error occured while inflating Login view:" + e);
		}

	}

	public void home() throws IOException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HomeView.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Home");
			System.out.println("Launched Illinois Tech Airways Home Screen");
		} catch (Exception e) {
			System.out.println("Error occured while inflating Home view:" + e);
		}

	}

}
