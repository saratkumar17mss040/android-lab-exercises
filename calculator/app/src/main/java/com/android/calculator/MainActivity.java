package com.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    TextView t1;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean getNumbers() {

        et1 =  findViewById(R.id.num1);
        et2 =  findViewById(R.id.num2);
        t1 = findViewById(R.id.result);
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();


        if ((s1.equals(null) && s2.equals(null)) || (s1.equals("") && s2.equals(""))) {
            String result = "Please enter a value";
            t1.setText(result);
            return false;
        } else {
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        }
        return true;
    }

    public void add(View v) {
        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(Integer.toString(sum));
        }
    }

    public void pow(View v) {

        if (getNumbers()) {
            double sum = Math.pow(num1, num2);
            t1.setText(Double.toString(sum));
        }
    }

    public void sub(View v) {
        if (getNumbers()) {
            int sum = num1 - num2;
            t1.setText(Integer.toString(sum));
        }
    }

    public void mul(View v) {

        if (getNumbers()) {
            int sum = num1 * num2;
            t1.setText(Integer.toString(sum));
        }
    }

    public void div(View v) {

        if (getNumbers()) {
            double sum = num1 / (num2 * 1.0);
            t1.setText(Double.toString(sum));
        }
    }

    public void mod(View v) {
        if (getNumbers()) {
            double sum = num1 % num2;
            t1.setText(Double.toString(sum));
        }
    }

    public  void clear(View v) {
        if(getNumbers()) {
           String result = "";
            t1.setText(result);
        }
    }
}
