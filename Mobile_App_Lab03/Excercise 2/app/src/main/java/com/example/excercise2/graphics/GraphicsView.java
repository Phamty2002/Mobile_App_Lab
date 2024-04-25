package com.example.excercise2.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class GraphicsView extends View {
    private Rect rectangle;
    private Paint paint;
    private int x, y, width, height;
    private boolean drawRect = false;

    public GraphicsView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        width = 200; // Set the width for the rectangle
        height = 100; // Set the height for the rectangle
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (drawRect) {
            // Draw the rectangle on the canvas
            rectangle = new Rect(x, y, x + width, y + height);
            canvas.drawRect(rectangle, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                x = (int) event.getX() - width / 2;
                y = (int) event.getY() - height / 2;
                drawRect = true;
                invalidate(); // Call invalidate to redraw the view with the rectangle
                return true;
        }
        return super.onTouchEvent(event);
    }
}

