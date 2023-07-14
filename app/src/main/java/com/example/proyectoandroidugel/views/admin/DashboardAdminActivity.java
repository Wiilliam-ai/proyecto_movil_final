package com.example.proyectoandroidugel.views.admin;

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

public class DashboardAdminActivity extends AppCompatActivity {
    // NOmbre Dni Cargo

    private CardView btnIrUsuarios,btnIrSolicitudes;
    private TextView txvName,txvDni,txvCargo;
    private String token;
    DocenteService docenteService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);
        enlaceControles();

        btnIrUsuarios.setOnClickListener(this::navegarPantalla);
        btnIrSolicitudes.setOnClickListener(this::navegarPantalla);
        docenteService = new DocenteService(this);
        llamarDatoAdmin();
    }

    private void llamarDatoAdmin(){
        docenteService.litarDocentes(token,new DocenteService.DocenteCallback() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDocenteLoaded(Docente docente) {
                // Datos del docente disponibles
                txvName.setText(docente.getNombre());
                txvDni.setText(docente.getDni());
                txvCargo.setText(docente.getCargo());
            }

            @Override
            public void onError() {
                // Manejo de error
                Toast.makeText(DashboardAdminActivity.this, "Error al cargar los datos del docente", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void enlaceControles(){
        // enlace de botones
        btnIrUsuarios = findViewById(R.id.btnIrUsuarios);
        btnIrSolicitudes = findViewById(R.id.btnIrSolicitud);

        // enlace de textos
        txvName = findViewById(R.id.txvNombre);
        txvDni = findViewById(R.id.txvDni);
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
        if (id == R.id.btnIrUsuarios) {
            intent = new Intent(this, RegistroUsuarioActivity.class);
            intent.putExtra("TOKEN",token);
            startActivity(intent);
        } else if (id == R.id.btnIrSolicitud) {
            intent = new Intent(this, SolicitudesAdminActivity.class);
            intent.putExtra("TOKEN",token);
            startActivity(intent);
        }
    }
}