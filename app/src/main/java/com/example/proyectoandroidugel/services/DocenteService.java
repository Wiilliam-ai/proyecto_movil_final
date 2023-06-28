package com.example.proyectoandroidugel.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proyectoandroidugel.models.Docente;

import org.json.JSONException;

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


    public void litarDocentes(int id,DocenteCallback callback){
        String apiDocentes = ApiHelper.getAPI()+"/api2/docentes/"+id;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,apiDocentes,null,response -> {
            docente.setId(response.optInt("id"));
            docente.setNombre(response.optString("name"));
            docente.setApellido(response.optString("lastname"));
            docente.setDni(response.optString("dni"));
            docente.setCodigoModular(response.optString("modularCode"));
            docente.setCodicion(response.optString("employeCondition"));
            docente.setCargo(response.optString("charge"));
            callback.onDocenteLoaded(docente);
        },error -> {
            callback.onError();
        });
        queue.add(request);
    }

    public Docente getDocente() {
        return docente;
    }
}
