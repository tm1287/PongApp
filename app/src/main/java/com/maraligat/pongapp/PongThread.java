package com.maraligat.pongapp;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Created by Tejas Maraliga on 2/12/2018.
 */

public class PongThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private PongGameEngine pongGame;
    private Canvas canvas;

    public PongThread(SurfaceHolder surfaceHolder) {
        super();
        this.surfaceHolder = surfaceHolder;
    }

    public PongGameEngine getPongGame() {
        return pongGame;
    }

    @Override
    public void run() {
        Log.v("Starting Pong Game", " ");
        this.canvas = this.surfaceHolder.lockCanvas();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        this.surfaceHolder.unlockCanvasAndPost(canvas);
        pongGame = new PongGameEngine(height, width);

        //Dont worry, loop is running in seperate thread
        while (true) {
            this.canvas = this.surfaceHolder.lockCanvas();
            this.pongGame.update();
            this.pongGame.draw(canvas);
            this.surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
