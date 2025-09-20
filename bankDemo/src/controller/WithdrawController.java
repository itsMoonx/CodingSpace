package controller;

import java.io.IOException;

import application.StagePanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class WithdrawController extends BankingController {
	
	Scene scene;
		
	@FXML
	private Label label;
	
	@FXML
	private Button increase;
	
	@FXML
	private Button decrease;
	
	private int number;

		
	public void confirmClicked(MouseEvent a) {
		Object n = StagePanel.stage.getUserData();
		
		if (n == null) {
			StagePanel.stage.setUserData(number);
		} else {
			int data = (int) n;
			StagePanel.stage.setUserData(data - number);
		}
	}
	
	public void depositClicked(MouseEvent a) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../resources/deposit.fxml"));
			setScene(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void balanceClicked(MouseEvent a) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/banking.fxml"));
			
			Parent root = loader.load();
			
			BankingController b = loader.getController();
			
			b.balance();
			
			setScene(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setScene(Parent root) {
		StagePanel.stage.close();
		scene = new Scene(root);
		StagePanel.stage.setScene(scene);
		StagePanel.stage.show();
	}
	
	public void increaseClicked(MouseEvent a) {
		number = number + 1;
		label.setText(Integer.toString(number));
	}
	
	public void decreaseClicked() {
		number = number - 1;
		label.setText(Integer.toString(number));
	}

}
