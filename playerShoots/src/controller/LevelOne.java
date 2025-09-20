package controller;

import java.io.IOException;

import application.GamePanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;

public class LevelOne extends GamePanel {
	
	@FXML
	public Button start;
	
	@FXML
	public Box player;
	
	@FXML
	public Circle bullet;
	
	public int speed = 3;
	
	Double window;
		
	@FXML
	public void KeyPressed(KeyEvent e) {
		if (e.getCode() == KeyCode.S) {
			System.out.print("Clicked Shoot");
			
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../resources/level1.fxml"));
				window = root.getScene().getWidth();
				updateX();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
	}
	
	public void updateX() {
		while (!(bullet.getLayoutX() >= window)) {
			bullet.setLayoutX(speed + bullet.getLayoutX());
		}
	}

}
