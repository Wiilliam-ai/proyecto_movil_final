package com.example.proyectoandroidugel.views.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.proyectoandroidugel.R;

public class EnviarSolicitudActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_solicitud);
    }

    public void regresarPantalla(View view) {
        onBackPressed();
    }
}