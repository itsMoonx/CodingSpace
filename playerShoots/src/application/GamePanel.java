package application;

import java.io.IOException;

import controller.Time;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GamePanel extends Application {
	
	@FXML
	public Button start;
	
	@FXML
	public Rectangle player;
	
	@FXML
	public AnchorPane pane;
	
	double y = 177;
	
	int speed = 10;
		
	@Override
	public void start(Stage primaryStage) {
		
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/level1.fxml"));
		Parent root = loader.load();
        Scene scene = new Scene(root);
        GamePanel control = loader.getController();
		primaryStage.setScene(scene);
		primaryStage.show();
		
		double w = root.getScene().getWidth();
		double x = 91;		

		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				
				Circle c = new Circle(10);
				c.setLayoutX(x);
				c.setLayoutY(getY());
				c.setStyle("-fx-fill: red;");
				
				control.pane.getChildren().add(c); // it kept saying null before. I needed to remember to use controller.
							
				new Time(c, w).start(); // edits each circle independently
				
			}
			
			if (e.getCode() == KeyCode.W) {
				double yHeight = control.player.getLayoutY()- speed;
				control.player.setLayoutY(yHeight);
				upY();
				
			}
			
			if (e.getCode() == KeyCode.S) {
				double yHeight = control.player.getLayoutY()+ speed;
				control.player.setLayoutY(yHeight);
				downY();
			}
		});
		
		
		root.requestFocus();
		
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
	
	public double getY() {		
		return y;
	}
	
	public void downY() {
		y += speed;
	}
	
	public void upY() {
		y -= speed;
	}
	

}
