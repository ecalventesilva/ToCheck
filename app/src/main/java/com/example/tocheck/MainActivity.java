package com.example.tocheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Preferencias pref;
    private ConstraintLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main=findViewById(R.id.main);


        pref=new Preferencias();
        if(pref.getBoolean(this,"fondoActivado",true)){
            main.setBackgroundResource(R.color.colorNegro);

        }else{
            main.setBackgroundResource(R.color.colorBlanco);

        }
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


}
