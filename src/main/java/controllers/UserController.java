package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import application.Main;
import dao.CustomerViewDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Customer;


public class UserController {

	@FXML
	private Pane pane1;
	@FXML
	private Pane pane2;
	@FXML
	private Pane pane3;
	@FXML
	private TextField txtFname;
	@FXML
	private TextField txtLname;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtPhone;
	@FXML
	private TextField txtAddress;
	@FXML
	private TextField txtCity;
	@FXML
	private TextField txtState;
	@FXML
	private TextField txtZipcode;
	@FXML
	private DatePicker txtDob; 
	
	@FXML
	private ChoiceBox<String> From;
	@FXML
	private ChoiceBox<String> To;
	@FXML
	private ChoiceBox<String> Class;


	static Customer c = new Customer();
	static String user_name = c.gettxtUsername();

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
			Main.stage.setTitle("Illinois Tech Airways Home Page");
			System.out.println("Launched Illinois Tech Airways Home Screen");
			Main.stage.show();
		} catch (Exception e) {
			System.out.println("Error in inflating view: " + e.getMessage());
		}
	}

	public static void setUsername(String username) {
		user_name = username;
		System.out.println("Welcome User: " + user_name + "!");
	}

	public UserController() {

	}
	
	public void viewprofile() {
		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(true);
        System.out.println(user_name);
		
		// Create a DAO instance of the model
		CustomerViewDao customerDao = new CustomerViewDao();
		ArrayList<Customer> arrayList = customerDao.getCustomer(user_name);
		
		for (Customer customer : arrayList) 
		{
			System.out.println("setting the values");
			txtLname.setText(customer.gettxtLname());
			txtFname.setText(customer.gettxtFname());
			txtDob.setValue(customer.gettxtDob());
			txtEmail.setText(customer.gettxtEmail());
			txtPhone.setText(Long.toString(customer.gettxtPhone()));
			txtAddress.setText(customer.gettxtAddress());
			txtCity.setText(customer.gettxtCity());
			txtState.setText(customer.gettxtState());
			txtZipcode.setText(customer.gettxtZipcode());
			
	}
	}
	
	public void viewhistory() {
		pane3.setVisible(false);
		pane2.setVisible(true);
		pane1.setVisible(false);
	}

	public void bookticket() {
		pane3.setVisible(true);
		pane2.setVisible(false);
		pane1.setVisible(false);
	}
	
	final ObservableList<String> FromL = FXCollections.observableArrayList(
			"Chicago", "New York", "Seattle", "Orlando", "Dallas", "California" );
	final ObservableList<String> ToL = FXCollections.observableArrayList(
			"Chicago", "New York", "Seattle", "Orlando", "Dallas", "California" );
	final ObservableList<String> ClassL = FXCollections.observableArrayList(
			"Economy", "Business", "First Class" );
	@FXML
	private void initialize() {
		From.setItems(FromL);
		From.setValue("Chicago");
		To.setItems(ToL);
		To.setValue("Orlando");
		Class.setItems(ClassL);
		Class.setValue("Economy");
	}
	
	public void search() 
	{
		
	}

	public void update() {
		// Extract the data from text fields
		
				// Validate the data
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
				String ADDRESS = this.txtAddress.getText();
				String CITY = this.txtCity.getText();
				String STATE = this.txtState.getText();
				String ZIPCODE = this.txtZipcode.getText();	
				
				// Create a Customer object to set the values
				Customer customer = new Customer();
				
				customer.settxtLname(LNAME);
				customer.settxtFname(FNAME);
				customer.settxtDob(DOB);
				customer.settxtEmail(EMAIL);
				customer.settxtPhone(Long.parseLong(PHONE));
				customer.settxtAddress(ADDRESS);
				customer.settxtCity(CITY);
				customer.settxtState(STATE);
				customer.settxtZipcode(ZIPCODE);
				
				// Create data access instance for customerView object
				CustomerViewDao c1 = new CustomerViewDao();
				c1.update(user_name, customer);

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");
		System.out.println("Profile updated successfully!");
		alert.setHeaderText("Success message");
		alert.setContentText("Profile updated successfully!");
		alert.showAndWait();
	}

	public void book() {
		TextInputDialog dialog = new TextInputDialog("16 digit number");
		dialog.setTitle("Payment Details");
		dialog.setHeaderText("Debit/Credit Card");
		dialog.setContentText("Please enter your card number");

		Optional<String> cardno = dialog.showAndWait();
		if (cardno.isPresent()) {
			String cardnumber = cardno.get();
			System.out.println("Card number entered: " + cardnumber);
		}
		try {
			
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/TicketView.fxml"));
			System.out.println("Launched TicketDeatils Screen");
			Scene scene = new Scene(root, 800, 600);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Ticket Details");
			Main.stage.show();
			TicketController T1 = new TicketController();
			T1.display(user_name);
		} catch (Exception e) {
			System.out.println("Error in inflating view: " + e.getMessage());
		}
		
		
	}

}
