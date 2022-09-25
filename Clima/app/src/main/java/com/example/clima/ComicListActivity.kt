package com.example.clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat

class ComicListActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_list)

        var comics: ArrayList<Comic> = ArrayList()
        comics.add(Comic("A",1,"manga"))
        comics.add(Comic("B",1,"manga"))
        comics.add(Comic("C",1,"manga"))

        val lista = findViewById<ListView>(R.id.lst_comics)

        val adaptador = AdaptadorCustom(this,comics)

        lista.adapter = adaptador

        lista.onItemClickListener= AdapterView.OnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this, comics.get(position).name, Toast.LENGTH_LONG).show()
        }

        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)

        val itemBusqueda = menu?.findItem(R.id.bBusqueda)
        var vistaBusqueda = itemBusqueda?.actionView as SearchView

        val itemCompartir = menu?.findItem(R.id.bShare)
        val shareActionProvider = MenuItemCompat.getActionProvider(itemCompartir) as ShareActionProvider
        compartirItent(shareActionProvider)

        vistaBusqueda.queryHint = "Buscar por nombre ..."
        vistaBusqueda.setOnQueryTextFocusChangeListener{v, hasFocus ->
            Log.d("LISTENERFOCUS", hasFocus.toString())
        }

        vistaBusqueda.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("OnQueryTextChange", newText.toString())
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("OnQueryTextSubmit", query.toString())
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun compartirItent(shareActionProvider: ShareActionProvider){
        if(shareActionProvider != null){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Este es un mensaje compartido")
            shareActionProvider.setShareIntent(intent)
        }
    }
}