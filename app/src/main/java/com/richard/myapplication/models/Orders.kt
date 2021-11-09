package com.richard.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*
import kotlin.collections.ArrayList

@Parcelize
data class Orders(var orderId: UUID,
                  val date: Date,
                  var status : OrderStatus,
                  var  shiipingCarrier : String, var progucts : ArrayList<Product>) : Parcelable {

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
