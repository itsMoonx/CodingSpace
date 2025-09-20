package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StagePanel extends Application {
	
	protected static Stage stage;
		
	@FXML
	public Button confirm;
	
	@FXML
	public Button withdraw;
	
	@FXML
	public Button balance;
	
	@FXML
	public Button deposit;
	
	@FXML
	public Label label;

	@Override
	public void start(Stage primarystage) throws Exception {
		try {
		Parent root = FXMLLoader.load(getClass().getResource("../resources/banking.fxml"));
		Scene scene = new Scene(root);
		primarystage.setScene(scene);
		primarystage.show();
		stage = primarystage;
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
