package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var tCiudad:TextView? = null
    var tGrado:TextView? = null
    var tEstatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        tCiudad = findViewById(R.id.txtCiudad)
        tGrado = findViewById(R.id.txtGrado)
        tEstatus = findViewById(R.id.txtEstatus)

        val ciudad = intent.getStringExtra("com.example.ciudades.CIUDAD")
        val ciudadAy = Ciudad( "Ciudad Ayacucho", 15, "Soleado")
        val ciudadLi = Ciudad( "Ciudad Lima", 20, "Lluvioso")


        if( ciudad == "ciudad-ayacucho"){
            tCiudad?.text = ciudadAy.nombre
            tGrado?.text = ciudadAy.grados.toString() + "°"
            tEstatus?.text = ciudadAy.estatus

        }else if(ciudad == "ciudad-lima"){
            tCiudad?.text = ciudadLi.nombre
            tGrado?.text = ciudadLi.grados.toString() + "°"
            tEstatus?.text = ciudadLi.estatus
        }

    }
}