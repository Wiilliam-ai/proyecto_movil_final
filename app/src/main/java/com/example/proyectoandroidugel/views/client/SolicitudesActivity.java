package com.example.proyectoandroidugel.views.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.layouts.NoticiaAdapter;
import com.example.proyectoandroidugel.layouts.SolicitudAdapter;
import com.example.proyectoandroidugel.models.Solicitud;
import com.example.proyectoandroidugel.services.ApiHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolicitudesActivity extends AppCompatActivity {
    private List<Solicitud> solicitudes;
    private RecyclerView rcvSolicitud;
    private SolicitudAdapter solicitudAdapter;
    private String token;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes);
        solicitudes = new ArrayList<>();
        rcvSolicitud = findViewById(R.id.rcvSolicitudes);
        rcvSolicitud.setLayoutManager(new LinearLayoutManager(this));
        queue = new ApiHelper(this).conectedApi();
        Intent intent = getIntent();
        if (intent != null) {
            token = intent.getStringExtra("TOKEN");
            listar();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void listar(){
        String url = ApiHelper.getAPI()+"/api/solicitud/user";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null,response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject item = response.getJSONObject(i);
                    Solicitud solicitud = new Solicitud();
                    solicitud.setCodigo(item.getInt("id"));
                    solicitud.setNombre(item.getString("solicitud"));
                    solicitud.setFecha(item.getString("fecha"));
                    solicitud.setEstado(item.getString("estado"));
                    solicitudes.add(solicitud);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            solicitudAdapter = new SolicitudAdapter(solicitudes,this);
            rcvSolicitud.setAdapter(solicitudAdapter);
        },error -> {

        }){
            @Override
            public Map<String, String> getHeaders(){
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization",token);
                return headers;
            }
        };
        queue.add(request);
    }

    public void regresarPantalla(View view) {
        onBackPressed();
    }

    public void irSolicitar(View view) {
        Intent intent = new Intent(this,SolicitudActivity.class);
        intent.putExtra("TOKEN",token);
        startActivity(intent);
    }
}