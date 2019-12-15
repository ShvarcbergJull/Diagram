package com.example.pc.circle_diagram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Diagram_View extends View {
    MainActivity activity;
    String[] inform;
    float[] sweet;
    ArrayList<Sector> sectors = new ArrayList<>();
    float w, h;

    public Diagram_View(Context context) {
        super(context);
    }

    public Diagram_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        activity = (MainActivity) context;
    }

    public void tester(String temp) {
        inform = temp.split(" ");
        ariph();
        sect();
        invalidate();
    }

    private void ariph()
    {
        float count = 0;
        int[] numbers = new int[inform.length];
        for (int i = 0;i < numbers.length;i++) {
            numbers[i] = Integer.parseInt(inform[i]);
            count += numbers[i];
        }
        count = 360 / count;
        sweet = new float[numbers.length];

        for (int i = 0;i < numbers.length;i++) {
            sweet[i] = numbers[i] * count;
        }
    }

    private void sect() {
        Log.d("EnG", "restart");
        sectors.clear();
        int start = 0;
        for (int i = 0;i < sweet.length;i++)
        {
            Sector s = new Sector(0, 0, w, w, start, sweet[i], Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
            start += sweet[i];
            sectors.add(s);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w = canvas.getWidth(); h = canvas.getHeight();
        if (activity.flagin == true) {
            for (int i = 0;i < sectors.toArray().length;i++)
            {
                sectors.get(i).draw(canvas);
            }
            activity.flagin = false;
        }
    }

}
