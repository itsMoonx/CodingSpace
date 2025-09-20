package controllers;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import main.GamePanel;

public class Levels extends GamePanel {
	
	private Random rand = new Random();
	
	private Rectangle e;
	
	private Circle b;
	
	private int y = 177;
	
	private int speed = 5;
		
	public void setVisibility() { // Should be controlled by scene builder
		start.setVisible(false);
	}
	
	public void createEnemies(ArrayList<Rectangle> enemy, ArrayList<Rectangle> hit) {
		e = new Rectangle(30, 30);
		e.setFill(Color.web("#ed4b00"));
		e.setLayoutX(pane.getWidth());
		e.setLayoutY(rand.nextDouble(pane.getHeight()));
		pane.getChildren().add(e);
		enemy.add(e);
		new EnemyHandler(e, pane, player, hit).start();
	}
	
	public void createBullets(ArrayList<Rectangle> enemy) {
		b = new Circle(10);
		b.setLayoutX(91);
		b.setLayoutY(y);
		b.setStyle("-fx-fill: red;");
		pane.getChildren().add(b);
		new BulletHandler(b, pane.getWidth(), enemy, pane).start();
	}
	
	public void downY() {
		double yHeight = player.getLayoutY() + speed;
		player.setLayoutY(yHeight);
		y += speed;
	}
	
	public void upY() {
		double yHeight = player.getLayoutY() - speed;
		player.setLayoutY(yHeight);
		y -= speed;
	}
	
	public Double getBullet() {
		return b.getLayoutX();
	}
	
	public Double getEnemy() {
		return e.getLayoutX();
	}

}
