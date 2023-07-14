package com.example.proyectoandroidugel.views.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.layouts.SolicitudAdminAdapter;
import com.example.proyectoandroidugel.models.SolicitudAdmin;
import com.example.proyectoandroidugel.services.ApiHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolicitudesAdminActivity extends AppCompatActivity {
    private List<SolicitudAdmin> solicitudes;
    private RecyclerView rcvSolicitud;
    private SolicitudAdminAdapter solicitudAdapter;
    private String token;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes_admin);
        solicitudes = new ArrayList<>();
        rcvSolicitud = findViewById(R.id.rcvSoli);
        rcvSolicitud.setLayoutManager(new LinearLayoutManager(this));
        queue = new ApiHelper(this).conectedApi();
        Intent intent = getIntent();
        if (intent != null) {
            token = intent.getStringExtra("TOKEN");
            listar();
        }
    }

    private void listar() {
        String url = ApiHelper.getAPI()+"/api/solicitud";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject item = response.getJSONObject(i);
                    SolicitudAdmin solicitud = new SolicitudAdmin();
                    solicitud.setSolicitud(item.getString("solicitud"));
                    solicitud.setNombre(item.getString("nombre"));
                    solicitud.setFecha(item.getString("fecha"));
                    solicitud.setDni(item.getString("dni"));
                    solicitud.setEstado(item.getString("estado"));
                    solicitudes.add(solicitud);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            solicitudAdapter = new SolicitudAdminAdapter(solicitudes,this);
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
}