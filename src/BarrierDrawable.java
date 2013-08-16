
package Pong;

import java.awt.Graphics;
import java.awt.Color;

public class BarrierDrawable implements Drawable {

	public BarrierDrawable(int length, int positionY) {
		this.length = length;
		this.positionY = positionY;
	}
	
	public void Draw(Graphics context) {
		context.setColor(color);
		context.drawLine(0, positionY, length, positionY);		
	}

	private int length, positionY;
	private Color color = Color.RED;
}