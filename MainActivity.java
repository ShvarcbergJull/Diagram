package com.example.pc.circle_diagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] input_values;
    EditText et;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.parts);
//        button = findViewById(R.id.form);
//        Diagram_View dv = new Diagram_View(this);
//        button.setOnClickListener(dv);
    }

    public void onClick(View v)
    {
        String text_input = et.getText().toString();
        input_values = text_input.split(" ");
    }
}
