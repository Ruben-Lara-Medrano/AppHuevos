package com.example.apphuevos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsercionHuevo extends AppCompatActivity {
    private CalendarView calendario;
    private int numeroDeHuevos;
    private EditText peso;
    private EditText color;
    private EditText diametroAltura;
    private EditText diametroAncho;
    private DatabaseReference myRef;
    private FirebaseDatabase database;
private TextView fechaHuevo;
    private Object registroHuevos;
    private FirebaseAuth mAuth;
    private Button guardar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insercion_huevo);

        calendario = findViewById(R.id.calendario);
        fechaHuevo = findViewById(R.id.fechaCalendario);
        peso = findViewById(R.id.pesoHuevo);
        color = findViewById(R.id.ColorHuevo);
        diametroAltura = findViewById(R.id.AlturaHuevo);
        diametroAncho = findViewById(R.id.AnchoHuevo);
        guardar = findViewById(R.id.btnInsertarHuevo);

        //referenciamos la base de datos de firebase
         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("registro huevos");

        //Instanciamos mAuth
        mAuth = FirebaseAuth.getInstance();

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String fechaSeleccionada = dayOfMonth+"/"+month+"/"+year;
                fechaHuevo.setText(fechaSeleccionada);

            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroDeHuevos++;
                insercionHuevos(fechaHuevo.getText().toString(),color.getText().toString(),numeroDeHuevos,Double.parseDouble( peso.getText().toString()),Double.parseDouble(diametroAltura.getText().toString()),Double.parseDouble(diametroAncho.getText().toString()));
            }
        });
    }

            public void insercionHuevos (String fecha, String color, int numeroHuevos, double peso, double diametroAltura, double diametroAncho){
                registroHuevos registroHuevosDiarios = new registroHuevos(fecha ,color, numeroDeHuevos, peso,diametroAltura,diametroAncho);
                if(mAuth.getCurrentUser()!=null){
                    myRef.child(mAuth.getUid()).setValue(registroHuevos);
                }

    }
}