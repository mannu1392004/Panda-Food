package com.example.foodpanda.network

import com.example.foodpanda.model.categories.Category
import com.example.foodpanda.model.categories.categories
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface Category_Api {
    @GET("categories.php")
    suspend fun getcategories():categories

}