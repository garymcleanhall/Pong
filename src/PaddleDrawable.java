
package Pong;

import java.awt.Graphics;
import java.awt.Color;

public class PaddleDrawable implements Drawable {

	public PaddleDrawable(Paddle paddle) {
		this.paddle = paddle;
	}
	
	public void Draw(Graphics context) {
		context.setColor(color);
		context.fillRect(paddle.getXPosition(), paddle.getYPosition(), paddle.getPaddleWidth(), paddle.getPaddleHeight());
	}
	
	private static Color color = Color.RED;
	private Paddle paddle;
}