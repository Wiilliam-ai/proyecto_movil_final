package com.example.proyectoandroidugel.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proyectoandroidugel.models.Docente;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class DocenteService {

    private Context context;

    private RequestQueue queue;
    Docente docente = new Docente();

    public DocenteService(Context context) {
        this.context = context;
        this.queue = new ApiHelper(context).conectedApi();
    }

    public interface DocenteCallback {
        void onDocenteLoaded(Docente docente);
        void onError();
    }


    public void litarDocentes(String token,DocenteCallback callback){
        String apiDocentes = ApiHelper.getAPI()+"/api/persona";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,apiDocentes,null,response -> {
            docente.setId(response.optInt("id_persona"));
            docente.setNombre(response.optString("nombre"));
            docente.setApellido(response.optString("apellido"));
            docente.setDni(response.optString("dni"));
            docente.setCodigoModular(response.optString("codigo_modular"));
            docente.setCodicion(response.optString("nombre_condicion"));
            docente.setCargo(response.optString("nombre_cargo"));
            callback.onDocenteLoaded(docente);
        },error -> {
            callback.onError();
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

    public Docente getDocente() {
        return docente;
    }
}
