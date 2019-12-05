package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencias=findViewById(R.id.button2);




    }

    public void accederUsuario(View view) {
        Intent intent= new Intent(this,InicioUsuario.class);
        this.startActivity(intent);
    }

    public void accederAdmin(View view) {
        Intent intent= new Intent(this,InicioAdmin.class);
        this.startActivity(intent);
    }

    public void preferencias(View view) {
        Intent intent= new Intent(this,Preferencias.class);
        this.startActivity(intent);

    }
    public void cambiarFondo(Boolean valor){
        if(valor){
            preferencias.setBackgroundResource(R.color.colorBlanco);

        }else{
            preferencias.setBackgroundResource(R.color.colorSecundary);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
