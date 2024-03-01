package com.example.foodpanda.Viewmoels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodpanda.RoomDatabase.entity.Cart_entity
import com.example.foodpanda.data.DataOrException
import com.example.foodpanda.model.Detailmeal.mealdetail
import com.example.foodpanda.model.categorydetail.categorydetail
import com.example.foodpanda.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Categorydetailscreenviewmodel @Inject constructor(private val repository: AppRepository):ViewModel() {

    suspend fun getcategorydetail(category:String):DataOrException<categorydetail,Boolean,Exception>{
        return repository.getcategorydetail(category)
    }

    val cart: MutableStateFlow<List<Cart_entity>> = MutableStateFlow(emptyList())
    init {
        viewModelScope.launch {
            repository.getcart().collect() {
                cart.value = it
            }
        }

    }

    fun isMealInCart(mealId: String): Flow<Boolean> {
        return repository.isMealInCart(mealId)
    }


    // add to cart
    fun addtocart(cartEntity: Cart_entity)  = viewModelScope.launch {
        repository.inserttocart(cartEntity)
    }

}