package com.example.tocheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class InicioUsuario extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewRegistro;

    private String email="";
    private String password="";

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_usuario);

        editTextUsuario=(EditText) findViewById(R.id.editTextUsuario);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);
        buttonLogin=(Button) findViewById(R.id.buttonLogin);
        textViewRegistro=(TextView) findViewById(R.id.textViewRegistro);

        mAuth= FirebaseAuth.getInstance();
    }
    public void pasarPantallaPrimeraUsuario(View view) {
        email=editTextUsuario.getText().toString();
        password=editTextPassword.getText().toString();

        if(!email.isEmpty()&&!password.isEmpty()){
            loginUsuario();
        }else{
            Toast.makeText(this,"Por favor, rellene los campos.",Toast.LENGTH_LONG).show();
        }
    }

    private void loginUsuario() {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(InicioUsuario.this,PrimeraPantallaUsuario.class));
                    finish();
                    Toast.makeText(InicioUsuario.this,"Bienvenido "+editTextUsuario.getText().toString(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(InicioUsuario.this,"Error, no se pudo iniciar sesión. Por favor, revise los campos.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    public void registrar(View view) {
        Intent intent= new Intent(this,RegistroUsuario.class);
        this.startActivity(intent);
    }
}
