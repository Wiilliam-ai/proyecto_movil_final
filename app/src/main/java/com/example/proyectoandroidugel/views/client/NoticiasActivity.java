package com.example.proyectoandroidugel.views.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.layouts.NoticiaAdapter;
import com.example.proyectoandroidugel.models.Noticia;

import java.util.ArrayList;
import java.util.List;

public class NoticiasActivity extends AppCompatActivity {
    private List<Noticia> noticias;
    private RecyclerView rcvNoticias;
    private NoticiaAdapter noticiaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        rcvNoticias = findViewById(R.id.rcvNoticias);
        rcvNoticias.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        listarNoticias();
    }

    private void listarNoticias(){
        noticias = new ArrayList<>();
        noticias.add(new Noticia("Primer Titulo","Primera portada important","https://elcomercio.pe/resizer/ub73Cui-mY8z11ahc1Pt2b1NZfk=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/W453Q76V7FELBGSV2BZNDZJI2M.jpg","https://www.google.com.pe/?hl=es"));
        noticias.add(new Noticia("Primer Titulo","Primera portada important","https://elcomercio.pe/resizer/ub73Cui-mY8z11ahc1Pt2b1NZfk=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/W453Q76V7FELBGSV2BZNDZJI2M.jpg","https://www.google.com.pe/?hl=es"));
        noticias.add(new Noticia("Primer Titulo","Primera portada important","https://elcomercio.pe/resizer/ub73Cui-mY8z11ahc1Pt2b1NZfk=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/W453Q76V7FELBGSV2BZNDZJI2M.jpg","https://www.google.com.pe/?hl=es"));
        noticiaAdapter = new NoticiaAdapter(noticias,this);
        rcvNoticias.setAdapter(noticiaAdapter);
    }

    public void regresarPantalla(View view) {
        onBackPressed();
    }
}