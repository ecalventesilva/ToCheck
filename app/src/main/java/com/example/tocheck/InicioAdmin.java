package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InicioAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_admin);
    }

    public void PantallaInicioAdmin(View view) {
        Intent intent= new Intent(this,PrimeraPantallaAdmin .class);
        this.startActivity(intent);
    }
}
