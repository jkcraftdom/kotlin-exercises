package com.example.miapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= (EditText)findViewById(R.id.et_1);

    }

    public void Navegar(View view){
        Intent i = new Intent(MainActivity.this , WebSiteExample.class);
        i.putExtra("sitioweb",ed1.getText().toString());
        startActivity(i);
    }
    public void Crear(View view){
        Intent i = new Intent(MainActivity.this, CrearManga.class);
        startActivity(i);
    }
}
