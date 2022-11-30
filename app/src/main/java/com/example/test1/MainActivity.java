package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView workingTV;

    String workings = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraintlayout);
        initTextView();
    }
    private void initTextView(){
        workingTV = findViewById(R.id.textView5);
    }
    private void setWorkings(String givenValue){
        workings = workings + givenValue;
        workingTV.setText(workings);
    }
    public void equalOnClick(View view){
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double) engine.eval(workings);
        }catch(ScriptException e)
        {
            e.printStackTrace();
            Toast.makeText(this,"Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result!=null)
            workingTV.setText(String.valueOf(result.doubleValue()));
    }
    public void clearAllOnClick(View view){
        workingTV.setText("");
        workings = "";
    }
    public void clearOnClick(View view){
        workingTV.setText("");
    }
    public void clearOneOnClick(View view){

        String str = workingTV.getText().toString();
        if (str.length() >1 ) {
            str = str.substring(0, str.length() - 1);
            workingTV.setText(str);
        }
        else if (str.length() <=1 ) {
            workingTV.setText("0");
        }
    }
    public void nineOnClick(View view){
        setWorkings("9");
    }
    public void eightOnClick(View view){
        setWorkings("8");
    }
    public void sevenOnClick(View view){
        setWorkings("7");
    }
    public void sixOnClick(View view){
        setWorkings("6");
    }
    public void fiveOnClick(View view){
        setWorkings("5");
    }
    public void fourOnClick(View view){
        setWorkings("4");
    }
    public void threeOnClick(View view){
        setWorkings("3");
    }
    public void twoOnClick(View view){
        setWorkings("2");
    }
    public void oneOnClick(View view){
        setWorkings("1");
    }
    public void zeroOnClick(View view){
        setWorkings("0");
    }
    public void divideOnClick(View view){
        setWorkings("/");
    }
    public void multiplyOnClick(View view){
        setWorkings("*");
    }
    public void minusOnClick(View view){
        setWorkings("-");
    }
    public void plusOnClick(View view){
        setWorkings("+");
    }
    public void dotOnClick(View view){
        setWorkings(".");
    }


}
