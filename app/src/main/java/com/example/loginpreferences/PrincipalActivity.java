package com.example.loginpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        preferences = getSharedPreferences("sesiones",Context.MODE_PRIVATE);
        editor = preferences.edit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.salir_action:
                editor.putBoolean("clave", false);
                editor.apply();
                Toast.makeText(this, "Sesión Cerrada...!", Toast.LENGTH_LONG).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}