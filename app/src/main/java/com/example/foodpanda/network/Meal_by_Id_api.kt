package com.example.foodpanda.network

import com.example.foodpanda.model.Detailmeal.mealdetail
import com.example.foodpanda.model.by_first_letter.Meal
import retrofit2.http.GET
import retrofit2.http.Query

interface Meal_by_Id_api {

@GET("lookup.php")
suspend fun getmealdetail(
    @Query("i")id:String
):mealdetail



}