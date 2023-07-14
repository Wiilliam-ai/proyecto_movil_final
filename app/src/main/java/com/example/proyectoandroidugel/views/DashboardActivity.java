package com.example.proyectoandroidugel.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.models.Docente;
import com.example.proyectoandroidugel.services.DocenteService;
import com.example.proyectoandroidugel.views.client.ContratosActivity;
import com.example.proyectoandroidugel.views.client.NoticiasActivity;
import com.example.proyectoandroidugel.views.client.ResolucionesActivity;
import com.example.proyectoandroidugel.views.client.SolicitudesActivity;

public class DashboardActivity extends AppCompatActivity {

    private CardView btnIrNoticias,btnIrResoluciones,btnIrContratos,btnIrSolicitudes;
    private TextView txvName,txvDni,txvCodigoM,txvCondicion,txvCargo;
    DocenteService docenteService;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        enlaceControles();

        btnIrNoticias.setOnClickListener(this::navegarPantalla);
        btnIrResoluciones.setOnClickListener((this::navegarPantalla));
        btnIrContratos.setOnClickListener(this::navegarPantalla);
        btnIrSolicitudes.setOnClickListener(this::navegarPantalla);

        docenteService = new DocenteService(this);
        llamarDatoDocente();
    }

    private void llamarDatoDocente(){
        docenteService.litarDocentes(token,new DocenteService.DocenteCallback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDocenteLoaded(Docente docente) {
                // Datos del docente disponibles
                txvName.setText(docente.getNombre()+" "+docente.getApellido());
                txvDni.setText(docente.getDni());
                txvCodigoM.setText(docente.getCodigoModular());
                txvCondicion.setText(docente.getCodicion());
                txvCargo.setText(docente.getCargo());
            }

            @Override
            public void onError() {
                // Manejo de error
                Toast.makeText(DashboardActivity.this, "Error al cargar los datos del docente", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void enlaceControles(){
        // enlace de botones
        btnIrNoticias = findViewById(R.id.btnIrNoticia);
        btnIrResoluciones = findViewById(R.id.btnIrResolicion);
        btnIrContratos = findViewById(R.id.btnIrContrato);
        btnIrSolicitudes = findViewById(R.id.btnIrSolicitud);

        // enlace de textos
        txvName = findViewById(R.id.txvName);
        txvDni = findViewById(R.id.txvDni);
        txvCodigoM = findViewById(R.id.txvCodigoM);
        txvCondicion = findViewById(R.id.txvCondicion);
        txvCargo = findViewById(R.id.txvCargo);

        Intent intent = getIntent();
        if (intent != null) {
            token = intent.getStringExtra("TOKEN");
        }
    }
    @SuppressLint("NonConstantResourceId")
    private void navegarPantalla(View v){
        Intent intent;
        int id = v.getId();
        if (id == R.id.btnIrNoticia){
            intent = new Intent(this, NoticiasActivity.class);
            intent.putExtra("TOKEN",token);
            startActivity(intent);
        } else if (id == R.id.btnIrResolicion) {
            intent = new Intent(this, ResolucionesActivity.class);
            intent.putExtra("TOKEN",token);
            startActivity(intent);
        } else if (id == R.id.btnIrContrato) {
            intent = new Intent(this, ContratosActivity.class);
            intent.putExtra("TOKEN",token);
            startActivity(intent);
        } else if (id == R.id.btnIrSolicitud) {
            intent = new Intent(this, SolicitudesActivity.class);
            intent.putExtra("TOKEN",token);
            startActivity(intent);
        }
    }
}