
package Pong;

import java.awt.Graphics;
import java.awt.Color;

public class BallDrawable implements Drawable {

	public BallDrawable(Ball ball) {
		this.ball = ball;
	}

	public void Draw(Graphics context) {
		context.setColor(Color.YELLOW);
		context.fillOval(ball.getXPosition(), ball.getYPosition(), ball.getXRadius(), ball.getYRadius());
	}	
	
	private static Color color = Color.YELLOW; // you could make this a constructor parameter to hav different colored balls.
	private Ball ball;
}