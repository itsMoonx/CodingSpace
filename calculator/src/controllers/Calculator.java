package controllers;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application {
	
	protected static Stage p;
	protected static String currentText;
	protected static Boolean controller = false;

	// static means you can access this without needing to create instance.
	// this variable belongs to one instance of the class, which everyone can access.
	// protected means only this class and subclasses can access this
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/calculatorMain.fxml"));
	        Parent root = loader.load();
	        primaryStage.setScene(new Scene(root));  // without specifying the x and y in the new Scene construct, it will compute scene to its content's pref sizes
	        primaryStage.setResizable(false);
	        CalculatorControls c = loader.getController();
	        currentText = "";
	        c.textLabel.setText(currentText);
	        primaryStage.show();
			p = primaryStage;
	
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}

}
