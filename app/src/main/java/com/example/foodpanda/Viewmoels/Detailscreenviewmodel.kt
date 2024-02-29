package com.example.foodpanda.Viewmoels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodpanda.data.DataOrException
import com.example.foodpanda.model.Detailmeal.mealdetail
import com.example.foodpanda.model.by_first_letter.Meal
import com.example.foodpanda.model.categories.Category
import com.example.foodpanda.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Detailscreenviewmodel @Inject constructor(private val repository: AppRepository):ViewModel() {
   suspend fun  getmealdata(id:String):DataOrException<mealdetail,Boolean,Exception> {
       return repository.getmealdetail(id)
    }
}