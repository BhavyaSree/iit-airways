package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import application.Main;
import dao.CustomerViewDao;
import dao.FlightsDao;
import dao.HistoryDao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Customer;
import models.FlightsModel;
import models.HistoryModel;

import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;
import java.net.URL;


public class UserController implements Initializable {

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
	//@FXML
	//private Button bookBtn;
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
		System.out.println("Welcome User: " + user_name + "!");
	}

	public UserController() {

	}
	
	public void viewprofile() {
		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(true);
		pane4.setVisible(false);
		
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
		pane4.setVisible(false);
		
		
		// Create data access instance for History data access object
		HistoryDao H1 = new HistoryDao();
		
		try
		{
			tblHistory.getItems().setAll(H1.getHistory(user_name));
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

	public void bookticket() {
		pane3.setVisible(true);
		pane2.setVisible(false);
		pane1.setVisible(false);
		pane4.setVisible(false);
	}
	

	
	/*@FXML
	private void initialize() {
		From.setItems(FromL);
		From.setValue("Chicago");
		To.setItems(ToL);
		To.setValue("Orlando");
		Class.setItems(ClassL);
		Class.setValue("Economy");
	}
	*/
	
	public void search() 
	{
		pane4.setVisible(true);
		
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
	public void click(MouseEvent event)
	{
	    if (event.getClickCount() == 2) //Checking double click
	    {
	    	//bookBtn.setDisable(false);
	    	System.out.println("Fetching data from table");
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getFromId());
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getToId());
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getDateId());
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getTimeId());
	        System.out.println(tblFlights.getSelectionModel().getSelectedItem().getClassId());

	    }
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
		if (cardno.isPresent()) 
		{
			String cardnumber = cardno.get();
			System.out.println("Card number entered: " + cardnumber);
		}
		try 
		{			
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/TicketView.fxml"));
			System.out.println("Launched TicketDeatils Screen");
			Scene scene = new Scene(root, 800, 600);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Ticket Details");
			Main.stage.show();
			TicketController T1 = new TicketController();
			T1.display(user_name);
		} catch (Exception e) 
		{
			System.out.println("Error in inflating view: " + e.getMessage());
		}
		
		
	}

}
