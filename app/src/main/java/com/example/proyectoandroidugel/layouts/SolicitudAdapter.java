package com.example.proyectoandroidugel.layouts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
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

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull SolicitudAdapter.ViewHolder holder, int position) {
        String nombre = "TIPO: " + solicitudes.get(position).getNombre();
        String codigo = "CODIGO: " + solicitudes.get(position).getCodigo();
        String fecha = "FECHA: " + solicitudes.get(position).getFecha();
        String estado = solicitudes.get(position).getEstado();
        holder.txvSolicitudU.setText(nombre);
        holder.txvCodigoSU.setText(codigo);
        holder.txvFechaU.setText(fecha);
        holder.txvEstadoU.setText(estado);
    }

    @Override
    public int getItemCount() {
        return solicitudes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txvCodigoSU,txvSolicitudU,txvFechaU,txvEstadoU;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvSolicitudU = itemView.findViewById(R.id.txvTipoS);
            txvCodigoSU = itemView.findViewById(R.id.txvCodigoS);
            txvFechaU = itemView.findViewById(R.id.txvFechaS);
            txvEstadoU = itemView.findViewById(R.id.txvEstadoS);
        }
    }
}
