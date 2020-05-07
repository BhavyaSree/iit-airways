
/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: Launch Admin screen and perform admin actions
 * Date: 05/09/2020
 * File: Admin Controller.java*/

package controllers;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;
import javafx.application.Platform;
import application.Main;
import dao.AdminProfileUpdateDao;
import dao.AdminHistoryDao;
import dao.CustomerCreateDao;
import dao.CustomerProfileViewDao;
import dao.FlightsSearchDao;
import dao.TicketBookDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.collections.*;
import models.AdminProfileModel;
import models.CustomerProfileModel;
import models.FlightSearchModel;
import models.HistoryModel;
import models.TicketBookModel;
import models.LoginModel;

public class AdminController implements Initializable {

	@FXML
	private Pane pane1; // set pane 1
	@FXML
	private Pane pane2; // set pane 2
	@FXML
	private Pane pane3; // set pane 3
	@FXML
	private Pane pane4; // set pane 4
	@FXML
	private Pane pane5; // set pane 5
	@FXML
	private TextField txtFname; // set text field for first name
	@FXML
	private TextField txtLname; // set text field for last name
	@FXML
	private TextField txtEmail; // set text field for Email
	@FXML
	private TextField txtPhone; // set text field for Phone
	@FXML
	private TextField txtAddress; // set text field for Address
	@FXML
	private TextField txtCity; // set text field for City
	@FXML
	private TextField txtState; // set text field for State
	@FXML
	private TextField txtZipcode; // set text field for Zip code
	@FXML
	private DatePicker txtDob; // set text field for Date of Birth
	@FXML
	private TextField atxtFname; // set text field for first name
	@FXML
	private TextField atxtLname; // set text field for last name
	@FXML
	private TextField atxtEmail; // set text field for Email
	@FXML
	private TextField atxtPhone; // set text field for Phone
	@FXML
	private TextField atxtAddress;// set text field for Address
	@FXML
	private TextField atxtCity; // set text field for City
	@FXML
	private TextField atxtState; // set text field for State
	@FXML
	private TextField atxtZipcode; // set text field for State
	@FXML
	private DatePicker atxtDob; // set text field for Date of Birth
	@FXML
	private TextField txtUsername; // set user name text field
	@FXML
	private TextField txtPassword; // set password text field
	@FXML
	private Label lblErrorU;
	@FXML
	private Label lblErrorC;
	@FXML
	private Label lblError1;
	@FXML
	private ChoiceBox<String> UserType; // choice box for user type-admin/user
	@FXML
	private ChoiceBox<String> From; // choice box for travel from destination
	@FXML
	private ChoiceBox<String> To; // choice box for travel to destination
	@FXML
	private ChoiceBox<String> Class; // choice box for travel from class
	@FXML
	private DatePicker Date; // set date picker
	@FXML
	private TableView<FlightSearchModel> tblFlights; // Table view for flight details
	@FXML
	private TableColumn<FlightSearchModel, String> fromId; // From destination table column
	@FXML
	private TableColumn<FlightSearchModel, String> toId; // To destination table column
	@FXML
	private TableColumn<FlightSearchModel, String> dateId; // Date id table column
	@FXML
	private TableColumn<FlightSearchModel, String> timeId; // Time id table column
	@FXML
	private TableColumn<FlightSearchModel, String> classId; // Class id table column
	@FXML
	private TableColumn<FlightSearchModel, String> priceId; // Price id table column
	@FXML
	private TableView<HistoryModel> tblHistory; // Table view for history details
	@FXML
	private TableColumn<HistoryModel, String> LNameId; // Last name table column
	@FXML
	private TableColumn<HistoryModel, String> FromId; // From destination table column
	@FXML
	private TableColumn<HistoryModel, String> ToId; // To destination table column
	@FXML
	private TableColumn<HistoryModel, String> DateId; // Date id table column
	@FXML
	private TableColumn<HistoryModel, String> TimeId; // Time id table column
	@FXML
	private TableColumn<HistoryModel, String> ClassId; // Class id table column
	@FXML
	private TableColumn<HistoryModel, String> BookId; // Booking id table column
	@FXML
	private Button bookBtn; // set book button
	@FXML
	private Button deleteBtn; // set delete button
	@FXML
	private Button createBtn; // set create button
	private static String first_name; // set global object First name in search flight in search view
	private static String last_name; // set global object Last name in search flight in search view
	private static String email; // set global object Email in search flight in search view
	private static long phone; // set global object Phone in search flight in search view
	private static String F_FROM; // set global object Travel from in search flight in search view
	private static String F_TO; // set global object Travel to in search flight in search view
	private static String F_DATE; // set global object Travel date in search flight in search view
	private static String F_TIME; // set global object Travel time in search flight in search view
	private static String F_CLASS; // set global object class in search flight in search view
	private static String F_PRICE; // set global object price in search flight in search view
	private static String T_FROM; // set global object Travel from in history view
	private static String T_TO; // set global object Travel to in history view
	private static String T_DATE; // set global object Travel date in history view
	private static String T_TIME; // set global object Travel time from in history view
	private static String T_CLASS; // set global object class from in history view
	private static String T_BOOKID; // set global object booking id from in history view
	private static String T_last_name; // set global object Last name from in history view

	// set global user name object
	static CustomerProfileModel c = new CustomerProfileModel();
	static String user_name = c.gettxtUsername();

	// Setting choice box drop down values for from destination, to destination and
	// class and user type-admin/user
	final ObservableList<String> UserTypeL = FXCollections.observableArrayList("Customer", "Admin");
	final ObservableList<String> FromL = FXCollections.observableArrayList("Chicago");
	final ObservableList<String> ToL = FXCollections.observableArrayList("New York", "Seattle", "Orlando",
			"Dallas");
	final ObservableList<String> ClassL = FXCollections.observableArrayList("Economy", "Business");

	// Initialize the admin controller
	public void initialize(URL location, ResourceBundle resources) {
		pane5.setVisible(false); // set table view pane invisible
		UserType.setValue("Customer"); // set user type as user by default
		UserType.setItems(UserTypeL);
		From.setItems(FromL);
		From.setValue("Chicago"); // set from destination value to chicago as default
		To.setItems(ToL);
		To.setValue("Orlando"); // set to destination value to orlando as default
		Class.setItems(ClassL);
		Class.setValue("Economy"); // set class value to economy as default
		bookBtn.setDisable(true); // disable book button

		// Code for tblFlights table view
		fromId.setCellValueFactory(new PropertyValueFactory<FlightSearchModel, String>("fromId"));
		toId.setCellValueFactory(new PropertyValueFactory<FlightSearchModel, String>("toId"));
		dateId.setCellValueFactory(new PropertyValueFactory<FlightSearchModel, String>("dateId"));
		timeId.setCellValueFactory(new PropertyValueFactory<FlightSearchModel, String>("timeId"));
		classId.setCellValueFactory(new PropertyValueFactory<FlightSearchModel, String>("classId"));
		priceId.setCellValueFactory(new PropertyValueFactory<FlightSearchModel, String>("priceId"));

		// auto adjust width of columns depending on their content
		tblFlights.setColumnResizePolicy((param) -> true);
		Platform.runLater(() -> customResize(tblFlights));

		tblFlights.setVisible(false); // set invisible initially

		// Code for tblHistory table view
		LNameId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("LNameId"));
		FromId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("FromId"));
		ToId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("ToId"));
		DateId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("DateId"));
		TimeId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("TimeId"));
		ClassId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("ClassId"));
		BookId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("BookId"));

		// Auto adjust width of columns depending on their content
		tblHistory.setColumnResizePolicy((param) -> true);
		Platform.runLater(() -> customResize(tblHistory));
		tblHistory.setVisible(false); // set invisible initially
	}

	// reset table view based on the values
	public void customResize(TableView<?> view) {

		AtomicLong width = new AtomicLong();
		view.getColumns().forEach(col -> {
			width.addAndGet((long) col.getWidth());
		});
		double tableWidth = view.getWidth();

		if (tableWidth > width.get()) {
			view.getColumns().forEach(col -> {
				col.setPrefWidth(col.getWidth() + ((tableWidth - width.get()) / view.getColumns().size()));
			});
		}
	}

	// Method when admin clicks on logout button
	public void logout() {
		// Alert message to thank admin
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank you Message");
		alert.setHeaderText("Illinois Tech Airways");
		alert.setContentText("Thank you for choosing us! Please visit again!");
		alert.showAndWait();
		System.out.println("Logged out successfully");
		// Launching home screen to admin
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml")); // launch
																											// homeview
																											// screen
			Scene scene = new Scene(root, 800, 600);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Illinois Tech Airways Home Page");
			System.out.println("Launched Illinois Tech Airways Home Screen");
			Main.stage.show();
		} catch (Exception e) { // error when launching screen
			System.out.println("Error in inflating view: " + e.getMessage());
		}
	}

	// set user name from login screen and pass to other screens
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
		pane5.setVisible(false);
	}

	public void addadminuser() {
		pane4.setVisible(false);
		pane3.setVisible(false);
		pane2.setVisible(true);
		pane1.setVisible(false);
		pane5.setVisible(false);
		createBtn.setDisable(false);
		txtUsername.clear();
		txtPassword.clear();
		txtLname.clear();
		txtFname.clear();
		txtAddress.clear();
		txtPhone.clear();
		txtEmail.clear();
		txtState.clear();
		txtCity.clear();
		txtZipcode.clear();
		txtDob.setValue(null);
		// UserType.clearSelection(null);
	}

	// method to view own profile when clicked on view profile button
	public void viewprofile() {
		pane4.setVisible(false);
		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(true); // set other panes as invisible and set profile screen visible
		pane5.setVisible(false);

		// Create a DAO instance of the model
		AdminProfileUpdateDao AdminDao = new AdminProfileUpdateDao();
		ArrayList<AdminProfileModel> arrayList = AdminDao.getCustomer(user_name); // pass user name to get information

		// set values in the text fields in view profile screen
		for (AdminProfileModel admin : arrayList) {
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

	// method for admin to latest view history details when clicked on view history
	// button
	public void viewhistory() {
		pane4.setVisible(false);
		pane3.setVisible(true); // set other panes as invisible except history screen
		pane2.setVisible(false);
		pane1.setVisible(false);
		pane5.setVisible(false);
		deleteBtn.setDisable(true);

		// Create data access instance for History data access object
		AdminHistoryDao AH1 = new AdminHistoryDao();

		// if history details are fetched, show table view else show alert to say no
		// history
		try {
			tblHistory.getItems().setAll(AH1.getHistory());
			if (tblHistory.getItems().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert Message");
				alert.setHeaderText("History Info");
				alert.setContentText("No Ticket History");
				alert.showAndWait();
			} else
				tblHistory.setVisible(true); // if details are present history table is shown

		} catch (Exception e) {
			System.out.println("Error while printing ticket history " + e.getMessage());
		}
	}

	// when admin double click on table record, action is captured
	@FXML
	public void click2(MouseEvent event) {
		if (event.getClickCount() == 2) // Checking double click
		{
			deleteBtn.setDisable(false); // enable delete button to admin to delete the particular record
			System.out.println("Deleting selected record");
			T_last_name = tblHistory.getSelectionModel().getSelectedItem().getLNameId();
			T_FROM = tblHistory.getSelectionModel().getSelectedItem().getFromId();
			T_TO = tblHistory.getSelectionModel().getSelectedItem().getToId();
			T_DATE = tblHistory.getSelectionModel().getSelectedItem().getDateId();
			T_TIME = tblHistory.getSelectionModel().getSelectedItem().getTimeId();
			T_CLASS = tblHistory.getSelectionModel().getSelectedItem().getClassId();
			T_BOOKID = tblHistory.getSelectionModel().getSelectedItem().getBookId();
		}
	}

	// method to delete record when clicked on delete button
	public void delete() {
		pane4.setVisible(false);
		pane3.setVisible(true);
		pane2.setVisible(false);
		pane1.setVisible(false);
		pane5.setVisible(false);
		deleteBtn.setDisable(false); // enable delete button

		// Create data access instance to delete ticket
		TicketBookDao T = new TicketBookDao();

		try {

			T.deleteTicket(T_last_name, T_FROM, T_TO, T_DATE, T_TIME, T_CLASS, T_BOOKID);

			viewhistory(); // refresh history details table after deletion
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Alert Message");
			alert.setHeaderText("Delete Info");
			alert.setContentText("Ticket has been deleted Successfully!!");
			System.out.println("Deleted Selected record successfully");
			alert.showAndWait();
		} catch (Exception e) { // Error to display while deleting record
			System.out.println("Error while deleting the ticket" + e.getMessage());
		}
	}

	// method to book the selected flight when clicked on book button
	public void book() {
		try {
			// Textinput dialog box to enter card details
			TextInputDialog dialog = new TextInputDialog("Enter numbers");
			dialog.setTitle("Payment Details");
			dialog.setHeaderText("Debit/Credit Card");
			dialog.setContentText("Please enter your card number");
			Optional<String> cardno = dialog.showAndWait();
			String card = cardno.get();
			// check if the input value is entered, only numbers are present
			if (cardno.isPresent() && !cardno.get().isEmpty() && (card.matches("\\d*"))) {
				System.out.println("Card number entered: " + card);
				TicketBookDao T1 = new TicketBookDao();

				try {
					ArrayList<TicketBookModel> arrayList = T1.getCustomer(user_name);

					for (TicketBookModel ticket : arrayList) {

						last_name = ticket.getLast_name();
						first_name = ticket.getFirst_name();
						email = ticket.getEmail();
						phone = Long.parseLong(ticket.getPhone());

					}

					T1.BookTicket(user_name, last_name, first_name, email, phone, F_FROM, F_TO, F_DATE, F_TIME, F_CLASS,
							F_PRICE);
					// Alert to show success message that ticket was booked successfully
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Message");
					System.out.println("Ticket Booked successfully!");
					alert.setHeaderText("Success message");
					alert.setContentText("Ticket Booked successfully!");
					alert.showAndWait();
					System.out.println("Ticket booked successfully!");
				} catch (Exception e) { // error if ticket is not booked
					System.out.println("Not able to book the ticket" + e.getMessage());
				}
				// display ticket view screen after the ticket is booked successfully
				try {
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/TicketView.fxml"));
					System.out.println("Launched Ticket Details Screen");
					Scene scene = new Scene(root, 800, 600);
					Main.stage.setScene(scene);
					Main.stage.setTitle("Ticket Details");
					Main.stage.show();
					TicketController.setUsername(user_name); // pass user name to ticket controller
				} catch (Exception e) { // error in loading ticket view screen
					System.out.println("Error in inflating view: " + e.getMessage());
				}
			}
		} catch (Exception e) { // error if ticket is not booked
			System.out.println("Error in booking ticket: " + e.getMessage());
		}
	}

	// method to search for flights with the selected criteria and display using
	// table view when clicked on search button
	public void search() {
		pane5.setVisible(true); // set table view pane visible
		bookBtn.setDisable(true); // set book button disable initially

		String F_FROM = this.From.getValue();
		String F_TO = this.To.getValue();

		LocalDate F_DATE = this.Date.getValue();
		if(F_DATE == null) {
			lblError1.setText("Please Enter the Date!");
			return;
		}
		lblError1.setText("");
		String F_DATE1 = this.Date.getValue().toString();
		
		String F_CLASS = this.Class.getValue();

		// Create data access instance for Flights object
		FlightsSearchDao F1 = new FlightsSearchDao();
		// check if there are any flights for selected criteria and display the details
		// if not throw an alert to change search criteria
		try {
			tblFlights.getItems().setAll(F1.getFlights(F_FROM, F_TO, F_DATE1, F_CLASS));
			if (tblFlights.getItems().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert Message");
				alert.setHeaderText("Flights Info");
				alert.setContentText("No flights available for the search");
				alert.showAndWait();
			} else
				tblFlights.setVisible(true); // set table view show flight details visible
		} catch (Exception e) { // Error if flight details are not obtained
			System.out.println("No flights available for the search" + e.getMessage());
		}

	}

	// if the record is selected by double clicking, enable user to book ticket
	@FXML
	public void click1(MouseEvent event) {
		if (event.getClickCount() == 2) // Checking double click
		{
			bookBtn.setDisable(false); // set book button enable
			System.out.println("Searching for flights");
			F_FROM = tblFlights.getSelectionModel().getSelectedItem().getFromId();
			F_TO = tblFlights.getSelectionModel().getSelectedItem().getToId();
			F_DATE = tblFlights.getSelectionModel().getSelectedItem().getDateId();
			F_TIME = tblFlights.getSelectionModel().getSelectedItem().getTimeId();
			F_CLASS = tblFlights.getSelectionModel().getSelectedItem().getClassId();
			F_PRICE = tblFlights.getSelectionModel().getSelectedItem().getPriceId();

		}
	}

	// method to update the profile when clicked on update button in view profile
	// screen
	public void update() {

		lblErrorU.setText("");
		// Extract the data from text fields

		// Validate the data and check if all the value are entered
		String LNAME = this.atxtLname.getText();
		if (LNAME == null || LNAME.trim().equals("")) {
			lblErrorU.setText("Error: Last Name should not be empty");
			return;
		}

		String FNAME = this.atxtFname.getText();
		if (FNAME == null || FNAME.trim().equals("")) {
			lblErrorU.setText("Error: First Name should not be empty");
			return;
		}

		LocalDate DOB = this.atxtDob.getValue();
		if (DOB == null) {
			lblErrorU.setText("Error: Date of Birth should not be empty");
			return;
		}

		String EMAIL = this.atxtEmail.getText();
		if (EMAIL == null || EMAIL.trim().equals("")) {
			lblErrorU.setText("Error: Email should not be empty");
			return;
		}

		String PHONE = this.atxtPhone.getText();
		if ((PHONE == null) || (PHONE.trim().equals("")) || (!PHONE.matches("\\d*"))) {
			lblErrorU.setText("Error: Phone number should be a number");
			return;
		}

		String ADDRESS = this.atxtAddress.getText();
		String CITY = this.atxtCity.getText();
		String STATE = this.atxtState.getText();
		String ZIPCODE = this.atxtZipcode.getText();

		// Create a Customer object to set the values
		CustomerProfileModel customer = new CustomerProfileModel();

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
		CustomerProfileViewDao c1 = new CustomerProfileViewDao();
		c1.update(user_name, customer);
		// alert message to show that profile has been updated successfully
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");
		System.out.println("Profile updated successfully!");
		alert.setHeaderText("Success message");
		alert.setContentText("Profile updated successfully!");
		alert.showAndWait();
		System.out.println("Profile updated successfully!");
	}

	// method to allow admin to create an admin or user when clicked on create
	// button

	private String hashText(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public void create() {

		lblErrorC.setText("");
		// Extract the data from the text fields of view
		// validating the given inputs
		String LNAME = this.txtLname.getText();
		if (LNAME == null || LNAME.trim().equals("")) {
			lblErrorC.setText("Error: Last Name should not be empty");
			return;
		}

		String FNAME = this.txtFname.getText();
		if (FNAME == null || FNAME.trim().equals("")) {
			lblErrorC.setText("Error: First Name should not be empty");
			return;
		}

		LocalDate DOB = this.txtDob.getValue();
		if (DOB == null) {
			lblErrorC.setText("Error: Date of Birth should not be empty");
			return;
		}

		String EMAIL = this.txtEmail.getText();
		if (EMAIL == null || EMAIL.trim().equals("")) {
			lblErrorC.setText("Error: Email should not be empty");
			return;
		}

		String PHONE = this.txtPhone.getText();
		if ((PHONE == null) || (PHONE.trim().equals("")) || (!PHONE.matches("\\d*"))) {
			lblErrorC.setText("Error: Phone number should be a number");
			return;
		}

		String ADDRESS = this.txtAddress.getText();

		String CITY = this.txtCity.getText();

		String STATE = this.txtState.getText();

		String ZIPCODE = this.txtZipcode.getText();

		String USERTYPE = (String) this.UserType.getValue();

		String USERNAME = this.txtUsername.getText();
		if (USERNAME == null || USERNAME.trim().equals("")) {
			lblErrorC.setText("Error: User Name should not be empty");
			return;
		}

		String PASSWORD = this.txtPassword.getText();
		if (PASSWORD == null || PASSWORD.trim().equals("")) {
			lblErrorC.setText("Error: Password should not be empty");
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
		user.setUserType(USERTYPE);
		try {
			user.settxtPassword(hashText(PASSWORD));
		} catch (NoSuchAlgorithmException e1) {
			System.out.println("Error while setting hash password" + e1.getMessage());
		}

		// Create data access instance for customer object
		CustomerCreateDao C1 = new CustomerCreateDao();
		C1.CreateDetails(customer);
		C1.CreateUser(user);

		// alert message to show that creation was successful
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message to Admin");
		alert.setHeaderText("Success Message!");
		System.out.println("User Created Successfully!");
		alert.setContentText("User Created Successfully!");
		alert.showAndWait();
		createBtn.setDisable(true); // disable create button after successful creation
		System.out.println("Creation successful!");
	}

}