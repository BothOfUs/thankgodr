package com.richard.myapplication.models

import java.util.*
import kotlin.collections.ArrayList

data class Orders(var orderId: UUID, val date: Date, var progucts : ArrayList<Product>){

    fun getTotal(): Double{
        var totalprice = 0.0
        progucts.forEach {
            totalprice = totalprice + it.price
        }
        return totalprice
    }

    fun addProduct(product: Product){
        progucts.add(product)
    }
}
