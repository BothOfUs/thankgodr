package com.richard.myapplication.ui.Orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.richard.myapplication.models.Orders
import com.richard.myapplication.ui.Orders.repository.OrderDataSource

class OrderListViewModel : ViewModel() {

   private lateinit var odersLiveData : MutableLiveData<ArrayList<Orders>>


    fun init(){
        odersLiveData = OrderDataSource.getOrdersfromSource()
    }

    fun getOrders() : LiveData<ArrayList<Orders>>{
        return odersLiveData
    }

    fun clearData(){
        odersLiveData.value?.clear()
    }
}