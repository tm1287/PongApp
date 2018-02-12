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


    public PongView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        this.setFocusable(true);
        //create new thread over here
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg){
        //insert call to game thread here
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //start game thread here

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
