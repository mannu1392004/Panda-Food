package com.example.foodpanda.Viewmoels

import androidx.lifecycle.ViewModel
import com.example.foodpanda.data.DataOrException

import com.example.foodpanda.model.categorydetail.categorydetail
import com.example.foodpanda.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class Continentaldetailviewmodel @Inject constructor(private val repository: AppRepository):ViewModel() {

    suspend fun getcontinentaldetail(name:String):DataOrException<categorydetail,Boolean,Exception>{
        return repository.getcontinentaldetail(name)
    }


}