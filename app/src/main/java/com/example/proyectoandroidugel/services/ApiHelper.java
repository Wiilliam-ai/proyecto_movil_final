package com.example.proyectoandroidugel.services;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class ApiHelper {
    private static final String API = "https://api-ugel.onrender.com";
    private Context context;

    public ApiHelper(Context context){
        this.context= context;
    }

    public RequestQueue conectedApi(){
        RequestQueue queue = Volley.newRequestQueue(context);
        return queue;
    }

    public static String getAPI() {
        return API;
    }
}
