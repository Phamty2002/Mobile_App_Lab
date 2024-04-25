package com.example.mobileapp_lab03.graphic;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GraphicsView extends View {

    public GraphicsView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Create a rectangle
        Rect r = new Rect(40, 40, 400, 200);

        // Initialize a paint object
        Paint paint = new Paint();

        // Set the paint color to red
        paint.setColor(Color.RED);

        // Set the paint style to fill the rectangle
        paint.setStyle(Paint.Style.FILL);

        // Draw the rectangle on the canvas
        canvas.drawRect(r, paint);

        // Call invalidate to redraw the view
        invalidate();
    }
}

