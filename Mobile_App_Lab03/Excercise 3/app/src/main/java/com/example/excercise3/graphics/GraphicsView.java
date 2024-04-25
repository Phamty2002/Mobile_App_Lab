package com.example.excercise3.graphics;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {
    private Bitmap[] frames = new Bitmap[16]; // assuming 16 frames
    private int i = 0;
    private int x = 40; // Default X coordinate
    private int y = 40; // Default Y coordinate

    public GraphicsView(Context context) {
        super(context);
        // Initialize each frame of the animation
        for (int j = 0; j < frames.length; j++) {
            int resourceId = context.getResources().getIdentifier("drawable/win_" + (j + 1), null, context.getPackageName());
            frames[j] = BitmapFactory.decodeResource(getResources(), resourceId);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (i < 16) {
            canvas.drawBitmap(frames[i], x, y, new Paint());
        } else {
            i = 0; // Reset the counter to loop the frames
            canvas.drawBitmap(frames[i], x, y, new Paint());
        }
        invalidate(); // Request to redraw the view, causing another call to onDraw
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                // Update the position to draw the animation frame
                x = (int) event.getX() - frames[i].getWidth() / 2;
                y = (int) event.getY() - frames[i].getHeight() / 2;
                // Increment the frame index
                i++;
                if (i >= frames.length) i = 0; // Ensure the index loops back to the start
                invalidate(); // Request to redraw the view
                break;
        }
        return true;
    }
}
