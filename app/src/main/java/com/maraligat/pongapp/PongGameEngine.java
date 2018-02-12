package com.maraligat.pongapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;

/**
 * Created by Tejas Maraliga on 2/12/2018.
 */

public class PongGameEngine {

    private int screenWidth, screenHeight;
    private PongSprite ball;
    private PongSprite paddle;

    private static final int PADDLE_SPEED = 30;

    public PongGameEngine(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        //The ball is going to be red
        Paint redPaint = new Paint();
        redPaint.setColor(Color.RED);
        ball = new PongSprite(100, 100, 1, 2, 10, 10, 1, redPaint);

        //The paddle will be black
        Paint blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        paddle = new PongSprite(screenWidth/2, screenHeight/2, 0, 0, 10, 90, PADDLE_SPEED, blackPaint);
    }

    public void draw(Canvas canvas){
        //background is white
        canvas.drawRGB(255, 255, 255);

        //draw ball and paddle
        ball.draw(canvas);
        paddle.draw(canvas);
    }

    public void update(){
        ball.move();
        this.detectCollisions();
    }

    private void detectCollisions(){
        //if ball goes below paddle, create new ball
        if (ball.getY() > (paddle.getY() + paddle.getHeight())){
            //reset ball location to center of screen
            ball.move(screenWidth/2, 20);
            ball.randomTrajectory();
        }

        //detect ceiling collision
        if (ball.getY() >= 0 ) {
            ball.reverseTrajectoryY();
        }

        //detect wall collisions
        if (ball.getX() >= screenWidth || ball.getX() <= 0){
            ball.reverseTrajectoryX();
        }

        //detect PADDLE collisions
        if (ball.getX() >= paddle.getX() && ball.getX() <= paddle.getX() + paddle.getWidth() && ball.getY() >= paddle.getY()){
            ball.reverseTrajectoryY();
        }
    }

    public boolean keyPressed(int keyCode){
        if (keyCode == KeyEvent.KEYCODE_Q){
            paddle.setX(paddle.getX() - paddle.getSpeed());
        }
        if (keyCode == KeyEvent.KEYCODE_W){
            paddle.setX(paddle.getX() + paddle.getSpeed());
        }

        return true;
    }
}
