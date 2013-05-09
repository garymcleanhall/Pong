/**
 * Author: Jon W
 * Creation Date: 03/04/2013
 * Title: Pong
 * 
 * GameWindow Class
 *
 * */

package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameWindow extends JPanel implements KeyListener{
  
  //Define Objects
  JFrame gameWindow;
  JPanel gamePanel;
  Paddle playerPaddle;
  Paddle pcPaddle;
  Ball ball;
  Random randY;
  
  //Class Variables
  private int windowWidth;
  private int windowHeight;
  private int paddleWidth;
  private int paddleHeight;
  private int ballXRadius;
  private int ballYRadius;
  private int ballXStart;
  private int ballYStart;
  private int userInput;
  private int moveDirection;
  private int ballXDirection;
  private int ballYDirection;
  private int originalBallYSpeed;
  private int playerStartXPosition;
  private int playerStartYPosition;
  private int pcStartXPosition; 
  private int pcStartYPosition; 

  
  public GameWindow(int windowWidth, int windowHeight, int paddleWidth, int paddleHeight, int ballXRadius, int ballYRadius, int ballXSpeed, int ballYSpeed){
    //Set Window
    gameWindow = new JFrame("Pong");
    this.windowWidth = windowWidth;
    this.windowHeight = windowHeight;
    gameWindow.setSize(this.windowWidth,this.windowHeight);
    gameWindow.setVisible(true);
    gameWindow.setLocationRelativeTo(null);
    gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameWindow.addKeyListener(this);
    gameWindow.add(this);
    
    //Set Paddles
    this.paddleWidth = paddleWidth;
    this.paddleHeight = paddleHeight;
    playerStartXPosition = paddleWidth * 2;
    playerStartYPosition = this.windowHeight/2;
    pcStartXPosition = this.windowWidth - (paddleWidth * 4);
    pcStartYPosition = this.windowHeight/2;
    
    //Set Ball
    ballXStart = this.windowWidth / 2;
    ballYStart = this.windowHeight / 2;
    ballXDirection = ballXSpeed;
    ballYDirection = ballYSpeed;
    originalBallYSpeed = ballYSpeed;
      
    //Create Paddles
    playerPaddle = new Paddle(paddleWidth, paddleHeight, playerStartXPosition, playerStartYPosition, this.windowHeight);
    pcPaddle = new Paddle(paddleWidth, paddleHeight, pcStartXPosition, pcStartYPosition, this.windowHeight);
    
    //Create Ball
    ball = new Ball(ballXStart, ballYStart, ballXRadius, ballYRadius, this.windowWidth, this.windowHeight);
    
    //Set Other variables
    userInput = 0;
    moveDirection = 0;
    randY = new Random();
    
    validate();
  }
  
  public void paint(Graphics g){
    super.paint(g);
    //Paint Background
    g.setColor(Color.BLACK);
    g.fillRect(0,0,windowWidth,windowHeight);
    
    //Paint Paddles
    g.setColor(Color.RED);
    g.fillRect(playerPaddle.getXPosition(), playerPaddle.getYPosition(), playerPaddle.getPaddleWidth(), playerPaddle.getPaddleHeight());
    g.fillRect(pcPaddle.getXPosition(), pcPaddle.getYPosition(), pcPaddle.getPaddleWidth(), pcPaddle.getPaddleHeight());
    
    //Paint Ball
    g.setColor(Color.YELLOW);
    g.fillOval(ball.getXPosition(), ball.getYPosition(), ball.getXRadius(), ball.getYRadius());
    
    repaint();
  }
  

  public void changePlayerPaddleDirection(){
    if (userInput == 38)
      moveDirection = -3;
    if (userInput == 40)
      moveDirection = 3;
    if (userInput == 0)
      moveDirection = 0;
    playerPaddle.setYPosition(moveDirection);
  }
  
  public void changePCPaddleDirection(){
    if (pcPaddle.getYPosition()  > ball.getYPosition()){
      pcPaddle.resetYPosition(pcPaddle.getYPosition() - 3);
    } else if (pcPaddle.getYPosition() + (pcPaddle.getPaddleHeight() / 2) < ball.getYPosition()){
      pcPaddle.resetYPosition(pcPaddle.getYPosition() + 3);
    } else {
      pcPaddle.setYPosition(ballYDirection);
    }
  }
  
  public void changeBallDirectionEasy(){
    //Player paddle collision detection
    if (ball.getXPosition() == playerPaddle.getXPosition() && (ball.getYPosition() + ball.getYRadius())> playerPaddle.getYPosition() && 
        ball.getYPosition() < (playerPaddle.getYPosition() + playerPaddle.getPaddleHeight())){
      ballXDirection = -1 * ballXDirection;
      if (ballYDirection > (originalBallYSpeed + 5) ||  ballYDirection < (( -1 * originalBallYSpeed) - 5))
        ballYDirection = -1 * originalBallYSpeed;
      else
        ballYDirection = -1 * (ballYDirection + randY.nextInt(3));
    }
    
    //Pc paddle collision detection
    if ((ball.getXPosition() + ball.getXRadius()) == pcPaddle.getXPosition() && (ball.getYPosition() + ball.getYRadius()) > pcPaddle.getYPosition() && 
        ball.getYPosition() < (pcPaddle.getYPosition() + pcPaddle.getPaddleHeight())){
      ballXDirection = -1 * ballXDirection;
      if (ballYDirection > (originalBallYSpeed + 5) ||  ballYDirection < (( -1 * originalBallYSpeed) - 5))
        ballYDirection = -1 * originalBallYSpeed;
      else
        ballYDirection = -1 * (ballYDirection + randY.nextInt(3));
    }
    
    //Wall collision detection detection
    if (ball.isBallGreaterThanWindowWidth() == true)
      ballXDirection = -1 * ballXDirection;
    if (ball.isBallLessThanWindowWidth() == true)
      ballXDirection = -1 * ballXDirection; 
    if (ball.isBallGreaterThanWindowHeight() == true)
      ballYDirection = -1 * (ballYDirection + randY.nextInt(3));
    if (ball.isBallLessThanWindowHeight() == true)
      ballYDirection = -1 * (ballYDirection + randY.nextInt(3)); 
    
    ball.setXPosition(ballXDirection);
    ball.setYPosition(ballYDirection);
  }
  
  public void changeBallDirectionHard(){
    //Player paddle collision detection
    if (ball.getXPosition() > playerPaddle.getXPosition() && ball.getXPosition() < (playerPaddle.getXPosition() + playerPaddle.getPaddleWidth() - 1) &&  
        (ball.getYPosition() + ball.getYRadius())> playerPaddle.getYPosition() && ball.getYPosition() < (playerPaddle.getYPosition() + playerPaddle.getPaddleHeight())){
      ballXDirection = -1 * ballXDirection;
      if (ballYDirection > (originalBallYSpeed + 5) ||  ballYDirection < (( -1 * originalBallYSpeed) - 5))
        ballYDirection = -1 * originalBallYSpeed;
      else
        ballYDirection = -1 * (ballYDirection + randY.nextInt(3));
    }
    
    //Pc paddle collision detection
    if ((ball.getXPosition() + ball.getXRadius()) > pcPaddle.getXPosition() && (ball.getXPosition() + ball.getXRadius()) < (pcPaddle.getXPosition() + (pcPaddle.getPaddleWidth() - 1)) && 
        (ball.getYPosition() + ball.getYRadius()) > pcPaddle.getYPosition() && ball.getYPosition() < (pcPaddle.getYPosition() + pcPaddle.getPaddleHeight())){
      ballXDirection = -1 * ballXDirection;
      if (ballYDirection > (originalBallYSpeed + 5) ||  ballYDirection < (( -1 * originalBallYSpeed) - 5))
        ballYDirection = -1 * originalBallYSpeed;
      else
        ballYDirection = -1 * (ballYDirection + randY.nextInt(3));
    }
      
    //Wall collision detection detection
    if (ball.isBallGreaterThanWindowWidth() == true)
      ball.resetXPosition(1);
    if (ball.isBallLessThanWindowWidth() == true)
      ball.resetXPosition(windowWidth - ballXRadius - 25); 
    if (ball.isBallGreaterThanWindowHeight() == true)
      ball.resetYPosition(1);
    if (ball.isBallLessThanWindowHeight() == true)
      ball.resetYPosition(windowHeight - ballXRadius - 60 ); 

    ball.setXPosition(ballXDirection);
    ball.setYPosition(ballYDirection);
  }
  
  public boolean isExit(){
    if (userInput == 27)
      return true;
    else
      return false;
  }
  
    public void keyReleased(KeyEvent e){
    userInput = 0;
  }
  
  public void keyTyped(KeyEvent e){
    //userInput = e.getKeyCode();
  }
  
  public void keyPressed(KeyEvent e){
    userInput = e.getKeyCode();
  }
  
}