package com.example.proyectoandroidugel.layouts;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.models.Noticia;

import java.util.List;

public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaAdapter.ViewHolder> {

    private List<Noticia> noticias;
    private Context context;

    public NoticiaAdapter(List<Noticia> noticias,Context context) {
        this.noticias = noticias;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticiaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_noticias,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticiaAdapter.ViewHolder holder, int position) {
        holder.txvTitulo.setText(noticias.get(position).getTitulo());
        holder.txvContenido.setText(noticias.get(position).getPortada());
        Glide.with(context).load(noticias.get(position).getImagen()).into(holder.img);
        String url = noticias.get(position).getUrl();

        holder.btnIrVer.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txvTitulo,txvContenido;
        private ImageView img;
        private Button btnIrVer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvTitulo = itemView.findViewById(R.id.txvTituloNoticia);
            txvContenido = itemView.findViewById(R.id.txvContenidoNoticia);
            img = itemView.findViewById(R.id.imvNoticia);
            btnIrVer = itemView.findViewById(R.id.btnVerPublicacion);
        }
    }
}
