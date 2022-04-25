package controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {
	
	private Main main;
	
	@FXML
	Button addPersonButton;
	
	public void setMain(Main main) {
		this.main=main;
	}
	
	@FXML
	public void addPerson() {
		main.showAddPerson();
	}
	
}
