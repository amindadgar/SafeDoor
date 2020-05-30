package com.example.sampleapp.Model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainPageViewModel : ViewModel() {
    val array = listOf(Users("Ali",25,1), Users("Ziba",23,2),
        Users("Sarah",20,3))

    val Data = liveData<List<Users>>(Dispatchers.IO) {
        array
    }
}
