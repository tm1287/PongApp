package com.maraligat.pongapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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
}
