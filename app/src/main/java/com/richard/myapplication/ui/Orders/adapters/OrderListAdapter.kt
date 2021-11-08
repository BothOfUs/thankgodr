package com.richard.myapplication.ui.Orders.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.richard.myapplication.R
import com.richard.myapplication.models.Orders
import java.text.DecimalFormat

class OrderListAdapter: RecyclerView.Adapter<OrderListAdapter.ViewHolder> {
   var mDada : ArrayList<Orders>
   var ctx : Context
   constructor(data :ArrayList<Orders>, context: Context){
       mDada = data;
       ctx = context;
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(ctx).inflate(R.layout.single_order_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentOrder = mDada.get(position)
        holder.productCount.text = currentOrder.progucts.size.toString() + " " +  ctx.resources.getString(R.string.products)
        holder.shippingCarrirar.text = currentOrder.shiipingCarrier
        holder.total.text = "$" + DecimalFormat("####,###,###.00").format(currentOrder.getTotal())
        holder.status.text = currentOrder.status.name.replace("_", " ")
        holder.btn_reorder.setOnClickListener{
            System.out.print("Btn of product " + currentOrder.orderId + " lickedC")
        }
       //Todo add date to ui
    }

    override fun getItemCount(): Int {
        return mDada.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val  day = itemView.findViewById<TextView>(R.id.day)
        val month = itemView.findViewById<TextView>(R.id.month)
        val year = itemView.findViewById<TextView>(R.id.year)
        val productCount = itemView.findViewById<TextView>(R.id.totalProductsCount)
        val shippingCarrirar = itemView.findViewById<TextView>(R.id.shipingCarrier)
        val total = itemView.findViewById<TextView>(R.id.total)
        val status = itemView.findViewById<TextView>(R.id.status)
        val btn_reorder = itemView.findViewById<Button>(R.id.reorder)

    }
}