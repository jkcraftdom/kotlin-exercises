package com.example.clima

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCustom(var context: Context, items: ArrayList<Comic>): BaseAdapter() {
    var items: ArrayList<Comic>? = null

    init {
        this.items = items
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var holder: ViewHolder? = null
        var vista:View? = convertView

        if(vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.row_comic,null)
            holder = ViewHolder(vista)
            vista.tag = holder
        }else {
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Comic
        holder?.name?.text = item.name
        return vista!!
    }

    private class ViewHolder(vista:View){
        var name:TextView? = null

        init {
            name = vista.findViewById<TextView>(R.id.txtTitle)
        }
    }
}