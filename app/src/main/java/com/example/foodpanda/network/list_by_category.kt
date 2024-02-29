package com.example.foodpanda.network

import com.example.foodpanda.model.Detailmeal.mealdetail
import com.example.foodpanda.model.categorydetail.categorydetail
import retrofit2.http.GET
import retrofit2.http.Query

interface list_by_category {
    @GET("filter.php")
    suspend fun categorydata(
        @Query("c")category:String
    ):categorydetail
}