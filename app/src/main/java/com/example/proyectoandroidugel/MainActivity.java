package com.example.proyectoandroidugel;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.text.Layout;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

import com.android.volley.toolbox.Volley;
import com.example.proyectoandroidugel.models.Usuario;
import com.example.proyectoandroidugel.services.ApiHelper;
import com.example.proyectoandroidugel.views.DashboardActivity;
import com.example.proyectoandroidugel.views.admin.DashboardAdminActivity;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private RequestQueue queue;
    private EditText edtUser,edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Llamamos a los enlaces
        enlaceControles();

        btnLogin.setOnClickListener(v -> {
            String user = edtUser.getText().toString();
            String pass = edtPass.getText().toString();
            if (user.trim().equals("")){
                edtUser.setError("Complete el campo");
            }else if (pass.trim().equals("")){
                edtPass.setError("No se permiten espacios en blanco");
            }else{
                loginSistema(user,pass);
            }
        });
    }

    // Enlzamos los elementos del Layout
    private void enlaceControles() {
        btnLogin = findViewById(R.id.btnLogin);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        queue = new ApiHelper(this).conectedApi();
    }

    private void loginSistema(String user,String pass) {
        String url = ApiHelper.getAPI()+"/api/login";
        JSONObject params = new JSONObject();
        try {
            params.put("nick", user);
            params.put("pass", pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, params,
                response -> {
                    try {
                        String status = response.getString("status");
                        if (status.equals("ok")){
                            String token = "Bearer "+response.getString("token");
                            String rol = response.getString("rol");
                            if (rol.equals("admin")){
                                Intent admin = new Intent(this, DashboardAdminActivity.class);
                                admin.putExtra("TOKEN",token);
                                startActivity(admin);
                            }else {
                                Intent client = new Intent(this, DashboardActivity.class);
                                client.putExtra("TOKEN",token);
                                startActivity(client);
                            }
                        }else {
                            Toast.makeText(this, "Los datos son incorrectos", Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e) {
                        Toast.makeText(this, "Ocurrio un problema", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    Log.i("ERROR", error.getMessage());
                    Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                });
        queue.add(request);
    }
}