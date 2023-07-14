package com.example.proyectoandroidugel.views.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.layouts.DocumentoAdapter;

import com.example.proyectoandroidugel.models.Documento;
import com.example.proyectoandroidugel.services.ApiHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResolucionesActivity extends AppCompatActivity {
    private List<Documento> documentos;
    private RecyclerView rcvDocumento;
    private DocumentoAdapter documentoAdapter;
    private String token;
    private RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resoluciones);

        documentos = new ArrayList<>();
        rcvDocumento = findViewById(R.id.rcvResoluciones);
        rcvDocumento.setLayoutManager(new LinearLayoutManager(this));
        queue = new ApiHelper(this).conectedApi();
        Intent intent = getIntent();
        if (intent != null) {
            token = intent.getStringExtra("TOKEN");
            listar();
        }
    }

    private void listar() {
        String url = ApiHelper.getAPI()+"/api/documento/user";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url,null, response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject item = response.getJSONObject(i);
                    Documento documento = new Documento();
                    documento.setId(item.getInt("id_documento"));
                    documento.setNombre(item.getString("nombre"));
                    documento.setFecha(item.getString("fecha_envio"));
                    documentos.add(documento);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            documentoAdapter = new DocumentoAdapter(documentos,this);
            rcvDocumento.setAdapter(documentoAdapter);
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
}