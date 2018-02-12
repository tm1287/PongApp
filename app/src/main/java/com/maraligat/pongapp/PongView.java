package com.maraligat.pongapp;

import android.content.Context;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Tejas Maraliga on 2/12/2018.
 */

public class PongView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder;

    //thread vars
    private PongThread pongThread;


    public PongView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        this.setFocusable(true);

        //create new thread over here
        this.pongThread = new PongThread(surfaceHolder);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg){

        return pongThread.getPongGame().keyPressed(keyCode);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        pongThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
