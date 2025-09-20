package controllers;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class EnemyHandler extends AnimationTimer {
	
	Rectangle enemy;
	AnchorPane pane;
	ArrayList<Rectangle> hitCounter;
	Rectangle player;
	int counter = 0;
	
	public EnemyHandler(Rectangle e, AnchorPane p, Rectangle player, ArrayList<Rectangle> hit) {
		enemy = e;
		pane = p;
		hitCounter = hit;
		this.player = player;
	}

	@Override
	public void handle(long arg0) {
		enemy.setLayoutX(enemy.getLayoutX() - 5);
		
		if (enemy.getLayoutX() < 0 - enemy.getWidth()) {
			pane.getChildren().remove(enemy);
			stop();
		}
		
		if (player.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
			pane.getChildren().remove(enemy);
			hitCounter.add(enemy);
			stop();
		}
		
		if (hitCounter.size() == 5) {
			pane.getChildren().remove(player);
			System.out.print("End of Game");
			stop(); // Switch to a new scene and call a method to end this.
		}

		
	}
	
	// To do : be able to adjust speed based on levels

}
