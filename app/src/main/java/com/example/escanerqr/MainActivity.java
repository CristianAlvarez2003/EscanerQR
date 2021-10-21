package com.example.escanerqr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    TextView tv_mostrarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tv_mostrarDatos = findViewById(R.id.txt);

    }
    // Metodo onclick
    public void Onclick(View view) {
        if(view.getId() == R.id.AbrirScanner){
            new IntentIntegrator(this).initiateScan();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Llamar a la información
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        //Obtener la información en un String
        String datos = result.getContents();
        tv_mostrarDatos.setText(datos);

    }
}