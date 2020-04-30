package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

import application.Main;
import dao.AdminDao;
import dao.AdminHistoryDao;
import dao.CustomerDao;
import dao.CustomerViewDao;
import dao.FlightsDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.collections.*;
import models.Admin;
import models.Customer;
import models.FlightsModel;
import models.HistoryModel;
import models.User;


public class AdminController implements Initializable {

	@FXML
	private Pane pane1;
	@FXML
	private Pane pane2;
	@FXML
	private Pane pane3;
	@FXML
	private Pane pane4;
	@FXML
	private Pane pane5;
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
	@FXML
	private DatePicker Date;
	@FXML
	private TableView<FlightsModel> tblFlights;
	@FXML
	private TableColumn<FlightsModel, String> fromId;
	@FXML
	private TableColumn<FlightsModel, String> toId;
	@FXML
	private TableColumn<FlightsModel, String> dateId;
	@FXML
	private TableColumn<FlightsModel, String> timeId;
	@FXML
	private TableColumn<FlightsModel, String> classId;
	@FXML
	private TableColumn<FlightsModel, String> priceId;
	@FXML
	private TableView<HistoryModel> tblHistory;
	@FXML
	private TableColumn<HistoryModel, String> FromId;
	@FXML
	private TableColumn<HistoryModel, String> ToId;
	@FXML
	private TableColumn<HistoryModel, String> DateId;
	@FXML
	private TableColumn<HistoryModel, String> TimeId;
	@FXML
	private TableColumn<HistoryModel, String> ClassId;

	

	static Customer c = new Customer();
	static String user_name = c.gettxtUsername();
	
	
	final ObservableList<String> FromL = FXCollections.observableArrayList(
			"Chicago", "New York", "Seattle", "Orlando", "Dallas", "California" );
	final ObservableList<String> ToL = FXCollections.observableArrayList(
			"Chicago", "New York", "Seattle", "Orlando", "Dallas", "California" );
	final ObservableList<String> ClassL = FXCollections.observableArrayList(
			"Economy", "Business", "First Class" );
	
	public void initialize(URL location, ResourceBundle resources)
	
	{
		
		//System.out.println(user_name);
		// Code for tblFlights table view
		fromId.setCellValueFactory(new PropertyValueFactory<FlightsModel, String>("fromId"));
		toId.setCellValueFactory(new PropertyValueFactory<FlightsModel, String>("toId"));
		dateId.setCellValueFactory(new PropertyValueFactory<FlightsModel, String>("dateId"));
		timeId.setCellValueFactory(new PropertyValueFactory<FlightsModel, String>("timeId"));
		classId.setCellValueFactory(new PropertyValueFactory<FlightsModel, String>("classId"));
		priceId.setCellValueFactory(new PropertyValueFactory<FlightsModel, String>("priceId"));

		// auto adjust width of columns depending on their content
		tblFlights.setColumnResizePolicy((param) -> true);
		Platform.runLater(() -> customResize(tblFlights));

		tblFlights.setVisible(false); // set invisible initially
		
		// Set the initial values for observable lists
		System.out.println("Set the values");
		From.setItems(FromL);
		From.setValue("Chicago");
		To.setItems(ToL);
		To.setValue("Orlando");
		Class.setItems(ClassL);
		Class.setValue("Economy");
		
		// Code for tblHistory table view
		FromId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("FromId"));
		ToId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("ToId"));
		DateId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("DateId"));
		TimeId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("TimeId"));
		ClassId.setCellValueFactory(new PropertyValueFactory<HistoryModel, String>("ClassId"));


		// auto adjust width of columns depending on their content
		tblHistory.setColumnResizePolicy((param) -> true);
		Platform.runLater(() -> customResize(tblHistory));
		tblHistory.setVisible(false); // set invisible initially
	}
	
    public void customResize(TableView<?> view) 
    {

        AtomicLong width = new AtomicLong();
        view.getColumns().forEach(col -> {
            width.addAndGet((long) col.getWidth());
        });
        double tableWidth = view.getWidth();

        if (tableWidth > width.get()) {
            view.getColumns().forEach(col -> {
                col.setPrefWidth(col.getWidth()+((tableWidth-width.get())/view.getColumns().size()));
            });
        }
    }
	
	
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
		pane5.setVisible(false);
	}
	
	public void addadminuser() {
		pane4.setVisible(false);
		pane3.setVisible(false);
		pane2.setVisible(true);
		pane1.setVisible(false);
		pane5.setVisible(false);
	}
 
	
	public void viewprofile() {
		pane4.setVisible(false);
		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(true);
		pane5.setVisible(false);
		
		
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
		pane5.setVisible(false);
		
		// Create data access instance for History data access object
		AdminHistoryDao AH1 = new AdminHistoryDao();
		
		try
		{
			tblHistory.getItems().setAll(AH1.getHistory());
			if(tblHistory.getItems().isEmpty())
			{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert Message");
				alert.setHeaderText("History Info");
				alert.setContentText("No Ticket History");
				alert.showAndWait();
			}
			else	
			tblHistory.setVisible(true);
		}
		catch (Exception e)
		{
			System.out.println("Error while printing ticket hisrory " + e.getMessage());
		}
	}
	
	
	@FXML
	public void click2(MouseEvent event)
	{
	    if (event.getClickCount() == 2) //Checking double click
	    {
	    	//bookBtn.setDisable(false);
	    	System.out.println("Fetching data from the view");
	        System.out.println(tblHistory.getSelectionModel().getSelectedItem().getFromId());
	        System.out.println(tblHistory.getSelectionModel().getSelectedItem().getToId());
	        System.out.println(tblHistory.getSelectionModel().getSelectedItem().getDateId());
	        System.out.println(tblHistory.getSelectionModel().getSelectedItem().getTimeId());
	        System.out.println(tblHistory.getSelectionModel().getSelectedItem().getClassId());

	    }
	}
	
	public void delete()
	{
		pane4.setVisible(false);
		pane3.setVisible(true);
		pane2.setVisible(false);
		pane1.setVisible(false);
		pane5.setVisible(false);
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

	public void search() 
	
	{
		
		pane5.setVisible(true);
		
		String F_FROM = this.From.getValue();
		String F_TO = this.To.getValue();
		LocalDate F_DATE = this.Date.getValue();
		String F_CLASS = this.Class.getValue();
		
		
		// Create data access instance for Flights object
		FlightsDao F1 = new FlightsDao();
		
		try
		{
			tblFlights.getItems().setAll(F1.getFlights(F_FROM, F_TO, F_DATE, F_CLASS));
			if(tblFlights.getItems().isEmpty())
			{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Alert Message");
				alert.setHeaderText("Flights Info");
				alert.setContentText("No flights available for the search");
				alert.showAndWait();
			}
			else
			tblFlights.setVisible(true);
		}
		catch (Exception e)
		{
			System.out.println("No flights available for the search" +e.getMessage());
		}
		
	}
	
	@FXML
	public void click1(MouseEvent event)
	{
	    if (event.getClickCount() == 2) //Checking double click
	    {
	    	//bookBtn.setDisable(false);
	    	System.out.println("Fetching data from the view");
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getFromId());
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getToId());
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getDateId());
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getTimeId());
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getClassId());
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getPriceId());

	    }
	}


}