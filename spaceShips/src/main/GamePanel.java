package main;

import java.util.ArrayList;

import controllers.BulletSpawner;
import controllers.EnemySpawner;
import controllers.Levels;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GamePanel extends Application {
	
	// fields should be with the controller
	
	@FXML
	protected Button start;
	
	@FXML
	protected AnchorPane pane;
	
	@FXML
	protected Rectangle player;
	
	protected BulletSpawner b;
	
	protected ArrayList<Rectangle> enemies = new ArrayList<>();
	
	public ArrayList<Rectangle> hitCounter = new ArrayList<>();
			
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/game.fxml"));
		
		Parent root = loader.load();
		
		// Controller
		
		Levels lvl = loader.getController();
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		b = new BulletSpawner(lvl, enemies, pane);

		// Functions
		
		lvl.start.setOnMouseClicked(e -> {
			lvl.setVisibility();
			new EnemySpawner(lvl, enemies, hitCounter).start();
		});
		
		// To do: make enemies and bullet connect - done by using shared arraylist
		
		// To do : Make the player click start before being able to move and shoot
		
		scene.setOnKeyPressed(e -> { // should be controlled by scenebuilder
			if (e.getCode() == KeyCode.ENTER) {
				b.start();
			}
			
			if (e.getCode() == KeyCode.W) {
				lvl.upY();
			}
			
			if (e.getCode() == KeyCode.S) {
				lvl.downY();
			}
		});
		
		scene.setOnKeyReleased(e -> { // should be controlled by scenebuilder
			if (e.getCode() == KeyCode.ENTER) {
				b.stop();
			}
		});
		
		primaryStage.show();
		
		root.requestFocus();
		
	}

}
