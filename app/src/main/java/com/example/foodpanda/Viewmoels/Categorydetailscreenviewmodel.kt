package com.example.foodpanda.Viewmoels

import androidx.lifecycle.ViewModel
import com.example.foodpanda.data.DataOrException
import com.example.foodpanda.model.Detailmeal.mealdetail
import com.example.foodpanda.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Categorydetailscreenviewmodel @Inject constructor(private val repository: AppRepository):ViewModel() {

    suspend fun getcategorydetail(category:String):DataOrException<List<mealdetail>,Boolean,Exception>{
        return repository.getcategorydetail(category)
    }

}