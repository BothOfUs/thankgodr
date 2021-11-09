package com.richard.myapplication.ui.oderdetails

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.richard.myapplication.models.Orders

class OderDeatilsViewModel : ViewModel() {

    private  var order : MutableLiveData<Orders> = MutableLiveData()
    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    fun getOrdersDeatils() : LiveData<Orders>{
        return order;
    }

    fun PassArgument(bundle: Bundle){
        val currentOrder = bundle.getParcelable<Orders>("order")
        order = MutableLiveData(currentOrder)
    }
}