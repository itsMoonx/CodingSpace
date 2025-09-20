package controller;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import application.StagePanel;
import javafx.fxml.FXMLLoader;

public class BankingController extends StagePanel {
		
	Scene scene;
		
	public void depositClicked(MouseEvent a) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../resources/deposit.fxml"));
			scene = new Scene(root);
	        setScene();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void withdrawClicked(MouseEvent a) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../resources/withdraw.fxml"));
			scene = new Scene(root);
	        setScene();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setScene() {
		StagePanel.stage.close();
		StagePanel.stage.setScene(scene);
		StagePanel.stage.show();
	}
	
	public void balance() {
		int balance = (int) StagePanel.stage.getUserData();
		String b = Integer.toString(balance);
		label.setText(b);
	}


}