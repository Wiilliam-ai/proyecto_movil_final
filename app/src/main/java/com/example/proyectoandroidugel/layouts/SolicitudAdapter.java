package com.example.proyectoandroidugel.layouts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.models.Solicitud;

import java.util.List;

public class SolicitudAdapter extends RecyclerView.Adapter<SolicitudAdapter.ViewHolder> {

    List<Solicitud> solicitudes;
    Context context;

    public SolicitudAdapter(List<Solicitud> solicitudes, Context context) {
        this.solicitudes = solicitudes;
        this.context = context;
    }

    @NonNull
    @Override
    public SolicitudAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_solicitud,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SolicitudAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return solicitudes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
