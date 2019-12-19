package com.example.pc.circle_diagram;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

public class Sector {
    float left, right, top, bottom, startAngle, sweepAngle, radius;
    int color;
    int curr_x, curr_y;
    float proc;
    boolean bg = false;

    public Sector(float left, float top, float right, float bottom, float startAngle, float sweepAngle, int color, float proc) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
        this.color = color;
        this.radius = (right - left) / 2;
        this.curr_x = (int) (right - left) / 2;
        this.curr_y = this.curr_x;
        this.proc = proc;
    }

    public void draw(Canvas canvas)
    {
        Paint p = new Paint();
        p.setColor(color);
        canvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, true, p);
    }

    public void drawBg(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.YELLOW);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(20);
        canvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, true, p);
    }

    public void drawWithMove(Canvas canvas) {
        float temp = sweepAngle / 2;
        temp = startAngle + temp;
        double ang = Math.toRadians(temp);
        float x = (float)(radius * Math.cos(ang) / 2);
        float y = (float)(radius * Math.sin(ang) / 2);
        Paint p = new Paint();
        p.setColor(color);
        canvas.drawArc(left + x, top + y,right + x, bottom + y, startAngle, sweepAngle, true, p);
    }

    public boolean inSector(float x, float y) {
        if ((x - curr_x) * (x - curr_x) + (y - curr_y) * (y - curr_y) <= radius * radius) {
            float f = (float) Math.toDegrees(Math.acos((x - curr_x) / radius));
            float ang = startAngle + sweepAngle;
            Log.d("DebugerMy", "Y = " + String.valueOf(y));
            Log.d("DebugerMy", "CURR_Y = " + String.valueOf(curr_y));
            if (y > curr_y) {
                Log.d("DebugerMy", "startAngle = " + String.valueOf(startAngle));
                Log.d("DebugerMy", "f = " + String.valueOf(f));
                if (startAngle < 180) {
                    if (f >= startAngle) {
                        Log.d("DebugerMy", "ang = " + String.valueOf(ang));
                        if (ang <= 180) {
                            if (f <= ang) {
                                Log.d("DebugerMy", "yeEEES");
                                return true;
                            }
                        }
                        else {
                            return true;
                        }
                    }
                    else {
                        return false;
                    }
                }
                return false;
            }
            else {
                if (ang > 180) {
                    if (360 - ang <= f) {
                        if (startAngle >= 180) {
                            if (f <= 360 - startAngle) {
                                return true;
                            }
                        }
                        else {
                            return true;
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return  false;
    }
}
