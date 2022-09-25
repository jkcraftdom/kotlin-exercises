package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.Exception

class ComicsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)


    }

    private fun solicitudHttpVolley(url:String){
        val queue = Volley.newRequestQueue(this)
        val solicitud  = StringRequest(Request.Method.GET, url, {
                response ->
            try{
                Log.d("solicitudHttpVoley", response)
                /*val gson = Gson()
                val res = gson.fromJson(response, Comics::class.java)
                Log.d("GSON", res.comics.count().toString())*/
            }catch (e: Exception){

            }
        }, {})
        queue.add(solicitud)

    }
}