package com.example.foodpanda.Viewmoels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodpanda.RoomDatabase.entity.Cart_entity
import com.example.foodpanda.data.DataOrException
import com.example.foodpanda.model.Detailmeal.mealdetail
import com.example.foodpanda.model.by_first_letter.Meal
import com.example.foodpanda.model.categories.Category
import com.example.foodpanda.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Detailscreenviewmodel @Inject constructor(private val repository: AppRepository):ViewModel() {
   suspend fun  getmealdata(id:String):DataOrException<mealdetail,Boolean,Exception> {
       return repository.getmealdetail(id)
    }





    val cart: MutableStateFlow<List<Cart_entity>> = MutableStateFlow(emptyList())
    init {
        viewModelScope.launch {
            repository.getcart().collect() {
                cart.value = it
            }
        }

    }



    // add to cart
    fun addtocart(cartEntity: Cart_entity)  = viewModelScope.launch {
        repository.inserttocart(cartEntity)
    }

    fun isMealInCart(mealId: String): Flow<Boolean> {
        return repository.isMealInCart(mealId)
    }


    fun getonedata(mealId: String):Flow<Cart_entity>{
        return repository.onemealdata(mealId)
    }



}