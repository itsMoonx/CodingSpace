package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Circle;

public class Time extends AnimationTimer {
	private double width;
	
	private final int speed = 5;
	
	private Circle ball;
	
	public Time(Circle ball, double w) {
		this.ball = ball;
		width = w;
	}

	@Override
	public void handle(long arg0) {
		ball.setLayoutX(setSpeed());
		
		if (ball.getLayoutX() > width + ball.getRadius()) {
			System.out.print("Stopped");
			stop();
		}
	}
	
	private double setSpeed() {
		return speed + ball.getLayoutX();
	}

}
