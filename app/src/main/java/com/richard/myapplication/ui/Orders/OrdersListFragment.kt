package com.richard.myapplication.ui.Orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.richard.myapplication.R
import com.richard.myapplication.models.Orders
import com.richard.myapplication.ui.Orders.adapters.OrderListAdapter

class OrdersListFragment : Fragment() {

    private lateinit var orderListViewModel: OrderListViewModel
    lateinit var recyclerView :RecyclerView
    lateinit var adapter: OrderListAdapter;

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        orderListViewModel =
                ViewModelProvider(this).get(OrderListViewModel::class.java)
        orderListViewModel.init()


        val root = inflater.inflate(R.layout.list_order_fragment, container, false)
        initRecyclerView(root)

        orderListViewModel.getOrders().observe(viewLifecycleOwner, {
            adapter.notifyDataSetChanged()
        })

        initRecyclerView(root)
        return root
    }

    fun initRecyclerView(root : View){
        recyclerView = root.findViewById<RecyclerView>(R.id.listOrderRecycler)
        adapter = context?.let { orderListViewModel.getOrders().value?.let { it1 ->
            OrderListAdapter(
                it1, it)
        } }!!
        val layoutManger = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutManger
        recyclerView.adapter = adapter

    }
}