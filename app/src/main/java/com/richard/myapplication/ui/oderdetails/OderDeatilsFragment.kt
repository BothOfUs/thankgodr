package com.richard.myapplication.ui.oderdetails

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.richard.myapplication.MainActivity
import com.richard.myapplication.R
import com.richard.myapplication.models.Orders
import com.richard.myapplication.ui.Orders.OrdersListFragment
import com.richard.myapplication.ui.oderdetails.adapter.ProductAdater
import org.jetbrains.anko.alert

class OderDeatilsFragment : Fragment() {

    private lateinit var notificationsViewModel: OderDeatilsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        container?.removeAllViews()
        notificationsViewModel =
                ViewModelProvider(this).get(OderDeatilsViewModel::class.java)
        if(arguments != null){
            val bundle = arguments as Bundle
            notificationsViewModel.PassArgument(bundle);
        }else{
            d("okh", "Hello")
            context?.let {
                it.alert {
                    title = it.resources.getString(R.string.error)
                    message = it.resources.getString(R.string.please_select_an_oder)

                    positiveButton(buttonText = it.resources.getString(R.string.ok), onClicked = {
                        val mainActivity = activity as MainActivity
                        mainActivity.supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host_fragment, OrdersListFragment()).commit()
                    })

                    isCancelable = false
                }.show()
            }

        }

        val root = inflater.inflate(R.layout.fragment_orders_details, container, false)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
        })

        notificationsViewModel.getOrdersDeatils().observe(viewLifecycleOwner, Observer {
            setUpView(root, it)
        })
        return root
    }

    private fun setUpView(root: View, it: Orders) {
        root.findViewById<TextView>(R.id.oderStatus).text = it.status.name
        root.findViewById<TextView>(R.id.date).text = it.date.toString()
        root.findViewById<TextView>(R.id.orderNumber).text = context?.resources?.getString(R.string.orderNo)?.toUpperCase() +": " + it.orderId.toString().replace("-", "").substring(0,8)
        root.findViewById<TextView>(R.id.amount).text =  context?.resources?.getString(R.string.total)?.toUpperCase() + ": $" + it.getTotal()
        root.findViewById<Button>(R.id.reorder).setOnClickListener{
            //Pass Products to cart activity
        }

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = context?.let { it1 -> ProductAdater(it.progucts, it1) }
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }
}