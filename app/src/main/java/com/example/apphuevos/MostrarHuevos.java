package com.example.apphuevos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarHuevos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_huevos);

        TextView txvDate = findViewById(R.id.txvDia);
        Button btnCalendario = findViewById(R.id.btnCalendario);

        String date = getIntent().getStringExtra("date");
        if(date!=null){
            txvDate.setText(date);
        }

        btnCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarH_calendario = new Intent(MostrarHuevos.this, Calendario.class);
                startActivity(mostrarH_calendario);
            }
        });
    }
}