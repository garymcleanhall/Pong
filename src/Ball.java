/**
 * Author: Jon W
 * Creation Date: 03/04/2013
 * Title: Pong
 * 
 * Ball Class
 *
 * */

package Pong;

public class Ball{
  
  //Class Variables
  private int xPosition;
  private int yPosition;
  private int xRadius;
  private int yRadius;
  private int windowWidth;
  private int windowHeight;
  
  public Ball(int startXPosition, int startYPosition, int xRadius, int yRadius, int windowWidth, int windowHeight){
    xPosition = startXPosition;
    yPosition = startYPosition;
    this.xRadius = xRadius;
    this.yRadius = yRadius;
    this.windowWidth = windowWidth;
    this.windowHeight = windowHeight;
  }
  
  public int getXPosition(){
    return xPosition;
  }
  
  public int getYPosition(){
    return yPosition;
  }
  
  public int getXRadius(){
    return xRadius;
  }
  
  public int getYRadius(){
    return yRadius;
  }
  
  public void setXPosition(int xPosition){
    this.xPosition += xPosition;
  }
  
  public void setYPosition(int yPosition){
    this.yPosition += yPosition;
  }
  
  public void resetXPosition(int xPosition){
    this.xPosition = xPosition;
  }
  
  public void resetYPosition(int yPosition){
    this.yPosition = yPosition;
  }  
  
  public boolean isBallGreaterThanWindowWidth(){
    if (xPosition > (windowWidth - (xRadius * 1.5)))
      return true;
    else 
      return false;
  }
  
  public boolean isBallLessThanWindowWidth(){
    if (xPosition < 0)
      return true;
    else 
      return false;
  }
  
  public boolean isBallGreaterThanWindowHeight(){
    if (yPosition > (windowHeight - (yRadius * 3)))
      return true;
    else 
      return false;
  }
  
  public boolean isBallLessThanWindowHeight(){
    if (yPosition < 0)
      return true;
    else 
      return false;
  }
}