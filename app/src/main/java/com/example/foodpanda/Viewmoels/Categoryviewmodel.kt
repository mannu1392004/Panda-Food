package com.example.foodpanda.Viewmoels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodpanda.data.DataOrException
import com.example.foodpanda.model.by_first_letter.Meal
import com.example.foodpanda.model.categories.Category
import com.example.foodpanda.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class Categoryviewmodel @Inject constructor(private val repository: AppRepository):ViewModel()
{
    val categorydata:MutableState<DataOrException<List<Category>,
            Boolean,Exception>> = mutableStateOf(
                DataOrException(null,true,Exception(""))
            )
    init {
        getcategorydata()
    }

    private fun getcategorydata() {
        viewModelScope.launch {
           categorydata.value = repository.getallCategories()
        }


    }
}