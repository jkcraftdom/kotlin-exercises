package com.example.clima.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.clima.models.Product
import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.example.clima.R

class ProductAdapter(var context:Context, items:ArrayList<Product>):BaseAdapter() {

    var items:ArrayList<Product>? = null

    init{
        this.items = items
    }
    override fun getCount(): Int {
        return this.items?.count()!!
    }

    override fun getItem(p0: Int): Any {
       return this.items?.get(p0)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var viewHolder: ViewHolder? = null
        var vista: View? = convertView

        if(vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.template_product,null)
            viewHolder = ViewHolder(vista)
            vista.tag = viewHolder
        }else{
            viewHolder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Product
        viewHolder?.name?.text = item.name
        viewHolder?.price?.text = item.price.toString()

        return vista!!

    }

     private class ViewHolder(vista:View){
         var name:TextView? = null
         var price:TextView? = null
         var image: ImageView? = null

         init {
             this.name = vista.findViewById(R.id.tv_name)
             this.price = vista.findViewById(R.id.tv_price)
             this.image = vista.findViewById(R.id.iv_foto )
         }
     }

}