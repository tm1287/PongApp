package com.maraligat.pongapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by Tejas Maraliga on 2/12/2018.
 */

public class PongSprite {

    //Define properties for each instance of sprites that are created
    private static final Random RG = new Random();
    private static final int MAX_RANDOM = 5;

    private int x,y;
    private int trajectory_x, trajectory_y;
    private int height, width;
    private int speed;
    private Paint paint;

    //Constructor
    public PongSprite(int x, int y, int trajectory_x, int trajectory_y, int height, int width, int speed, Paint paint) {
        this.x = x;
        this.y = y;
        this.trajectory_x = trajectory_x;
        this.trajectory_y = trajectory_y;
        this.height = height;
        this.width = width;
        this.speed = speed;
        this.paint = paint;
    }

    //Method to draw sprites
    public void draw(Canvas canvas){
        canvas.drawRect(new Rect(this.x, this.y, this.x + width, this.y + height), this.paint);
    }

    //Method to automatically move sprites
    public void move(){
        this.x += (this.trajectory_x*speed);
        this.y += (this.trajectory_x*speed);
    }

    //Method to allow user to place sprite
    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Reverse trajectory methods
    public void reverseTrajectoryX(){
        this.trajectory_x *= -1;
    }

    public void reverseTrajectoryY(){
        this.trajectory_y *= -1;
    }

    //Random trajectory method
    public void randomTrajectory(){
        this.trajectory_x = RG.nextInt(MAX_RANDOM);
        this.trajectory_y = RG.nextInt(MAX_RANDOM);

    }

    //Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    //++++++++++++++++++++++++++++++
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    //++++++++++++++++++++++++++++++
    public int getTrajectory_x() {
        return trajectory_x;
    }

    public void setTrajectory_x(int trajectory_x) {
        this.trajectory_x = trajectory_x;
    }
    //++++++++++++++++++++++++++++++
    public int getTrajectory_y() {
        return trajectory_y;
    }

    public void setTrajectory_y(int trajectory_y) {
        this.trajectory_y = trajectory_y;
    }
    //++++++++++++++++++++++++++++++
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    //++++++++++++++++++++++++++++++
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    //++++++++++++++++++++++++++++++
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //++++++++++++++++++++++++++++++
}
