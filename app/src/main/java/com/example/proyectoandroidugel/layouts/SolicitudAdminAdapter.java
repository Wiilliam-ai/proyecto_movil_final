package com.example.proyectoandroidugel.layouts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.models.SolicitudAdmin;

import java.util.List;

public class SolicitudAdminAdapter extends RecyclerView.Adapter<SolicitudAdminAdapter.ViewHolder>{
    List<SolicitudAdmin> solicitudes;
    Context context;

    public SolicitudAdminAdapter(List<SolicitudAdmin> solicitudes, Context context) {
        this.solicitudes = solicitudes;
        this.context = context;
    }

    @NonNull
    @Override
    public SolicitudAdminAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_solicitud_admin,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SolicitudAdminAdapter.ViewHolder holder, int position) {
        holder.txtSolicitud.setText(solicitudes.get(position).getSolicitud());
        holder.txtFecha.setText(solicitudes.get(position).getFecha());
        holder.txtNombreS.setText(solicitudes.get(position).getNombre());
        holder.txtDni.setText(solicitudes.get(position).getDni());
        holder.txtEstado.setText(solicitudes.get(position).getEstado());
    }

    @Override
    public int getItemCount() {
        return solicitudes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSolicitud,txtFecha,txtNombreS,txtDni,txtEstado;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSolicitud = itemView.findViewById(R.id.txtSolicitud);
            txtFecha =itemView.findViewById(R.id.txtFecha);
            txtNombreS= itemView.findViewById(R.id.txtNombreS);
            txtDni = itemView.findViewById(R.id.txtDni);
            txtEstado = itemView.findViewById(R.id.txtEstado);
        }
    }
}
