package com.pranshu.covertex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    String Amt;
    static int c = 0;
    String h1 = "Dollars";
    String h2 = "INR";
    public void btnClick(View view){
        if(c%2==0) {
            EditText dollar = (EditText) findViewById(R.id.amt1);
            String dollars = dollar.getText().toString();

            if (dollars.length() == 0) {
                String toast_text = "Enter Some Value in dollars field.";
                Toast.makeText(this, toast_text, Toast.LENGTH_SHORT).show();
                return;
            }

            if(!isNumeric(dollars)){
                String toast_text = "Enter only numeric value.";
                dollar.setText("");
                Toast.makeText(this, toast_text, Toast.LENGTH_SHORT).show();
                return;
            }

            double ddollars = Double.parseDouble(dollars);
            double dInr = 74.17 * ddollars;
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            Double res = new Double(df.format(dInr));
            Amt = res.toString();

            EditText inr = findViewById(R.id.amt2);
            inr.setText(Amt);
        }

        else{
            EditText rupees = (EditText) findViewById(R.id.amt1);
            String rup = rupees.getText().toString();

            if (rup.length() == 0) {
                String toast_text = "Enter Some Value in INR field.";
                rupees.setText("");
                Toast.makeText(this, toast_text, Toast.LENGTH_SHORT).show();
                return;
            }

            if(!isNumeric(rup)){
                String toast_text = "Enter only numeric value.";
                Toast.makeText(this, toast_text, Toast.LENGTH_SHORT).show();
                return;
            }

            double drup = Double.parseDouble(rup);
            double dDol = drup/74.17;
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            Double res = new Double(df.format(dDol));
            Amt = res.toString();

            EditText inr = findViewById(R.id.amt2);
            inr.setText(Amt);
        }

        //imageview, input_type, chaining in constraint layout and
        //barrier, groups
        //bias,
        //project_structure ,drawable
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void print(View view){
        Intent in = new Intent(this, printActivity.class);
        startActivity(in);

    }

    public void reverse(View v){
        c++;
        if(c%2!=0){
            TextView t1 = findViewById(R.id.textView3);
            TextView t2 = findViewById(R.id.textView5);
            t1.setText("Amount in Rupees");
            t2.setText("Amount in Dollar");

            EditText e1 = findViewById(R.id.amt1);
            EditText e2 = findViewById(R.id.amt2);
            e1.setHint(h2);
            e2.setHint(h1);

            String rupe = e1.getText().toString();
            String doll = e2.getText().toString();

            e1.setText(doll);
            e2.setText(rupe);
        }

        else{
            TextView t1 = findViewById(R.id.textView3);
            TextView t2 = findViewById(R.id.textView5);
            t2.setText("Amount in Rupees");
            t1.setText("Amount in Dollar");

            EditText e1 = findViewById(R.id.amt1);
            EditText e2 = findViewById(R.id.amt2);
            e2.setHint(h2);
            e1.setHint(h1);

            String rupe = e2.getText().toString();
            String doll = e1.getText().toString();

            e2.setText(doll);
            e1.setText(rupe);
        }

    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}