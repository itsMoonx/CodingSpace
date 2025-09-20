package controllers;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BulletHandler extends AnimationTimer {
	
	Circle bullet;
	Double width;
	ArrayList<Rectangle> enemies;
	AnchorPane pane;

	public BulletHandler(Circle b, Double w, ArrayList<Rectangle> e, AnchorPane p) {
		bullet = b;
		width = w;
		enemies = e;
		pane = p;
	}
	
	@Override
	public void handle(long arg0) {
		
		bullet.setLayoutX(bullet.getLayoutX() + 5);
		
		if (bullet.getLayoutX() > width + bullet.getRadius()) {
			pane.getChildren().remove(bullet);
			stop();
		}
		
		
		for (int i = 0; i < enemies.size(); i++) {
			// used chatgpt for the condition check
			if (bullet.getBoundsInParent().intersects(enemies.get(i).getBoundsInParent())) {
				pane.getChildren().remove(enemies.get(i));
				pane.getChildren().remove(bullet);
				enemies.remove(i);
				stop();
			}
		}
		
	}
	

}
