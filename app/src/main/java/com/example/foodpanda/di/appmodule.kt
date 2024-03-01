package com.example.foodpanda.di

import android.content.Context
import androidx.room.Room
import com.example.foodpanda.Constants.Constants
import com.example.foodpanda.RoomDatabase.Dao.Cart_dao
import com.example.foodpanda.RoomDatabase.Database.Database
import com.example.foodpanda.network.Category_Api
import com.example.foodpanda.network.List_by_continents
import com.example.foodpanda.network.Meal_by_Id_api
import com.example.foodpanda.network.list_api
import com.example.foodpanda.network.list_by_category
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

    @Singleton
    @Provides
    fun getmealdetail():Meal_by_Id_api{
        return Retrofit.Builder()
            .baseUrl(Constants.mealdetailurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Meal_by_Id_api::class.java)
    }

    @Singleton
    @Provides
    fun getcategorydetail():list_by_category{
        return Retrofit.Builder()
            .baseUrl(Constants.categoryurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(list_by_category::class.java)
    }

    @Singleton
    @Provides
    fun getcontinentaldetail():List_by_continents{
        return Retrofit.Builder()
            .baseUrl(Constants.continental)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(List_by_continents::class.java)

    }


    @Singleton
    @Provides
    fun provideappdatabase(@ApplicationContext context: Context):Database =
        Room.databaseBuilder(context,Database::class.java
            ,"cart").fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun providesdao(database: Database):Cart_dao = database.dao

}