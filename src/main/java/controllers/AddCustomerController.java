package controllers;


import java.io.IOException;
import java.time.LocalDate;

import application.Main;
import dao.CustomerDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import models.Customer;
import models.User;

public class AddCustomerController 
{
	@FXML
	private TextField txtLname;

	@FXML
	private TextField txtFname;

	@FXML
	private DatePicker dob;

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
	private TextField txtUname;
	
	@FXML
	private TextField txtPassword;
	
	// Method to submit the data to database
	public void submit() 
	{
		// Extract the data from the text fields of view
		String LNAME = this.txtLname.getText();
		if (LNAME == null || LNAME.trim().equals("")) 
		{
			return;
		}
				
		String FNAME = this.txtFname.getText();
		if (FNAME == null || FNAME.trim().equals("")) 
		{
			return;
		}	
				
		LocalDate DOB = this.dob.getValue();
		if (DOB == null) 
		{
			return;
		}

		String EMAIL = this.txtEmail.getText();
		if (EMAIL == null || EMAIL.trim().equals("")) 
		{
			return;
		}
		
		String PHONE = this.txtPhone.getText();
		if (PHONE == null || PHONE.trim().equals("")) 
		{
			return;
		}
		
		String ADDRESS = this.txtAddress.getText();
		if (ADDRESS == null || ADDRESS.trim().equals("")) 
		{
			return;
		}
		
		String CITY = this.txtCity.getText();
		if (CITY == null || CITY.trim().equals("")) 
		{
			return;
		}
		
		String STATE = this.txtState.getText();
		if (STATE == null || STATE.trim().equals("")) 
		{
			return;
		}
		
		String ZIPCODE = this.txtZipcode.getText();
		if (ZIPCODE == null || ZIPCODE.trim().equals("")) 
		{
			return;
		}
		
		String UNAME = this.txtUname.getText();
		if (UNAME == null || UNAME.trim().equals("")) 
		{
			return;
		}
		
		String PASSWORD = this.txtPassword.getText();
		if (PASSWORD == null || PASSWORD.trim().equals("")) 
		{
			return;
		}
		
		// Create Customer Object
		Customer customer = new Customer();
		// Create User Object
		User user = new User();
		
		//Set the values from the view
		customer.setTxtLname(LNAME);
		customer.setTxtFname(FNAME);
		customer.setDob(DOB);
		customer.setTxtEmail(EMAIL);
		customer.setTxtPhone(Long.parseLong(PHONE));
		customer.setTxtAddress(ADDRESS);
		customer.setTxtCity(CITY);
		customer.setTxtState(STATE);
		customer.setTxtZipcode(ZIPCODE);
		user.setTxtUname(UNAME);
		user.setTxtPassword(PASSWORD);
		
		//Create data access instance for customer object
		CustomerDao C1  = new CustomerDao();
		C1.CreateDetails(customer);
		
		C1.CreateUser(user);
	}
	
	public void home() throws IOException
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HomeView.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
			Main.stage.setTitle("Home");
			System.out.println("Launched Home Screen");
		}
		catch(Exception e) 
		{
			System.out.println("Error occured while inflating Home view:" + e);
		}
		
	}
	
}
