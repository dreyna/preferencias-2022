package com.example.loginpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox checkBox;
    private Button boton;
    private String clave = "sesion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences("sesiones",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        checkBox = findViewById(R.id.chbguardar);
        boton = findViewById(R.id.btnlogin);
        if(validarSesion()){
            startActivity(new Intent(this,PrincipalActivity.class));
        }else{
            String mensaje= "Autentificarse";
            Toast.makeText(this,mensaje, Toast.LENGTH_LONG).show();
        }
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos(checkBox.isChecked());
                startActivity(new Intent(getApplicationContext(),PrincipalActivity.class));
            }
        });
    }
    private void guardarDatos(boolean checked){
        editor.putBoolean(clave,checked);
        editor.apply();
    }
    private boolean validarSesion(){
        return this.sharedPreferences.getBoolean(clave,false);
    }
}