package com.example.clima.models

class Product(name:String, price:Double, category:String, photo:String) {
    var name:String = ""
    var price: Double = 0.0
    var category: String = ""
    var photo: String =""

    init {
        this.name = name
        this.price = price
        this.category = category
        this.photo = photo
    }
}