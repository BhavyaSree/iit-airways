/* Names: BhavyaSree Bindela, Sneha Rajulapally
 * CWID: A20448208,A20457266
 * Final Project: Airline Reservation System. 
 * Description: Launch User screen and perform user actions
 * Date: 05/09/2020
 * File: User Controller.java*/

package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;
import javafx.fxml.Initializable;
import application.Main;
import dao.UserProfileViewDao;
import dao.FlightsSearchDao;
import dao.UserHistoryDao;
import dao.TicketBookDao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.UserProfileModel;
import models.FlightSearchModel;
import models.HistoryModel;
import models.TicketBookModel;

public class UserController implements Initializable {
	@FXML
	private Pane pane1; // set pane 1
	@FXML
	private Pane pane2; // set pane 2
	@FXML
	private Pane pane3; // set pane 3
	@FXML
	private Pane pane4; // set pane 4
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
	private ChoiceBox<String> From; // choice box for travel from destination
	@FXML
	private ChoiceBox<String> To; // choice box for travel from destinations
	@FXML
	private ChoiceBox<String> Class; // choice box for travel from class
	@FXML
	private DatePicker Date; // set date picker
	@FXML
	private Label lblError;
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
	private TableColumn<HistoryModel, String> BookId; // Booking id table column
	@FXML
	private Button bookBtn; // set book button
	@FXML
	private TableView<HistoryModel> tblHistory; // set book button
	@FXML
	private TableColumn<HistoryModel, String> FromId; // Last name table column
	@FXML
	private TableColumn<HistoryModel, String> ToId; // From destination table column
	@FXML
	private TableColumn<HistoryModel, String> DateId; // To destination table column
	@FXML
	private TableColumn<HistoryModel, String> TimeId; // Date id table column
	@FXML
	private TableColumn<HistoryModel, String> ClassId; // Class id table column

	private static String first_name;// set global object First name in search flight in search view
	private static String last_name; // set global object Last name in search flight in search view
	private static String email; // set global object Email in search flight in search view
	private static long phone; // set global object Phone in search flight in search view
	private static String F_FROM; // set global object Phone in search flight in search view
	private static String F_TO; // set global object Travel to in search flight in search view
	private static String F_DATE; // set global object Travel date in search flight in search view
	private static String F_TIME; // set global object Travel time in search flight in search view
	private static String F_CLASS; // set global object class in search flight in search view
	private static String F_PRICE; // set global object price in search flight in search view

	// set global user name object
	static UserProfileModel c = new UserProfileModel();
	static String user_name = c.gettxtUsername();

	// Setting choice box drop down values for from destination, to destination and
	// class
	final ObservableList<String> FromL = FXCollections.observableArrayList("Chicago", "New York", "Seattle", "Orlando",
			"Dallas", "California");
	final ObservableList<String> ToL = FXCollections.observableArrayList("Chicago", "New York", "Seattle", "Orlando",
			"Dallas", "California");
	final ObservableList<String> ClassL = FXCollections.observableArrayList("Economy", "Premium Economy", "Business",
			"First Class");

	// Initialize the user controller
	public void initialize(URL location, ResourceBundle resources) {
		pane4.setVisible(false); // set table view pane invisible
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
		FromId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("FromId"));
		ToId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("ToId"));
		DateId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("DateId"));
		TimeId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("TimeId"));
		ClassId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("ClassId"));
		BookId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("BookId"));

		// auto adjust width of columns depending on their content
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
		// Alert message to thank user
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank you Message");
		alert.setHeaderText("Illinois Tech Airways");
		alert.setContentText("Thank you for choosing us! Please visit again!");
		alert.showAndWait();
		System.out.println("Logged out successfully");
		// Launching home screen to user
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
		System.out.println("Welcome User: " + user_name + "!");
	}

	public UserController() {

	}

	// method to view own profile when clicked on view profile button
	public void viewprofile() {
		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(true); // set other panes as invisible and set profile screen visible
		pane4.setVisible(false);
		System.out.println(user_name);

		// Create a DAO instance of the model
		UserProfileViewDao customerDao = new UserProfileViewDao();
		ArrayList<UserProfileModel> arrayList = customerDao.getCustomer(user_name); // pass user name to get information

		// set values in the text fields in view profile screen
		for (UserProfileModel customer : arrayList) {
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

	// method to view own history details when clicked on view history button
	public void viewhistory() {
		pane3.setVisible(false);
		pane2.setVisible(true); // set other panes as invisible except history screen
		pane1.setVisible(false);
		pane4.setVisible(false);

		// Create data access instance for History data access object
		UserHistoryDao H1 = new UserHistoryDao();

		// if history details are fetched, show table view else show alert to say no
		// history
		try {
			tblHistory.getItems().setAll(H1.getHistory(user_name));
			if (tblHistory.getItems().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert Message");
				alert.setHeaderText("History Info");
				alert.setContentText("No Ticket History");
				alert.showAndWait();
			} else
				tblHistory.setVisible(true); // if details are present history table is shown
		} catch (Exception e) {
			System.out.println("Error while printing ticket hisrory " + e.getMessage());
		}
	}

	// method to book ticket when clicked on book button
	public void bookticket() {
		pane3.setVisible(true);
		pane2.setVisible(false);
		pane1.setVisible(false);
		pane4.setVisible(false);
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
				TicketBookDao TB = new TicketBookDao();

				try {
					ArrayList<TicketBookModel> arrayList = TB.getCustomer(user_name);

					for (TicketBookModel ticket : arrayList) {

						last_name = ticket.getLast_name();
						first_name = ticket.getFirst_name();
						email = ticket.getEmail();
						phone = Long.parseLong(ticket.getPhone());

					}

					System.out.println(last_name);
					System.out.println(first_name);
					System.out.println(email);
					System.out.println(phone);
					System.out.println(F_FROM);
					System.out.println(F_TO);
					System.out.println(F_DATE);
					System.out.println(F_TIME);
					System.out.println(F_CLASS);
					System.out.println(F_PRICE);

					TB.BookTicket(user_name, last_name, first_name, email, phone, F_FROM, F_TO, F_DATE, F_TIME, F_CLASS,
							F_PRICE);
					// Alert to show success message that ticket was booked successfully
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Message");
					System.out.println("Ticket Booked successfully!");
					alert.setHeaderText("Success message");
					alert.setContentText("Ticket Booked successfully!");
					alert.showAndWait();
					System.out.println("Ticket booked successfully!");
				} catch (Exception e) {
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
		pane4.setVisible(true); // set table view pane visible
		bookBtn.setDisable(true); // set book button disable initially

		String F_FROM = this.From.getValue();
		String F_TO = this.To.getValue();
		String F_DATE = this.Date.getValue().toString();
		String F_CLASS = this.Class.getValue();

		// Create data access instance for Flights object
		FlightsSearchDao F1 = new FlightsSearchDao();
		// check if there are any flights for selected criteria and display the details
		// if not throw an alert to change search criteria
		try {
			tblFlights.getItems().setAll(F1.getFlights(F_FROM, F_TO, F_DATE, F_CLASS));
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
	public void click(MouseEvent event) {
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
		
		lblError.setText("");
		// Extract the data from text fields

		// Validate the data and check if all the value are entered
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

		String PHONE = this.txtPhone.getText();
		if (!PHONE.matches("\\d*")) {
			lblError.setText("Error: Phone number should be a number");
			return;
		}
		
		String ADDRESS = this.txtAddress.getText();
		String CITY = this.txtCity.getText();
		String STATE = this.txtState.getText();
		String ZIPCODE = this.txtZipcode.getText();

		// Create a Customer object to set the values
		UserProfileModel customer = new UserProfileModel();

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
		UserProfileViewDao c1 = new UserProfileViewDao();
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

}
