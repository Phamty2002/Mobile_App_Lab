package com.example.excercise4.graphics;

import android.app.Activity;
import android.os.Bundle;
import android.media.MediaPlayer;

public class Graphics extends Activity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraphicsView view = new GraphicsView(this);
        setContentView(view);

        // Initialize and start playing music
        mediaPlayer = MediaPlayer.create(this, R.raw.gangnam_style);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Release media player resources
            mediaPlayer = null;
        }
    }
}
