package controllers;

import java.util.ArrayList;
import java.util.Optional;

import application.Main;
import dao.DBConnect;
import dao.ViewCustomerDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import models.Customer;


public class UserController extends DBConnect
{

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
	private TextField txtAdress;
	@FXML
	private TextField txtCity;
	@FXML
	private TextField txtState;
	@FXML
	private TextField txtZipcode;
	@FXML
	private DatePicker txtDob; 
	
	static Customer c = new Customer();
	static String user_name = c.gettxtUsername();
	
	DBConnect connection = new DBConnect();
		
	public void viewprofile() 
	{
		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(true);
		
		System.out.println(user_name);
		
		// Create a DAO instance of the model
		ViewCustomerDao customerDao = new ViewCustomerDao();
		ArrayList<Customer> arrayList = customerDao.getCustomer(user_name);
		
		for (Customer customer : arrayList) 
		{
			System.out.println("setting the values");
			txtLname.setText(customer.gettxtLname());
			txtFname.setText(customer.gettxtFname());
			txtDob.setValue(customer.gettxtDob());
			txtEmail.setText(customer.gettxtEmail());
			txtPhone.setText(Long.toString(customer.gettxtPhone()));
			txtAdress.setText(customer.gettxtAddress());
			txtCity.setText(customer.gettxtCity());
			txtState.setText(customer.gettxtState());
			txtZipcode.setText(customer.gettxtZipcode());

		}		

	}
	
	public void logout() 
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank you Message");
		alert.setHeaderText("Illinois Tech Airways");
		alert.setContentText("Thank you for choosing us! Please visit again!");
		alert.showAndWait();
		try 
		{
			 AnchorPane root = (AnchorPane) 
			 FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
			 Scene scene = new Scene(root,800,600);
		     Main.stage.setScene(scene);
		     Main.stage.setTitle("Illinois Tech Airways Home Page");
		     System.out.println("Launched Illinois Tech Airways Home Screen");
		     Main.stage.show();
		 } 
		catch (Exception e)
		{
		     System.out.println("Error in inflating view: " + e.getMessage());
		}
	}

	public static void setUsername(String username) 
	{
		user_name = username;
		System.out.println("Welcome User: " + user_name+"!");
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
	
	public void search() {}
	public void update() {}
	
	
	
	
	
	
	
	
	
	
	
	public void book() 
	{
		TextInputDialog dialog = new TextInputDialog("16 digit number");
		dialog.setTitle("Payment Details");
		dialog.setHeaderText("Debit/Credit Card");
		dialog.setContentText("Please enter your card number");

		Optional<String> cardno = dialog.showAndWait();
		if (cardno.isPresent()) 
		{
			String cardnumber = cardno.get();
			System.out.println("Card number entered: "+ cardnumber);
		}
		try 
		{
			 AnchorPane root = (AnchorPane) 
			 FXMLLoader.load(getClass().getResource("/views/TicketView.fxml"));
			 System.out.println("Launched TicketDeatils Screen");
			 Scene scene = new Scene(root,800,600);
		     Main.stage.setScene(scene);
		     Main.stage.setTitle("Ticket Details");
		     Main.stage.show();
	    } 
		catch (Exception e) 
		{
		System.out.println("Error in inflating view: " + e.getMessage());
	    }
		
	}
	
}
