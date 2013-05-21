/**
 * Author: Jon W
 * Creation Date: 03/04/2013
 * Title: Pong
 * 
 * Primary Class
 * Handles game loop and class calls
 * 
 * */

package Pong;

public class Primary{
  
  //Create Program Constants
  private static final int WINDOWWIDTH = 700;
  private static final int WINDOWHEIGHT = 500;
  private static final int PADDLEWIDTH = 10;
  private static final int PADDLEHEIGHT = 50;
  private static final int BALLXRADIUS = 20;
  private static final int BALLYRADIUS = 20;
  private static final int BALLXSPEED = 5;
  private static final int BALLYSPEED = 1;
  
  public static void main(String[] args){
    boolean isHard = true;
    int topBarrier = 0;
    int bottomBarrier = 0;

    if (isHard == false) {
     topBarrier = - 10;
     bottomBarrier = WINDOWHEIGHT + 50;
    } else {
      topBarrier = 20;
      bottomBarrier = WINDOWHEIGHT - 50;
    }


    //Initialize Window
    GameWindow gameWindow = new GameWindow(WINDOWWIDTH, WINDOWHEIGHT, PADDLEWIDTH, PADDLEHEIGHT, BALLXRADIUS, BALLYRADIUS, BALLXSPEED, BALLYSPEED, topBarrier, bottomBarrier);
    
    //Create Objects
    GameLoopTimer gameLoopTimer = new GameLoopTimer();
    
    //Method Variables
    boolean exit = false;
    
    while(exit == false){
      exit = gameWindow.isExit();
      gameWindow.changePlayerPaddleDirection();
      gameWindow.changePCPaddleDirection();
      gameWindow.changeBallDirection(); // Handles collision detection
      gameLoopTimer.runTimer();
    }
    System.exit(0);
  }
}