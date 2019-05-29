package com.example.proyecto1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Nivel_2 extends AppCompatActivity {

    int menor = 100;

    ArrayList<Button> botones = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_2);


        Button r = (Button) findViewById(R.id.reiniciar);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reiniciar();
            }
        });

        iniciar();

    }

    @SuppressLint("WrongConstant")
    public void clickBoton(Button boton) {
        menor = 100;
        boolean pasaNivel = true;
        for (Button b : botones){
            if (b.getVisibility() == View.VISIBLE){

                if (Integer.parseInt((String) b.getText())<=menor){
                    menor = Integer.parseInt((String) b.getText());

                }
            }
        }


        // Toast.makeText(this,"Hola"+ menor ,Toast.LENGTH_SHORT).show();
        if (Integer.parseInt((String)boton.getText()) == menor){

            boton.setVisibility(View.INVISIBLE);

        }
        for (Button b : botones){
            if (b.getVisibility() == View.VISIBLE){
                pasaNivel = false;
            }
        }
        if (pasaNivel){
            //Intent intent = new Intent(this, Nivel_2.class);
            //startActivity(intent);
        }
    }

    public void iniciar(){
        botones.clear();
        for (int i = 1 ; i<=20 ; i++){

            final int id = i;
            final int numero = (int) ((Math.random()*50)+1);


            final int menor2 = menor;
            final Button boton = (Button) findViewById(getResources().getIdentifier("button"+id ,"id",getPackageName()));
            boton.setVisibility(View.VISIBLE);
            boton.setText(numero+"");

            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickBoton(boton);
                }
            });

            botones.add(boton);
        }
    }

    public void reiniciar(){
        for (int i = 1 ; i<=20 ; i++){

            final int id = i;

            final Button boton = (Button) findViewById(getResources().getIdentifier("button"+id ,"id",getPackageName()));
            boton.setVisibility(View.VISIBLE);



        }
    }

}
