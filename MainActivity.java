package com.example.pc.circle_diagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et;
    boolean flagin = false;
    Diagram_View dv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.parts);
        dv = findViewById(R.id.diagram);
        tv = findViewById(R.id.procent);
    }

    public void setTv (String str) {
        Log.d("Sectors", str);
        tv.setText(str);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.created) {
            String temp = et.getText().toString();
            flagin = true;
            dv.tester(temp);
        }
    }
}
