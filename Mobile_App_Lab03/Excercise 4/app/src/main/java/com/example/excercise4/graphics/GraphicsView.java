package com.example.excercise4.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;

public class GraphicsView extends View {
    private Bitmap[] frames = new Bitmap[16]; // assuming 16 frames
    private int i = 0;
    private int x = 40; // Default X coordinate
    private int y = 40; // Default Y coordinate
    private final Handler handler = new Handler();
    private final Runnable updateRunnable = new Runnable() {
        @Override
        public void run() {
            // Update logic for automatic movement goes here
            // For example, moving the bitmap across the screen
            x += 5;
            if (x > getWidth() - frames[i].getWidth()) {
                x = 0; // Reset position to loop around the screen
            }
            // Update the frame index for the next bitmap
            i = (i + 1) % frames.length;
            invalidate(); // Request to redraw the view
            handler.postDelayed(this, 30); // Schedule for the next frame update
        }
    };

    // MediaPlayer to play music
    private MediaPlayer mediaPlayer;

    public GraphicsView(Context context) {
        super(context);
        // Initialize each frame of the animation
        for (int j = 0; j < frames.length; j++) {
            int resourceId = context.getResources().getIdentifier("drawable/win_" + (j + 1), null, context.getPackageName());
            frames[j] = BitmapFactory.decodeResource(getResources(), resourceId);
        }

        // Start the automatic bitmap movement
        handler.post(updateRunnable);

        // Set up MediaPlayer for music
        mediaPlayer = MediaPlayer.create(context, R.raw.gangnam_style);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.start(); // Start playing
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Use existing bitmap drawing logic
        canvas.drawBitmap(frames[i], x, y, new Paint());
        // No need to call invalidate here since it's being called by the runnable
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // ...existing touch event logic...
        return true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (handler != null && updateRunnable != null) {
            handler.removeCallbacks(updateRunnable); // Stop updates when view is detached
        }
        if (mediaPlayer != null) {
            mediaPlayer.stop(); // Stop music playback
            mediaPlayer.release(); // Release media player resources
            mediaPlayer = null;
        }
    }
}
