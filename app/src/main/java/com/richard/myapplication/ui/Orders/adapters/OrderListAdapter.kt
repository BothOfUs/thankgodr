package com.richard.myapplication.ui.Orders.adapters

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.richard.myapplication.MainActivity
import com.richard.myapplication.R
import com.richard.myapplication.models.Orders
import com.richard.myapplication.models.Product
import com.richard.myapplication.ui.oderdetails.OderDeatilsFragment
import java.text.DecimalFormat

class OrderListAdapter: RecyclerView.Adapter<OrderListAdapter.ViewHolder> {
   var mDada : ArrayList<Orders>
   var ctx : Activity
   constructor(data :ArrayList<Orders>, context: Activity){
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
        holder.orderview.setOnClickListener{
            startFragmenTDeatils(currentOrder)
        }

       //Off this btn for now
        holder.btn_reorder.visibility = View.GONE

        holder.btn_reorder.setOnClickListener{
            //StartCartActivety(currentOrder.progucts);
        }

        holder.orderNumber.text = ctx.resources.getString(R.string.orderNo) + " " +currentOrder.orderId.toString().replace("-","").substring(0,5)
       //Todo add date to ui
    }



    private fun startFragmenTDeatils(orders: Orders) {
        val oderDetailsFragment = OderDeatilsFragment()
        val bundle = Bundle()
        bundle.putParcelable("order", orders)
        oderDetailsFragment.arguments = bundle
        val mainActivty = ctx as MainActivity
        mainActivty.supportFragmentManager.beginTransaction()
                .addToBackStack("")
                .replace(R.id.nav_host_fragment, oderDetailsFragment).commit()
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
        val orderNumber = itemView.findViewById<TextView>(R.id.orderNumber)
        val orderview = itemView.findViewById<CardView>(R.id.order)

    }
}