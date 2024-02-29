package com.example.foodpanda.Viewmoels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodpanda.model.by_first_letter.Meal
import com.example.foodpanda.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Dinescreenviewmodel  @Inject constructor(private val repository: AppRepository) :ViewModel() {


    val listStateFlow: MutableStateFlow<List<List<Meal>>> = MutableStateFlow(emptyList())
    init {
        getInitialData()
    }

    private fun getInitialData() {


        for (x in 'b'..'z') { // Adjusted to start from 'b' since 'a' is already fetched
            viewModelScope.launch {
                val data = repository.getbyfirstletter(x.toString()).data
                data?.let {
                    listStateFlow.value = listStateFlow.value.toMutableList().apply { add(it) }
                }
            }
        }
    }







}