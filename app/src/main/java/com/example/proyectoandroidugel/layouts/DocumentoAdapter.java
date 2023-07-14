package com.example.proyectoandroidugel.layouts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.models.Documento;

import java.util.List;

public class DocumentoAdapter extends RecyclerView.Adapter<DocumentoAdapter.ViewHolder> {

    List<Documento> documentos;
    Context context;

    public DocumentoAdapter(List<Documento> documentos, Context context) {
        this.documentos = documentos;
        this.context = context;
    }

    @NonNull
    @Override
    public DocumentoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_documento,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentoAdapter.ViewHolder holder, int position) {
        holder.nombre.setText(documentos.get(position).getNombre());
        holder.fecha.setText(documentos.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return documentos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,fecha;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtNombre);
            fecha = itemView.findViewById(R.id.txtFecha);
        }
    }
}