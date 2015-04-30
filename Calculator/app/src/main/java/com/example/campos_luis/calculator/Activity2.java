package com.example.campos_luis.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by campos_luis on 4/27/15.
 */
public class Activity2 extends ActionBarActivity implements View.OnClickListener {
    // Buttons 
    Button sin, cos, tan, del, ln, log, pi, e, percent, factorial,sqrt,power;
    // The EditText for the screen output
    EditText display;
    // variables to hold numbers and operators
    double var1;
    double var2;
    // This is the number returned by activity 1
    String activity1;
    // String variable for the operator
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        // To retrieve activity1 number
        Intent intent = getIntent();
        activity1 = intent.getStringExtra("activity1");
        System.out.println(activity1);
        // First get all the buttons from the layout
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        del = (Button) findViewById(R.id.del);
        ln = (Button) findViewById(R.id.ln);
        log = (Button) findViewById(R.id.log);
        pi = (Button) findViewById(R.id.pi);
        e = (Button) findViewById(R.id.e);
        percent = (Button) findViewById(R.id.percent);
        factorial = (Button) findViewById(R.id.factorial);
        sqrt = (Button) findViewById(R.id.sqrt);
        power = (Button) findViewById(R.id.power);
        display = (EditText) findViewById(R.id.display);
        // Now set the listeners 
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        del.setOnClickListener(this);
        ln.setOnClickListener(this);
        log.setOnClickListener(this);
        pi.setOnClickListener(this);
        e.setOnClickListener(this);
        percent.setOnClickListener(this);
        factorial.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        power.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //if tab press, go to the next activity
        if(id == R.id.Swap){

            Intent intent = new Intent(Activity2.this,MainActivity.class);
            intent.putExtra("activity2",display.getText().toString());
            startActivity(intent);
            return true;


        }

        else {

            return super.onOptionsItemSelected(item);
        }
    }
    // Factorial Function
    public static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    //    This is the onclick method used for when the buttons are clicked
    public void onClick(View arg0){
        // String that can be modified
        Editable str =  display.getText();
        switch(arg0.getId()){
            // Case PI
            case R.id.pi:
                display.setText("");
                double pi = Math.PI;
                str = str.append(Double.toString(pi));
                display.setText(str);
                break;
            // Case e
            case R.id.e:
                display.setText("");
                double e = Math.E;
                str = str.append(Double.toString(e));
                display.setText(str);
                break;
            // Case factorial
            case R.id.factorial:
                // if the editText is empty
                if (activity1.isEmpty()){
                    System.out.println("activity1 is empty");
                }
                else{
                    // Transform the string to a double 
                    System.out.println("activity1 is not empty");
                    int temp = Integer.parseInt(activity1);
                    System.out.println(temp);
                    int fact = factorial(temp);
                    System.out.println(fact);
                    display.setText(Integer.toString(fact));
                }
                break;
            // Case percent
            case R.id.percent:
                // if the editText is empty
                if (activity1.isEmpty()){
                    System.out.println("activity1 is empty");
                }
                else{
                    // Transform the string to a double 
                    System.out.println("activity1 is not empty");
                    double temp = Double.parseDouble(activity1);
                    System.out.println(temp);
                    double percents = temp/100;
                    System.out.println(percents);
                    display.setText(Double.toString(percents));
                }
                break;
            // Case cosine
            case R.id.cos:
                // if the editText is empty
                if (activity1.isEmpty()){
                    System.out.println("activity1 is empty");
                }
                else{
                    // Transform the string to a double 
                    System.out.println("activity1 is not empty");
                    double temp = Double.parseDouble(activity1);
                    System.out.println(temp);
                    var1 = Math.cos(temp);
                    System.out.println(var1);
                    display.setText(Double.toString(var1));
                }
                break;
            // Case sine
            case R.id.sin:
                // if the editText is empty
                if (activity1.isEmpty()){
                    System.out.println("activity1 is empty");
                }
                else{
                    // Transform the string to a double 
                    System.out.println("activity1 is not empty");
                    double temp = Double.parseDouble(activity1);
                    System.out.println(temp);
                    var1 = Math.sin(temp);
                    System.out.println(var1);
                    display.setText(Double.toString(var1));
                }

                break;
            //Case tangent 
            case R.id.tan:
                // if the editText is empty
                if (activity1.isEmpty()){
                    System.out.println("activity1 is empty");
                }
                else{
                    // Transform the string to a double 
                    System.out.println("activity1 is not empty");
                    double temp = Double.parseDouble(activity1);
                    System.out.println(temp);
                    var1 = Math.tan(temp);
                    System.out.println(var1);
                    display.setText(Double.toString(var1));
                }
                break;
            //Case log base 10 
            case R.id.log:
                // if the editText is empty
                if (activity1.isEmpty()){
                    System.out.println("activity1 is empty");
                }
                else{
                    // Transform the string to a double 
                    System.out.println("activity1 is not empty");
                    double temp = Double.parseDouble(activity1);
                    System.out.println(temp);
                    var1 = Math.log10(temp);
                    System.out.println(var1);
                    display.setText(Double.toString(var1));
                }
                break;
            //Case natural log
            case R.id.ln:
                // if the editText is empty
                if (activity1.isEmpty()){
                    System.out.println("activity1 is empty");
                }
                else{
                    // Transform the string to a double 
                    System.out.println("activity1 is not empty");
                    double temp = Double.parseDouble(activity1);
                    System.out.println(temp);
                    var1 = Math.log(temp);
                    System.out.println(var1);
                    display.setText(Double.toString(var1));
                }
                break;
            //Case natural log
            case R.id.sqrt:
                // if the editText is empty
                if (activity1.isEmpty()){
                    System.out.println("activity1 is empty");
                }
                else{
                    // Transform the string to a double 
                    System.out.println("activity1 is not empty");
                    double temp = Double.parseDouble(activity1);
                    System.out.println(temp);
                    var1 = Math.sqrt(temp);
                    System.out.println(var1);
                    display.setText(Double.toString(var1));
                }
                break;
            //Case power
            case R.id.power:
                // if the editText is empty
                if (activity1.isEmpty()){
                    System.out.println("activity1 is empty");
                }
                else{
                    // Transform the string to a double 
                    System.out.println("activity1 is not empty");
                    double temp = Double.parseDouble(activity1);
                    System.out.println(temp);
                    // Check if var1 is empty
                    if(var1!=0){
                        if(var2!=0){
                            // a^b
                            var1= Math.pow(var1, var2);
                            System.out.println(var1);
                            display.setText(Double.toString(var1));
                        }
                    }
                    // var1 = Math.sqrt(temp);
                    // System.out.println(var1);
                    // display.setText(Double.toString(var1));
                }
                break;
            // Case delete
            case R.id.del:
                if(var2 != 0){
                    var2 = 0;
                    display.setText("");
                }
                // Get edit text characters
                String textInBox = display.getText().toString();
                if(textInBox.length() > 0){
                    //Remove last character// 
                    String newText = textInBox.substring(0, textInBox.length()-1);
                    // Update edit text 
                    display.setText(newText);
                }
                break;
        }
    }
}
