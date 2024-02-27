package com.example.foodpanda.di

import com.example.foodpanda.Constants.Constants
import com.example.foodpanda.network.Category_Api
import com.example.foodpanda.network.list_api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object appmodule {
    @Singleton
    @Provides
    fun providecategory():Category_Api{
        return Retrofit.Builder()
            .baseUrl(Constants.Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Category_Api::class.java)
    }

    @Singleton
    @Provides
    fun providelist():list_api{
        return Retrofit.Builder()
            .baseUrl(Constants.list_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(list_api::class.java)


    }


}