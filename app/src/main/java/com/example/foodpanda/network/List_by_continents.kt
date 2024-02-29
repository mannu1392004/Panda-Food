package com.example.foodpanda.network


import com.example.foodpanda.model.categorydetail.categorydetail
import retrofit2.http.GET
import retrofit2.http.Query

interface List_by_continents {
    @GET("filter.php")
    suspend fun getcontinentaldetail (
        @Query("a")name:String
    ):categorydetail
}