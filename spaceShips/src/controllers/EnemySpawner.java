package controllers;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

public class EnemySpawner extends AnimationTimer {
	
	Levels lvl;
	public int Interval, SpawnInterval = 30;
	public ArrayList<Rectangle> enemies;
	public ArrayList<Rectangle> h;

	
	public EnemySpawner(Levels control, ArrayList<Rectangle> e, ArrayList<Rectangle> hit) {
		lvl = control;
		enemies = e;
		h = hit;
	}
	

	@Override
	public void handle(long now) {
		
	    if (Interval >= SpawnInterval) {
	        lvl.createEnemies(enemies, h);
	        Interval = 0;
	    }
	    
	    Interval++;
	    
	}
	
	// To do: be able to adjust number of enemies based on levels

}
