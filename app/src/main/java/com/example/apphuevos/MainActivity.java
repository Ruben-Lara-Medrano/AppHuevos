package com.example.apphuevos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //Todo en drawable - diseno_btn no funciona bien del todo ya que no pilla el color aqua que se encuentra en colors
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void InsercionHuevo (View view){
        Intent i = new Intent(this, InsercionHuevo.class);
        startActivity(i);
    }

}