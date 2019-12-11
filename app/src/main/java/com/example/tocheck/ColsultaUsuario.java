package com.example.tocheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tocheck.adapter.UsuarioAdapters;
import com.example.tocheck.modelo.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ColsultaUsuario extends AppCompatActivity {
private TextView textoConsultaa;
private DatabaseReference databaseReference;
private UsuarioAdapters usuarioAdapters;
private RecyclerView recyclerView;
private ArrayList<Usuario> mUsuarios=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colsulta_usuario);
        textoConsultaa=findViewById(R.id.textViewUsuario);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference.child("usuario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if(dataSnapshot.exists()){
                String nombre= dataSnapshot.child("nombre").getValue().toString();
                String email=dataSnapshot.child("email").getValue().toString();
                String dni=dataSnapshot.child("dni").getValue().toString();
                textoConsultaa.setText("Usuario: "+nombre+", email: "+email+"y su DNI: "+dni);

            }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
  getUsuarioFromFirebase();  }


    private void getUsuarioFromFirebase(){
databaseReference.child("Usuario").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()){

            for(DataSnapshot ds:dataSnapshot.getChildren()){
            String nombre=ds.child("nombre").getValue().toString();
                String email=ds.child("email").getValue().toString();
                String dni=ds.child("dni").getValue().toString();
            mUsuarios.add(new Usuario(nombre,email,dni));
            }
usuarioAdapters=new UsuarioAdapters(mUsuarios,R.layout.usuario_lista);
            recyclerView.setAdapter(usuarioAdapters);
        }else{
            Toast.makeText(ColsultaUsuario.this, "Erros ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
    }
}
