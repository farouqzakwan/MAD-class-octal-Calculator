package com.octa.farouq.octacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String input = "";
    String temp = "";
    TextView display;
    int[] operand;
    char[] operator;
    OctaConverter converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set text to blank string first..
        display = (TextView)findViewById(R.id.txtDisp);
        display.setText("");
    }

    //operand button...
    public void btn0(View view) {
        input+=0;
        display.setText(input);
    }
    public void btn1(View view) {
        input+=1;
        display.setText(input);
    }
    public void btn2(View view){
        input+=2;
        display.setText(input);
    }
    public void btn3(View view){
        input+=3;
        display.setText(input);
    }
    public void btn4(View view){
        input+=3;
        display.setText(input);
    }
    public void btn5(View view){
        input+=5;
        display.setText(input);
    }
    public void btn6(View view){
        input+=6;
        display.setText(input);
    }
    public void btn7(View view){
        input+=7;
        display.setText(input);
    }

    //operator button
    public void btnclear(View view){
        input="";
        temp="";
        display.setText(input);
    }

    public void btnplus(View view){


        //building string variable for mathematical expression  in decimal...
        converter = new OctaConverter();
        converter.setOctaString(input);
        int x = converter.toDecimal();
        temp += ""+x+"+";

        input = "+";
        display.setText(input);

        input = "";
    }

    public void btnminus(View view){


        converter = new OctaConverter();
        converter.setOctaString(input);
        int x = converter.toDecimal();
        temp += ""+x+"-";

        input = "-";
        display.setText(input);

        input = "";
    }
    public void btnmultiply(View view){


        converter = new OctaConverter();
        converter.setOctaString(input);
        int x = converter.toDecimal();
        temp += ""+x+"*";

        input = "*";
        display.setText(input);

        input = "";
    }
    public void btndiv(View view){


        converter = new OctaConverter();
        converter.setOctaString(input);
        int x = converter.toDecimal();
        temp += ""+x+"/";

        input = "/";
        display.setText(input);

        input = "";
    }
    public void btnequal(View view){


        converter = new OctaConverter();
        converter.setOctaString(input);
        int x = converter.toDecimal();
        temp += input;

        input = temp;
        //calculate from string....
        StringParser parser = new StringParser();
        double d = parser.getAnswer(temp);

        display.setText(temp + "="+d);

    }
    public void btnDecimal(View view){
        OctaConverter convert = new OctaConverter();
        convert.setOctaString(input);
        int decimalNumber = convert.toDecimal();
        display.setText(""+decimalNumber);
    }

}
