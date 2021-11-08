package com.richard.myapplication.ui.Orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.richard.myapplication.R

class OrdersListFragment : Fragment() {

    private lateinit var orderListViewModel: OrderListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        orderListViewModel =
                ViewModelProvider(this).get(OrderListViewModel::class.java)
        val root = inflater.inflate(R.layout.list_order_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.listOrderRecycler)
        orderListViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}