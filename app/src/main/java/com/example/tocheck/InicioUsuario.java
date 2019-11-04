package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicioUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_usuario);
    }


    public void pasarPantallaPrimeraUsuario(View view) {
        Intent intent = new Intent(this, PrimeraPantallaUsuario.class);
    }
    public void registro(View view) {
        Intent intent= new Intent(this,RegistroUsuario .class);

        this.startActivity(intent);
    }
}
