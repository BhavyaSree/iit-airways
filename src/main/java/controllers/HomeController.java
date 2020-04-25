/*
 * HomeController class to enable the user choose Login or signup
 * @Author: BhavyaSree Bindela
 * @FileName : HomeController.Java
 * 
 */

package controllers;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController 
{
	
	public void login() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
		setSceneMethod(Main.stage, loader);
		Main.stage.setTitle("Login");
		System.out.println("Launched Login Screen");
	}
	
	public void signup() throws IOException 
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/SignUpView.fxml"));
		setSceneMethod(Main.stage, loader);
		Main.stage.setTitle("SignUp");
		System.out.println("Launched SignUp Screen");
	}
	
	private void setSceneMethod(Stage primaryStage, FXMLLoader loader) throws IOException  
	{
		try 
		{
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
			Main.stage.show();
		}
		catch(Exception e) 
		{
			System.out.println("Error occured while inflating next view:" + e);
		}
		
	}
}
