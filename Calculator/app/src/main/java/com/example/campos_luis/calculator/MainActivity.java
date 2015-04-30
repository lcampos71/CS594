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

public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    // Buttons for the numbers
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    // Buttons for the operations
    Button add, sub, mult, div, delete, equal, decimal;
    // The EditText for the screen output
    EditText display;
    // variables to hold numbers and operators
    double var1;
    double var2;
    // This is the number returned by activity 2
    String activity2;
    // String variable for the operator
    String operator;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To retrieve activity2 number
        Intent intent = getIntent();
        activity2 = intent.getStringExtra("activity2");
        // for debugging
        if(activity2 != null){
            System.out.println(activity2);
        }
        // First get all the buttons from the layout
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        // This is the operator buttons
        add = (Button) findViewById(R.id.plus);
        sub = (Button) findViewById(R.id.minus);
        mult = (Button) findViewById(R.id.mult);
        div = (Button) findViewById(R.id.div);
        delete = (Button) findViewById(R.id.del);
        equal = (Button) findViewById(R.id.equals);
        decimal = (Button) findViewById(R.id.decimal);
        display = (EditText) findViewById(R.id.display);
        // Now set the listeners 
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        // listeners for operators
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mult.setOnClickListener(this);
        div.setOnClickListener(this);
        equal.setOnClickListener(this);
        delete.setOnClickListener(this);
        decimal.setOnClickListener(this);


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

            Intent intent = new Intent(MainActivity.this,Activity2.class);
            // send over activity ones number
            intent.putExtra("activity1",display.getText().toString());
            startActivity(intent);
            return true;


        }

        else {

            return super.onOptionsItemSelected(item);
        }
    }
    //    This is the onclick method used for when the buttons are clicked
    public void onClick(View arg0){
        // String that can be modified
        Editable str =  display.getText();
        // Switch for all the buttons on the calculator
        switch(arg0.getId()){
            // Case 0
            case R.id.zero:
                //append the value zero to the string
                str = str.append(zero.getText());
                display.setText(str);
                break;
            // Case 1
            case R.id.one:
                //append the value one to the string
                str = str.append(one.getText());
                display.setText(str);
                break;
            // Case 2
            case R.id.two:
                //append the value two to the string
                str = str.append(two.getText());
                display.setText(str);
                break;
            // Case 3
            case R.id.three:
                //append the value three to the string
                str = str.append(three.getText());
                display.setText(str);
                break;
            // Case 4
            case R.id.four:
                //append the value four to the string
                str = str.append(four.getText());
                display.setText(str);
                break;
            // Case 5
            case R.id.five:
                //append the value five to the string
                str = str.append(five.getText());
                display.setText(str);
                break;
            // Case 6
            case R.id.six:
                //append the value six to the string
                str = str.append(six.getText());
                display.setText(str);
                break;
            // Case 7
            case R.id.seven:
                //append the value seven to the string
                str = str.append(seven.getText());
                display.setText(str);
                break;
            // Case 8
            case R.id.eight:
                //append the value eight to the string
                str = str.append(eight.getText());
                display.setText(str);
                break;
            // Case9
            case R.id.nine:
                //append the value nine to the string
                str = str.append(nine.getText());
                display.setText(str);
                break;
            // Case addition
            case R.id.plus:
                operator = "+";
                // for debugging purposes
                System.out.println("Var1");
                System.out.println(var1);
                System.out.println("Var2");
                System.out.println(var2);
                // This handles when equals is not pressed, example 3+4+ should return 7
                if(var1 == 0){
                    var1 = Double.parseDouble(display.getText().toString());
                    display.setText("");
                }
                else if(var2 != 0){
                    var2 = 0;
                    display.setText("");
                }
                else{
                    var2 = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    var1 = var1 + var2;
                    display.setText(Double.toString(var1));
                }
                break;
            // Case subtraction
            case R.id.minus:
                operator = "-";
                System.out.println("Var1");
                System.out.println(var1);
                System.out.println("Var2");
                System.out.println(var2);
                // This handles when equals is not pressed, example 8-4- should return 4
                if(var1 == 0){
                    var1 = Double.parseDouble(display.getText().toString());
                    display.setText("");
                }
                else if(var2 != 0){
                    var2 = 0;
                    display.setText("");
                }
                else{
                    var2 = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    var1 = var1 - var2;
                    display.setText(Double.toString(var1));
                }
                break;
            // Case multiplication
            case R.id.mult:
                operator = "x";
                System.out.println("Var1");
                System.out.println(var1);
                System.out.println("Var2");
                System.out.println(var2);
                // similar as addition this handles when equals is not pressed
                if(var1 == 0){
                    var1 = Double.parseDouble(display.getText().toString());
                    display.setText("");
                }
                else if(var2 != 0){
                    var2 = 0;
                    display.setText("");
                }
                else{
                    var2 = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    var1 = var1 * var2;
                    display.setText(Double.toString(var1));
                }
                break;
            // Case division
            case R.id.div:
                operator = "/";
                System.out.println("Var1");
                System.out.println(var1);
                System.out.println("Var2");
                System.out.println(var2);
                // similar as addition this handles when equals is not pressed
                if(var1 == 0){
                    var1 = Double.parseDouble(display.getText().toString());
                    display.setText("");
                }
                else if(var2 != 0){
                    var2 = 0;
                    display.setText("");
                }
                else{
                    var2 = Double.parseDouble(display.getText().toString());
                    display.setText("");
                    var1 = var1 / var2;
                    display.setText(Double.toString(var1));
                }
                break;
            // Case decimal
            case R.id.decimal:
                System.out.println("Var1");
                System.out.println(var1);
                System.out.println("Var2");
                System.out.println(var2);
                if(var2 != 0){
                    var2 = 0;
                    display.setText("");
                }
                str = str.append(decimal.getText());
                display.setText(str);
                break;
            // Case delete
            case R.id.del:
                System.out.println("Var1");
                System.out.println(var1);
                System.out.println("Var2");
                System.out.println(var2);
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
            case R.id.equals:
                System.out.println("Var1");
                System.out.println(var1);
                System.out.println("Var2");
                System.out.println(var2);
                if(!operator.equals(null)){
                    if(var2 != 0){
                        // if equal is pressed after var1 + var2
                        if(operator.equals("+")){
                            display.setText("");
                            display.setText(Double.toString(var1));
                        }
                        // if equal is pressed after var1 - var2
                        else if(operator.equals("-")){
                            display.setText("");
                            display.setText(Double.toString(var1));
                        }
                        // if equal is pressed after var1 * var2
                        else if(operator.equals("*")){
                            display.setText("");
                            display.setText(Double.toString(var1));
                        }
                        // if equal is pressed after var1 / var2
                        else if(operator.equals("/")){
                            display.setText("");
                            display.setText(Double.toString(var1));
                        }
                    }
                    else{
                        operations();
                    }
                }
                break;

        }
    }
    public void operations(){
        // adds var1 and var2
        if(operator.equals("+")){
            var2 = Double.parseDouble(display.getText().toString());
            display.setText("");
            var1 = var1 + var2;
            display.setText(Double.toString(var1));
        }
        // subtracts var1 and var2
        else if(operator.equals("-")){
            var2 = Double.parseDouble(display.getText().toString());
            display.setText("");
            var1 = var1 - var2;
            display.setText(Double.toString(var1));
        }
        // multiplies var1 and var2
        else if(operator.equals("x")){
            var2 = Double.parseDouble(display.getText().toString());
            display.setText("");
            var1 = var1 * var2;
            display.setText(Double.toString(var1));
        }
        // divides var1 and var2
        else if(operator.equals("/")){
            var2 = Double.parseDouble(display.getText().toString());
            display.setText("");
            var1 = var1 / var2;;
            display.setText(Double.toString(var1));
        }
    }
}
