package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void accederUsuario(View view) {
        Intent intent= new Intent(this,InicioUsuario.class);
        this.startActivity(intent);
    }
}
