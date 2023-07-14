package com.example.proyectoandroidugel.views.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectoandroidugel.MainActivity;
import com.example.proyectoandroidugel.R;
import com.example.proyectoandroidugel.services.ApiHelper;
import com.example.proyectoandroidugel.views.DashboardActivity;
import com.example.proyectoandroidugel.views.admin.DashboardAdminActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SolicitudActivity extends AppCompatActivity {
    private RequestQueue queue;
    private String token;
    private EditText edtMotivo;
    private Spinner snpTipo;
    private Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud);
        edtMotivo = findViewById(R.id.edtMotivo);
        snpTipo = findViewById(R.id.spnTipo);
        btnEnviar = findViewById(R.id.btnEnviar);
        queue = Volley.newRequestQueue(this);
        Intent intent = getIntent();
        if (intent != null) {
            token = intent.getStringExtra("TOKEN");
        }
        
        btnEnviar.setOnClickListener(v -> {
            int tipo = snpTipo.getSelectedItemPosition();
            String motivo = edtMotivo.getText().toString();
            if (tipo == 0){
                Toast.makeText(this, "Seleccione un tipo", Toast.LENGTH_SHORT).show();
            }else if (motivo.trim().equals("")){
                Toast.makeText(this, "Complete motivo", Toast.LENGTH_SHORT).show();
            }else{
                procesarSolicitud(motivo,tipo);
                Toast.makeText(this, "Se a solicitado correctamente", Toast.LENGTH_SHORT).show();
                edtMotivo.setText("");
            }
        });
    }

    private void procesarSolicitud(String motivo,int tipo) {
        String url = ApiHelper.getAPI()+"/api/solicitud";
        JSONObject params = new JSONObject();
        try {
            params.put("motivo", motivo);
            params.put("tipo", tipo);
            params.put("estado", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, params, response -> {

        }, error -> {
            Log.i("ERROR", error.getMessage());
            Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
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