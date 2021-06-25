package com.pranshu.covertex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class printActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        String s = "1 Dollar = 74.17 INR";
        TextView v = findViewById(R.id.printAmt);
        v.setText(s);
    }
}