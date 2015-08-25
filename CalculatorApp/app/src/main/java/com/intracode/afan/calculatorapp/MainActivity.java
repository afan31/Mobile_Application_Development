package com.intracode.afan.calculatorapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ArrayList<String> arrayList = new ArrayList<String>();
    String string = "";
    String string1 = "";

    public void onClick1(View v){

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        Button button = (Button)v;
        string = (String)button.getText().toString();

        if(!string.contains("+") && !string.contains("-") && !string.contains("*") && !string.contains("/")){
            string1 = string1 + string;
            if (arrayList.size()>0){
                arrayList.remove(arrayList.size()-1);

            }
            arrayList.add(string1);
        }
        else {

            arrayList.add(string);
            arrayList.add(string);
            string1 = "";

        }


        textView1.setText(textView1.getText().toString() + string);

        //textView1.setText(arrayList.toString());

    }

    public void onClick(View v){

        TextView textView2 = (TextView)findViewById(R.id.textView2);

        int calc = 0;
        int c = arrayList.size();

        //eg. array( 2,+,3,*,4,-,3) ... size = 7, so it will enter while loop and then if condition, once it enters if condition it will check for 2nd operator

        while (c!=1){

            if(c>3){

                if(arrayList.get(3).contains("*") || arrayList.get(3).contains("/")){

                    if(arrayList.get(3).contains("*")){
                        calc = Integer.parseInt(arrayList.get(2))* Integer.parseInt(arrayList.get(4));
                    }
                    if(arrayList.get(3).contains("/")){
                        calc = Integer.parseInt(arrayList.get(2))/ Integer.parseInt(arrayList.get(4));
                    }

                    // calc = 12 , array( 2,+,3,*,4,-,3)
                    arrayList.remove(2); //array( 2,+,*,4,-,3)
                    arrayList.remove(2); //array( 2,+,4,-,3)
                    arrayList.remove(2); //array( 2,+,-,3)

                    arrayList.add(2,Integer.toString(calc)); //array( 2,+,12,-,3)
                    c= arrayList.size(); // size 5

                }
                else {
                    //array( 2,+,12,-,3)
                    if(arrayList.get(1).contains("+")){
                        calc = Integer.parseInt(arrayList.get(0))+ Integer.parseInt(arrayList.get(2));
                    }
                    if(arrayList.get(1).contains("-")){
                        calc = Integer.parseInt(arrayList.get(0))- Integer.parseInt(arrayList.get(2));
                    }
                    if(arrayList.get(1).contains("*")){
                        calc = Integer.parseInt(arrayList.get(0))* Integer.parseInt(arrayList.get(2));
                    }
                    if(arrayList.get(1).contains("/")){
                        calc = Integer.parseInt(arrayList.get(0))/ Integer.parseInt(arrayList.get(2));
                    }

                    //cacl = 14 , //array( 2,+,12,-,3)
                    arrayList.remove(0); //array(+,12,-,3)
                    arrayList.remove(0); //array(12,-,3)
                    arrayList.remove(0); //array(-,3)

                    arrayList.add(0, Integer.toString(calc)); //array(14,-,3)
                    c= arrayList.size(); //size = 3;

                }
            }
                // size <= 3
            else {

                if(arrayList.get(1).contains("+")){
                    calc = Integer.parseInt(arrayList.get(0))+ Integer.parseInt(arrayList.get(2));
                }
                //array(14,-,3)
                if(arrayList.get(1).contains("-")){
                    calc = Integer.parseInt(arrayList.get(0))- Integer.parseInt(arrayList.get(2));
                }
                if(arrayList.get(1).contains("*")){
                    calc = Integer.parseInt(arrayList.get(0))* Integer.parseInt(arrayList.get(2));
                }
                if(arrayList.get(1).contains("/")){
                    calc = Integer.parseInt(arrayList.get(0))/ Integer.parseInt(arrayList.get(2));
                }

                // calc = 11

                arrayList.remove(0); //array(-,3)
                arrayList.remove(0); //array(3)
                arrayList.remove(0); //array()

                arrayList.add(0, Integer.toString(calc)); //array(11)
                c= arrayList.size(); //size = 1 therefore, this is end of the loop
            }
        }

        textView2.setText(Integer.toString(calc));
    }

    public void clear (View v){

        TextView textView1 = (TextView)findViewById(R.id.textView1);
        TextView textView2 = (TextView)findViewById(R.id.textView2);

        string1="";
        string="";
        textView1.setText("");
        textView2.setText("0");
        arrayList.clear();

    }

    /*public void onAddClick(View a){


        EditText a1 = (EditText)findViewById(R.id.TFNumber1);
        EditText a2 = (EditText)findViewById(R.id.TFNumber2);

        TextView t = (TextView)findViewById(R.id.TVResult);

        double num1, num2,ans;

        num1 = Double.parseDouble(a1.getText().toString());
        num2 = Double.parseDouble(a2.getText().toString());
        ans = 0;
        if(a.getId() == R.id.Badd) {
            ans = num1 + num2;
        }

        t.setText(ans+"");
    }*/





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

        return super.onOptionsItemSelected(item);
    }

}
