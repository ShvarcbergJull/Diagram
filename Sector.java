package com.example.pc.circle_diagram;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class Sector {
    float left, right, top, bottom, startAngle, sweepAngle;
    int color;

    public Sector(float left, float top, float right, float bottom, float startAngle, float sweepAngle, int color) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
        this.color = color;
    }

    public void draw(Canvas canvas)
    {
        Paint p = new Paint();
        p.setColor(color);
        canvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, true, p);
    }
}
