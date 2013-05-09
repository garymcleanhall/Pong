/**
 * Author: Jon W
 * Creation Date: 03/04/2013
 * Title: Pong
 * 
 * Timer Class
 *
 * */

package Pong;

public class GameLoopTimer{
  
  private long startTime;
  private long checkTime;
  
  public GameLoopTimer(){
    startTime = System.nanoTime();
    checkTime = 0;
  }
  
  public void runTimer(){
    startTime = System.nanoTime();
    checkTime = startTime;
    while (checkTime < (startTime + 16666666))
      checkTime = System.nanoTime();
  }
}