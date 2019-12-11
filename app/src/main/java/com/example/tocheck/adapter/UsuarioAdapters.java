package com.example.tocheck.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tocheck.R;
import com.example.tocheck.modelo.Usuario;

import java.util.ArrayList;

import io.opencensus.resource.Resource;

public class UsuarioAdapters extends RecyclerView.Adapter<UsuarioAdapters.ViewHolder> {
private int resourse;
private ArrayList<Usuario> usuarioList;

public UsuarioAdapters(ArrayList<Usuario> usuario, int resourse){
this.usuarioList=usuario;
this.resourse=resourse;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resourse,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Usuario usuario= usuarioList.get(position);
        viewHolder.textViewUsuario.setText("Nombre trabajador: "+usuario.getNombre()+" , Email del trabajador: "+ usuario.getEmail()+" y su DNI es: "+usuario.getDni()+"\n");
    }

    @Override
    public int getItemCount() {
        return usuarioList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
            private TextView textViewUsuario;
            private View view;

        public ViewHolder( View itemView) {
            super(itemView);
            this.view=itemView;
            this.textViewUsuario= view.findViewById(R.id.textViewUsuario);
        }
    }

}
