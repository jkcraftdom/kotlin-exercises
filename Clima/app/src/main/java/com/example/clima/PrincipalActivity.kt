package com.example.clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import okhttp3.Call
import okhttp3.OkHttpClient
import java.io.IOException
import java.lang.Exception

class PrincipalActivity : AppCompatActivity(),CompletadoListener {

    val TAG = "com.example.ciudades.CIUDAD"
    var toolbar: Toolbar? = null


    override fun descargaCompleta(resultado: String) {
        Log.d("descargaCompleta", resultado)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val btnComics = findViewById<Button>(R.id.btnComics)
        val bProducts = findViewById<Button>(R.id.bProducts)
        val bRed = findViewById<Button>(R.id.btnRed)
        val bHttp = findViewById<Button>(R.id.btnHttp)
        val bVolley = findViewById<Button>(R.id.btnVolley)
        val bOkHttp = findViewById<Button>(R.id.btnOkHTTP)

        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        btnComics.setOnClickListener{
            val intent = Intent(this,ComicListActivity::class.java)
            startActivity(intent)
        }

        bProducts.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG, "ciudad-lima")
            startActivity(intent)
        }

        bRed.setOnClickListener {
            if(Network.hayRed(this)){
                Toast.makeText(this, "si hay red", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No hay red", Toast.LENGTH_SHORT).show()
            }
        }

        bHttp.setOnClickListener{
            DescargaURL(this).execute("http://www.google.com")
        }

        bVolley.setOnClickListener {
            solicitudHttpVolley("http://www.google.com")
        }

        bOkHttp.setOnClickListener {
            solicitudOkHttp("http://www.google.com")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.bFav -> {
                Toast.makeText(this, "Elemento añadido a favorito", Toast.LENGTH_LONG).show()
                return true
            }
            else ->{
                return super.onOptionsItemSelected(item)
            }
        }
    }
    private fun solicitudOkHttp(url:String){
        val cliente = OkHttpClient()
        val solicitud = okhttp3.Request.Builder().url(url).build()
        cliente.newCall(solicitud).enqueue(object: okhttp3.Callback{
            override fun onFailure(call: Call?, e: IOException?) {

            }

            override fun onResponse(call: Call?, response: okhttp3.Response) {
                val resultado = response.body().string()
                this@PrincipalActivity.runOnUiThread{
                    try{
                        Log.d("solicitudOkHttp", resultado)
                    }catch (e:Exception){

                    }
                }
            }

        })


    }
    private fun solicitudHttpVolley(url:String){
        val queue = Volley.newRequestQueue(this)
        val solicitud  = StringRequest(Request.Method.GET, url, {
            response ->
            try{
                Log.d("solicitudHttpVoley", response)
            }catch (e:Exception){

            }
        }, {})
        queue.add(solicitud)

    }
}