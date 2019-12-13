package com.example.tocheck;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.Button;


public class Preferencias extends PreferenceActivity {
    private static final String KEY_NOMBRE="fondoActivado";
    private Button button;
    private Boolean valorFondoActivado = true;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        button=findViewById(R.id.button2);
        addPreferencesFromResource(R.xml.preferencias);
    }
    //PREFERENCIA PARA CAMBIAR EL FONDO A MODO OSCURO
   /* public void preferenciaCambiarFondo(Boolean valor){

        if(valorFondoActivado){
            //SI EL FONDO ESTA ACTIVO, EL COLOR DE FONDO SE ESTABLECE A NEGRO
            button.setBackgroundResource(R.color.colorNegro);
        }else{
            button.setBackgroundResource(R.color.colorNegro);
        }
    }*/

    //FUNCION QUE DEVUELVE UN BOOLEAN (TRUE -> FONDO ACTIVADO      FALSE-> FONDO DESACTIVADO)
    public boolean getBoolean(Context context, final String key, final boolean defaultValue){
        SharedPreferences shaPre= PreferenceManager.getDefaultSharedPreferences(context);
        return shaPre.getBoolean("fondoActivado",false);
    }



    @Override
    public void onBackPressed() {
        Intent i=new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        super.onBackPressed();
    }
}
