package com.richard.myapplication.ui.Orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.richard.myapplication.models.Orders
import com.richard.myapplication.ui.Orders.repository.OrderDataSource

class OrderListViewModel : ViewModel() {

   private lateinit var odersLiveData : MutableLiveData<ArrayList<Orders>>
   private  lateinit var oderRepo : OrderDataSource


    fun init(){
         if(odersLiveData != null){
             return
         }
        oderRepo = OrderDataSource
        odersLiveData = oderRepo.getOrdersfromSource()
    }

    fun getOrders() : LiveData<ArrayList<Orders>>{
        return odersLiveData
    }
}