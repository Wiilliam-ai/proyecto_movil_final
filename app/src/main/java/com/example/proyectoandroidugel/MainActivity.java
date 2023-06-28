package com.example.proyectoandroidugel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.proyectoandroidugel.views.DashboardActivity;
import com.example.proyectoandroidugel.views.RegistrarCuentaActivity;
public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Llamamos a los enlaces
        enlaceControles();

        btnLogin.setOnClickListener(v -> {
            Intent dashboard = new Intent(this,DashboardActivity.class);
            startActivity(dashboard);
        });
    }

    // Enlzamos los elementos del Layout
    private void enlaceControles(){
        btnLogin = findViewById(R.id.btnLogin);
    }
}