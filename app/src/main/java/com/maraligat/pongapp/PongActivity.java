package com.maraligat.pongapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Tejas Maraliga
 */

public class PongActivity extends AppCompatActivity {
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.view = new PongView(this);
        setContentView(view);
    }
}
