package controllers;

import javafx.scene.control.CheckBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class todolistcontroller extends todolist {
	
	// TODO Add visibility controllers.
	
	@FXML
	TitledPane titledpane;
	
	@FXML
	AnchorPane anchor;
	
	@FXML
	VBox outervbox;
	
	@FXML
	VBox innervbox;
	
	@FXML
	Button add;
	
	@FXML
	Button remove;
	
	// TODO Only call once
	public void initialise() {
		titledpane.getStylesheets().add(getClass().getResource("../resources/style.css").toExternalForm());
		innervbox.setPrefHeight(0);
	}
	
	// TODO Add limit on number of checkboxes you can have - create popup alerts
	
	private void newCheckbox() {
		CheckBox x = new CheckBox("new checkbox");
		x.setPrefSize(200, 20);
		innervbox.getChildren().addLast(x);
	}
	
	// TODO open new page to customise name, if cancelled do not create new object
	
	@FXML
	private void clickedadd() {
				
		innervbox.setPrefHeight(innervbox.getPrefHeight() + 23);
		newCheckbox();		

	}
	
}
