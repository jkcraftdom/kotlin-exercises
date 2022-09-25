package com.example.miapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CrearManga extends AppCompatActivity {

    private EditText e_name;
    private EditText e_author;
    private EditText e_state;
    private EditText e_type;
    private EditText e_last_chapter;
    private EditText e_date_publication;
    private static final String URL = "https://2b223d912e15.ngrok.io/php-android/save.php";
    private RequestQueue rQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_manga);

        e_name = (EditText) findViewById(R.id.ed_name);
        e_author = (EditText) findViewById(R.id.ed_author);
        e_state = (EditText) findViewById(R.id.ed_state);
        e_type = (EditText) findViewById(R.id.ed_type);
        e_last_chapter = (EditText) findViewById(R.id.ed_last_chapter);
        e_date_publication = (EditText) findViewById(R.id.ed_date_publication);

        rQueue = Volley.newRequestQueue(this);
    }

    public void crear(View view){
        String name = e_name.getText().toString();
        String type = e_type.getText().toString();
        String state = e_state.getText().toString();
        String date_publication = e_date_publication.getText().toString();
        Integer author = Integer.parseInt(e_author.getText().toString());
        Double last_chapter = Double.parseDouble(e_last_chapter.getText().toString());
        crearManga(name,type,state,date_publication,author,last_chapter);
    }

    private void crearManga(final String name, final String type, final String state, final String date_publication, final Integer author, final Double last_chapter) {
        Toast.makeText(CrearManga.this, "Iniciendo", Toast.LENGTH_LONG).show();
        StringRequest sRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(CrearManga.this,response.toString(), Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error instanceof TimeoutError)
                        {
                            Toast.makeText(CrearManga.this, error.toString(), Toast.LENGTH_LONG).show();
                        }

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("name",name);
                params.put("author",author.toString());
                params.put("last_chapter",last_chapter.toString());
                params.put("type",type);
                params.put("state", state);
                params.put("publication_date",date_publication);
                return params;
            }
        };
        rQueue.add(sRequest);

    }

    public void Cancelar(View view){

    }
}
