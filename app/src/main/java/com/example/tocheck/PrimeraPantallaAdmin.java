package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static com.example.tocheck.R.color.colorBlanco;
import static com.example.tocheck.R.color.colorNegro;

public class PrimeraPantallaAdmin extends AppCompatActivity {
private ConstraintLayout constPrimeraAdmin;
private Preferencias pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla_admin);
        constPrimeraAdmin=(ConstraintLayout) findViewById(R.id.constraintInicioAdmin);


        //ERROR AL EJECUTAR LA APP CON LAS PREFERENCIAS ACTIVADAS
      /*  pref=new Preferencias();
        if(pref.getBoolean(this,"fondoActivado",true)){
            constPrimeraAdmin.setBackgroundResource(R.color.colorNegro);
        }else{
            constPrimeraAdmin.setBackgroundResource(colorBlanco);
        }*/

    }

    public void pantallaQR(View view) {
        Intent intent = new Intent(this, PantallaQR.class);
        this.startActivity(intent);
    }

    public void pantallaMapa(View view) {
        Intent intent = new Intent(this, Mapa.class);
        this.startActivity(intent);
    }
    public void pantallaUsuarios(View view) {
        Intent intent = new Intent(this, ColsultaUsuario.class);
        this.startActivity(intent);
    }
}
