package com.richard.myapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(var name: String, var price : Double, var sku : String, var categoryId : String):
    Parcelable
