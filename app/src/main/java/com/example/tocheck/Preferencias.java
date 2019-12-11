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


//Aún sin terminar...

public class Preferencias extends PreferenceActivity {

    private static final String KEY_NOMBRE="fondoActivado";
    private Button button;
    private Boolean valorFondoActivado = true;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        button=findViewById(R.id.button2);
        addPreferencesFromResource(R.xml.preferencias);
    }

    public void preferenciaCambiarFondo(Boolean valor){

        if(valorFondoActivado){
            button.setBackgroundResource(R.color.colorNegro);

        }else{
            button.setBackgroundResource(R.color.colorNegro);
        }
    }


    public static boolean getBoolean(Context context, final String key, final boolean defaultValue){
        SharedPreferences shaPre= PreferenceManager.getDefaultSharedPreferences(context);
        return shaPre.getBoolean("fondoActivado",true);
    }

    /*
    public static void setBoolean(Context context, final String key, final boolean value){
        SharedPreferences shaPre=PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = shaPre.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    public static String getKeyNombre() {
        return KEY_NOMBRE;
    }
    */
}
