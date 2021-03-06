package application;
	
import java.io.IOException;
import java.util.GregorianCalendar;

import controller.AddPersonController;
import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

import model.AVL_Tree;
import model.Node;
import model.PeopleBase;
import model.Person;


public class Main extends Application {
	private Stage currentStage = new Stage();
	public static PeopleBase base;
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Menu.fxml"));
			root = (BorderPane)loader.load();
			MenuController mainMenuController = loader.getController();
			mainMenuController.setMain(this);
			
			Scene scene = new Scene(root);
			currentStage.setScene(scene);
			currentStage.setHeight(600);
			currentStage.setWidth(800);
			currentStage.show();			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void showAddPerson() {
		BorderPane addPerson;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/AddPerson.fxml"));
			addPerson = (BorderPane)loader.load();
			AddPersonController addPersonController = loader.getController();
			addPersonController.setMain(this);
			
			
			BorderPane root;
			Stage stage = currentStage;
			root = (BorderPane)stage.getScene().getRoot();
			root.setCenter(addPerson);
			stage.setWidth(750);
			stage.setHeight(600);
			stage.show();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void importRandPeople() {
		base.importData();
	}
	
	public void addPerson(String n, String sn, String country, GregorianCalendar dob,int gender) {
		base.addPerson(n, sn, country, dob,gender);
	}
	
	public static void main(String[] args) {
		base=new PeopleBase();
		base.inputData();
		launch(args);	
		base.outputData();
	}
}
