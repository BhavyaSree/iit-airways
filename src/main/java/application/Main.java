/*
 * Main class to launch the Illinois Tech Airways application
 * @Author: BhavyaSree Bindela
 * @FileName : Main.Java
 * 
 */

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application 
{
	public static Stage stage;
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			stage = primaryStage;
			// Load the UI elements
			//AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/HomeView.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/HomeView.fxml"));
			AnchorPane root =  (AnchorPane) loader.load();
			// Scren layout
			Scene scene = new Scene(root,800,600);
			// Screen Title
			stage.setTitle("Illinois Tech Airways");
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
		} 
		catch(Exception e) 
		{
			System.out.println("Error occured while inflating Home view: " + e);
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
