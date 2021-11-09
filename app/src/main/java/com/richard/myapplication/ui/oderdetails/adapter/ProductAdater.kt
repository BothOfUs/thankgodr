package com.richard.myapplication.ui.oderdetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.richard.myapplication.R
import com.richard.myapplication.models.Product
import java.text.DecimalFormat

class ProductAdater : RecyclerView.Adapter<ProductAdater.ViewHolder> {

    private var mData : ArrayList<Product>
    private var ctx : Context

    constructor(dataset : ArrayList<Product>, context: Context){
        mData = dataset
        ctx = context
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(ctx).inflate(R.layout.single_product_view,parent,false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProduct = mData.get(position)
        holder.productName.text = currentProduct.name
        holder.productPrise.text = "$" + DecimalFormat("####,###,###.00").format(currentProduct.price)
    }

    override fun getItemCount(): Int {
       return  mData.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView.findViewById<ImageView>(R.id.productImage)
        val productName = itemView.findViewById<TextView>(R.id.productName)
        val productPrise = itemView.findViewById<TextView>(R.id.price)

    }
}