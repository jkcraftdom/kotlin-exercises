package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.example.clima.adapters.ProductAdapter
import com.example.clima.models.Product

class ProductsActivity : AppCompatActivity() {

    var products:ArrayList<Product>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        products = ArrayList()
        products?.add(Product("Haba", 10.0, "Haba" ,""))

        val lista = findViewById<ListView>(R.id.lista_producto)
        val adaptador = ProductAdapter(this, products!!)
        lista.adapter = adaptador


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_products, menu)
        return super.onCreateOptionsMenu(menu)
    }

}