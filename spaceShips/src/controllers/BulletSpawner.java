package controllers;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class BulletSpawner extends AnimationTimer {
	
	public int interval, spawnInterval = 30;
	public Levels lvl;
	public ArrayList<Rectangle> enemies;
	public AnchorPane pane;
	
	public BulletSpawner(Levels l, ArrayList<Rectangle> e, AnchorPane p) {
		lvl = l;
		enemies = e;
		pane = p;
	}

	@Override
	public void handle(long arg0) {
		
		if (interval >= spawnInterval) {
			interval = 0;
			lvl.createBullets(enemies);
		}
		interval ++;
	}

}
