package controllers;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class todolist extends Application {
	
 
	@Override
	public void start(Stage primarystage) {
		
		try {
			FXMLLoader load = new FXMLLoader(getClass().getResource("../resources/todolistpage.fxml"));
			todolistcontroller controls = load.getController();
			Parent root = load.load();
			controls.initialise();
			primarystage.setScene(new Scene(root));
			primarystage.show();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
