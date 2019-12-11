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
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;

public class InicioAdmin extends AppCompatActivity {
private String email="";
private String contraseña="";
private EditText textoEmail;
private EditText textoContraseña;
private Button botonLogin;
private FirebaseAuth maAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_admin);

        textoEmail=findViewById(R.id.textoUsuarioAdmin);
        textoContraseña=findViewById(R.id.textoContraseñaAdmin);
        botonLogin=findViewById(R.id.botonLoginAdmin);
        maAuth= FirebaseAuth.getInstance();
    }

    public void PantallaInicioAdmin(View view) {
        email=textoEmail.getText().toString();
        contraseña=textoContraseña.getText().toString();
    if(!email.isEmpty()&& !contraseña.isEmpty()){
        loginAdmin();
    }else {
        Toast.makeText(this, "El usuario o la contraseña esta vacío", Toast.LENGTH_SHORT).show();
    }

    }
    private void loginAdmin() {
        maAuth.signInWithEmailAndPassword(email,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(InicioAdmin.this, PrimeraPantallaAdmin.class));
                    finish();
                    Toast.makeText(InicioAdmin.this, "Bienvenido "+textoEmail.getText().toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(InicioAdmin.this, "Error, no se puedo iniciar sesión, comprube los datos ", Toast.LENGTH_SHORT).show();
                }
            }
});
    }
}
