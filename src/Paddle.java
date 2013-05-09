/**
 * Author: Jon W
 * Creation Date: 03/04/2013
 * Title: Pong
 * 
 * Paddle Class
 *
 * */

package Pong;

public class Paddle{
  
  //Class Variables
  private int xPosition;
  private int yPosition;
  private int paddleWidth;
  private int paddleHeight;
  private int windowHeight;
  
  public Paddle(int paddleWidth, int paddleHeight, int startXPosition, int startYPosition, int windowHeight){
    this.paddleWidth = paddleWidth;
    this.paddleHeight = paddleHeight;
    this.windowHeight = windowHeight;
    xPosition = startXPosition;
    yPosition = startYPosition;
    
  }
  
  public int getXPosition(){
    return xPosition;
  }
  
  public int getYPosition(){
    return yPosition;
  }
  
  public int getPaddleWidth(){
    return paddleWidth;
  }
  
  public int getPaddleHeight(){
    return paddleHeight;
  }
  
  public void resetYPosition(int yPosition){
    this.yPosition = yPosition;
  }
  
  public void setYPosition(int yPosition){
    this.yPosition += yPosition;
    if (this.yPosition < 0)
      this.yPosition = 0;
    if (this.yPosition > (windowHeight - (paddleHeight * 2)))
      this.yPosition = (windowHeight - (paddleHeight * 2));
  }
  
}