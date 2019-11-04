package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrimeraPantallaAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla_admin);
    }

    public void pantallaQR(View view) {
        Intent intent = new Intent(this, PantallaQR.class);
        this.startActivity(intent);
    }
}
