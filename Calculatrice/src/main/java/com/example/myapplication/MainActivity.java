package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textR;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textR = findViewById(R.id.et_calc);

    }

    public void vider(View view) {

        textR.setText("");
    }




    public void afiche1(View view){
        btn=findViewById(R.id.bt_1);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afiche2(View view){
        btn=findViewById(R.id.bt_2);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afiche3(View view){
        btn=findViewById(R.id.bt_3);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afiche4(View view){
        btn=findViewById(R.id.bt_4);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afiche5(View view){
        btn=findViewById(R.id.bt_5);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afiche6(View view){
        btn=findViewById(R.id.bt_6);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afiche7(View view){
        btn=findViewById(R.id.bt_7);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afiche8(View view){
        btn=findViewById(R.id.bt_8);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afiche9(View view){
        btn=findViewById(R.id.bt_9);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void aficheP(View view){
        btn=findViewById(R.id.btn_P);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void aficheS(View view){
        btn=findViewById(R.id.btn_S);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void aficheM(View view){
        btn=findViewById(R.id.btn_M);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afichePT(View view){
        btn=findViewById(R.id.bt_dot);
        String somme=btn.getText().toString();
        textR.append(somme);
    }


    public void aficheD(View view){
        btn=findViewById(R.id.btn_D);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void afiche0(View view){
        btn=findViewById(R.id.bt_0);
        String somme=btn.getText().toString();
        textR.append(somme);
    }
    public void aficheE(View view){
        String name=textR.getText().toString();
        if(name.contains("+")){
            Float a=Float.valueOf(name.split("\\+")[0]);
            Float b=Float.valueOf(name.split("\\+")[1]);
            textR.setText(String.valueOf(a+b));
        }
        if(name.contains("*")){
            float a=Float.valueOf(name.split("\\*")[0]);
            float b=Float.valueOf(name.split("\\*")[1]);
            textR.setText(String.valueOf(a*b));
        }
        if(name.contains("/")){
            float a=Float.valueOf(name.split("\\/")[0]);
            float b=Float.valueOf(name.split("\\/")[1]);
            textR.setText(String.valueOf(a/b));
        }
        if(name.contains("-")){
            float a=Float.valueOf(name.split("\\-")[0]);
            float b=Float.valueOf(name.split("\\-")[1]);
            textR.setText(String.valueOf(a-b));
        }    }

    }
