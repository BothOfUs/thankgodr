package com.richard.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "We will assume a view is Here. Please click on the Orders on the button"
    }
    val text: LiveData<String> = _text
}