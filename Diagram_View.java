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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Diagram_View extends View implements View.OnClickListener {
    MainActivity activity;
    Button button;
    String[] inform;


    public Diagram_View(Context context) {
        super(context);
    }


    //    protected void ariph()
//    {
//        EditText et = activity.et;
//        String temp = et.toString();
//        String[] temp1 = temp.split(" ");
//        int[] numbers = new int[temp1.length];
//        for (int i = 0;i < temp1.length;i++) {
//            numbers[i] = Integer.parseInt(temp1[i]);
//        }
//        for (int i = 0;i < activity.numbers.length;i++) {
//            counts += activity.numbers[i];
//        }
//        counts = 360 / counts;
//        sweet = new float[activity.numbers.length];
//
//        for (int i = 0;i < activity.numbers.length;i++) {
//            sweet[i] = activity.numbers[i] * counts;
//        }
//    }

    public Diagram_View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        activity = (MainActivity) context;
        inform =
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("State_v", "restart");
        float w = canvas.getWidth(), h = canvas.getHeight();
        Paint p = new Paint(); p.setColor(Color.GREEN);
        canvas.drawArc(0, 0, w, w, 90, ang, true, p);
//        canvas.drawArc(50, 50, w + 50, w + 50, 0, 90, true, p);
    }

//    @Override
//    public void onClick(View v) {
//        Log.d("test_but", "YEEEEES");
//        ang = 270;
//        invalidate();
//    }

}
