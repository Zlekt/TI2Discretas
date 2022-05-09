package controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AddPersonController {

	private Main main;
	@FXML
	TextField nameBox;
	@FXML
	TextField surNameBox;
	@FXML
	DatePicker dobPicker;
	@FXML
	TextField countryField;
	@FXML
	RadioButton femradB;
	@FXML
	RadioButton manradB;
	

	public void setMain(Main main) {
		this.main=main;
	}
	
	@FXML
	public void impData() {
		main.importRandPeople();
	}
	
	@FXML
	public void addPerson() {
		int gender=0;
		String name=nameBox.getText();
		String surName=surNameBox.getText();
		LocalDate bd=dobPicker.getValue();
		String country=countryField.getText();
		GregorianCalendar dob = GregorianCalendar.from(bd.atStartOfDay(ZoneId.systemDefault()));
		if (manradB.isSelected()) {
			gender=0;
		}else {
			gender=1;
		}
		manradB.setSelected(false);
		femradB.setSelected(false);
		nameBox.clear();
		surNameBox.clear();
		dobPicker.setValue(null);
		countryField.clear();
		main.addPerson(name, surName, country, dob,gender);
	}
}
