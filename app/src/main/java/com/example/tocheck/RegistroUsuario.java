package com.example.tocheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroUsuario extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextRPass;
    private EditText editTextPass;
    private Button buttonRegistrar;


    private String nombre="";
    private String password="";
    private String rpassword="";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        mAuth=FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        editTextNombre=(EditText) findViewById(R.id.editTextPassword);
        editTextPass=(EditText) findViewById(R.id.editTextPassword);
        editTextRPass=(EditText) findViewById(R.id.editTextPassword);
        buttonRegistrar=(Button) findViewById(R.id.botonRegistrar);
    }

    public void buttonRegistrar(View view) {
        nombre=editTextNombre.getText().toString();
        password=editTextPass.getText().toString();
        rpassword=editTextRPass.getText().toString();
        
        if(!nombre.isEmpty()&&!password.isEmpty()&&!rpassword.isEmpty()){

            if(password.length()>=6 && rpassword.length()>=6){
                registrarUsuario();
            }
            else{
                Toast.makeText(this, "El password debe de tener al menos 6 caracteres.", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(this, "Por favor, complete los campos.", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(RegistroUsuario.this,InicioUsuario.class));
    }

    private void registrarUsuario() {
        mAuth.createUserWithEmailAndPassword(nombre,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){

                   Map<String,Object> map= new HashMap<>();
                   map.put("nombre",nombre);
                   map.put("password",password);
                   map.put("rpassword",rpassword);

                   String id = mAuth.getCurrentUser().getUid();
                   mDatabase.child("Usuario").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task2) {
                           if(task2.isSuccessful()){
                               startActivity(new Intent(RegistroUsuario.this,InicioUsuario.class));
                               Toast.makeText(RegistroUsuario.this, "¡Usuario registrado con éxito!", Toast.LENGTH_SHORT).show();
                               finish();
                           }
                           else{
                               Toast.makeText(RegistroUsuario.this, "Error: No se pudo registrar correctamente.", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
               else{
                   Toast.makeText(RegistroUsuario.this, "No se pudo registrar este usuario.", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}
