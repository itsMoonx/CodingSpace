package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorFunctionsControls extends Calculator {
	
	@FXML
	public Label textLabel2;
	
	@FXML
	Button back;
	
	@FXML
	Button plus;
	
	@FXML
	Button minus;
	
	@FXML
	Button multiply;
	
	// every selection automatically goes back to other page.
	
	@FXML
	private void handleplus() {
		changeScene("+");
	}
	
	
	@FXML
	private void handleminus() {
		changeScene("-");
	}
	
	@FXML
	private void handlemultiply() {
		changeScene("x");
	}
	
	
	@FXML
	private void handleback() {	
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/calculatorMain.fxml"));
			Parent root = loader.load();
			CalculatorControls c = loader.getController();
			p.close();
			p.setScene(new Scene(root));			
			c.textLabel.setText(Calculator.currentText);
			
			p.show();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void changeScene(String s) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/calculatorMain.fxml"));
			Parent root = loader.load();
			CalculatorControls c = loader.getController();
			p.close();
			p.setScene(new Scene(root));
			
			Calculator.currentText = Calculator.currentText + s ;
			
			if (Calculator.controller) {
				
				Calculator.currentText = s;
				Calculator.controller = false;
			
			}
						
			c.textLabel.setText(Calculator.currentText);
			
			p.show();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	

}
