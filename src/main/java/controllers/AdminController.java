package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import application.Main;
import dao.AdminDao;
import dao.CustomerDao;
import dao.CustomerViewDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.collections.*;
import models.Admin;
import models.Customer;
import models.User;


public class AdminController {

	@FXML
	private Pane pane1;
	@FXML
	private Pane pane2;
	@FXML
	private Pane pane3;
	@FXML
	private Pane pane4;
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
	private TextField atxtFname;
	@FXML
	private TextField atxtLname;
	@FXML
	private TextField atxtEmail;
	@FXML
	private TextField atxtPhone;
	@FXML
	private TextField atxtAddress;
	@FXML
	private TextField atxtCity;
	@FXML
	private TextField atxtState;
	@FXML
	private TextField atxtZipcode;
	@FXML
	private DatePicker atxtDob; 
	
	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPassword;
	
	@FXML
	private ChoiceBox<String> UserType;
	@FXML
	private ChoiceBox<String> From;
	@FXML
	private ChoiceBox<String> To;
	@FXML
	private ChoiceBox<String> Class;
	
	//@FXML
	//private Label lblBookingId;
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
		System.out.println("Welcome Admin: " + user_name + "!");
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
 
	final ObservableList<String> UserTypeL = FXCollections.observableArrayList(
	        "User","Admin" );
	final ObservableList<String> FromL = FXCollections.observableArrayList(
			"Chicago", "New York", "Seattle", "Orlando", "Dallas", "California" );
	final ObservableList<String> ToL = FXCollections.observableArrayList(
			"Chicago", "New York", "Seattle", "Orlando", "Dallas", "California" );
	final ObservableList<String> ClassL = FXCollections.observableArrayList(
			"Economy","Premium Economy", "Business", "First Class" );
	@FXML
	private void initialize() {
		UserType.setValue("User");
		UserType.setItems(UserTypeL);
		From.setItems(FromL);
		From.setValue("Chicago");
		To.setItems(ToL);
		To.setValue("Orlando");
		Class.setItems(ClassL);
		Class.setValue("Economy");
	}
	
	public void viewprofile() {
		pane4.setVisible(false);
		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(true);
        System.out.println(user_name);
		
		// Create a DAO instance of the mode
		
		AdminDao AdminDao = new AdminDao();
		ArrayList<Admin> arrayList = AdminDao.getCustomer(user_name);
		
		for (Admin admin : arrayList) 
		{
			System.out.println("setting the values");
			atxtLname.setText(admin.getatxtLname());
			atxtFname.setText(admin.getatxtFname());
			atxtDob.setValue(admin.getatxtDob());
			atxtEmail.setText(admin.getatxtEmail());
			atxtPhone.setText(Long.toString(admin.getatxtPhone()));
			atxtAddress.setText(admin.getatxtAddress());
			atxtCity.setText(admin.getatxtCity());
			atxtState.setText(admin.getatxtState());
			atxtZipcode.setText(admin.getatxtZipcode());
	}
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

	
	public void create() {
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
			     System.out.println(CITY);
				String STATE = this.txtState.getText();
				if (STATE == null || STATE.trim().equals("")) {
					return;
				}
		
				String ZIPCODE = this.txtZipcode.getText();
				if (ZIPCODE == null || ZIPCODE.trim().equals("")) {
					return;
				}
				
				String USERTYPE = (String) this.UserType.getValue();
				
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
                user.setUserType(USERTYPE);
         
				// Create data access instance for customer object
				CustomerDao C1 = new CustomerDao();
				C1.CreateDetails(customer);
				C1.CreateUser(user);
	
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Message to Admin");
				alert.setHeaderText("Success Message!");
				System.out.println("User Created Successfully!");
				alert.setContentText("User Created Successfully!");
				alert.showAndWait();
	}

	public void update() {
		// Extract the data from text fields
		
		// Validate the data
		String LNAME = this.atxtLname.getText();
		if (LNAME == null || LNAME.trim().equals("")) {
			return;
		}

		String FNAME = this.atxtFname.getText();
		if (FNAME == null || FNAME.trim().equals("")) {
			return;
		}

		LocalDate DOB = this.atxtDob.getValue();
		if (DOB == null) {
			return;
		}

		String EMAIL = this.atxtEmail.getText();
		if (EMAIL == null || EMAIL.trim().equals("")) {
			return;
		}
		
		String PHONE = this.atxtPhone.getText();
		String ADDRESS = this.atxtAddress.getText();
		String CITY = this.atxtCity.getText();
		String STATE = this.atxtState.getText();
		String ZIPCODE = this.atxtZipcode.getText();	
		
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

	public void search() {
	}


}