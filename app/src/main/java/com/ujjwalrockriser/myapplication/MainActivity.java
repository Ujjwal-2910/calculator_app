package com.ujjwalrockriser.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView input;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
    }
    public void one(View v) {
        input.append("1");
    }
    public void two(View v) {
        input.append("2");
    }
    public void three(View v) {
        input.append("3");
    }
    public void four(View v) {
        input.append("4");
    }
    public void five(View v) {
        input.append("5");
    }
    public void six(View v) {
        input.append("6");
    }
    public void seven(View v) {
        input.append("7");
    }
    public void eight(View v) {
        input.append("8");
    }
    public void nine(View v) {
        input.append("9");
    }
    public void zero(View v) {
        input.append("0");
    }
    public void dot(View v) {
        input.append(".");
    }
    public void add(View v) {
        input.append("+");
    }
    public void minus(View v) {
        input.append("-");
    }
    public void multiply(View v) {
        input.append("*");
    }
    public void divide(View v) {
        input.append("/");
    }
    public void clear_one_digit(View v) {
        String s = input.getText().toString();
        if(s.length() == 0)
            return;
        s = s.substring(0, s.length() - 1);
        input.setText(s);
    }
    public void all_clear(View v) {
        input.setText("");
        output.setText("");
    }
    public void equals(View v) {
        String s = input.getText().toString();
        String result = calculate(s);
        output.setText(result);
    }
    private String calculate(String s) {
        int n = s.length();
        if(n == 0)
            return "";
        if(s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/')
            return "ERR";
        if(isFloat(s))
            return s;
        int i = n - 1;
        while(i >= 0) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-')
                break;
            i--;
        }
        if(i == -1) {
            i = n - 1;
            while(i >= 0) {
                if (s.charAt(i) == '*' || s.charAt(i) == '/')
                    break;
                i--;
            }
            String ans1 = calculate(s.substring(0, i));
            String ans2 = calculate(s.substring(i + 1));
            float a = Float.parseFloat(ans1);
            float b = Float.parseFloat(ans2);
            if(s.charAt(i) == '*')
                return Float.toString(a * b);
            if(b == 0f)
                return "ERR";
            return Float.toString(a / b);
        }
        String ans1 = calculate(s.substring(0, i));
        String ans2 = calculate(s.substring(i + 1));
        float a = Float.parseFloat(ans1);
        float b = Float.parseFloat(ans2);
        if(s.charAt(i) == '+')
            return Float.toString(a + b);
        return Float.toString(a - b);
    }
    boolean isFloat(String s) {
        for(int i = 0; i < s.length(); i++) {
            if((s.charAt(i) > '9' || s.charAt(i) < '0') && s.charAt(i) != '.')
                return false;
        }
        return true;
    }
}