package com.example.mobileapp_lab03.graphic;


import android.app.Activity;
import android.os.Bundle;

public class Graphics extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraphicsView view = new GraphicsView(this);
        setContentView(view);
    }
}
