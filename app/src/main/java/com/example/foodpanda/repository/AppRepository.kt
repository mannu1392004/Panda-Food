package com.example.foodpanda.repository

import android.util.Log
import com.example.foodpanda.data.DataOrException
import com.example.foodpanda.model.by_first_letter.Meal
import com.example.foodpanda.model.categories.Category
import com.example.foodpanda.network.Category_Api
import com.example.foodpanda.network.list_api
import javax.inject.Inject
import kotlin.math.log

class AppRepository @Inject constructor(private val categoryApi: Category_Api,private val listApi: list_api) {
    private val Categorydata = DataOrException<List<Category>,Boolean,Exception>()

  suspend fun getallCategories():DataOrException<List<Category>,Boolean,Exception>{
        try {
            Categorydata.loading= true
            Categorydata.data = categoryApi.getcategories().categories
            if (Categorydata.data!=null){Categorydata.loading=false}
        }
        catch (exception:Exception

        ){
Categorydata.e = exception
            Log.d("Exception",exception.toString())
        }


return Categorydata
    }


    private val listdata =   DataOrException< List<Meal>,Boolean,Exception>()

    suspend fun getbyfirstletter(letter:String):DataOrException<List<Meal>,Boolean,Exception> {
        try {
            listdata.loading=true
            listdata.data = listApi.getlist(letter).meals
            if (listdata.data!=null) {listdata.loading= false}


        }
        catch (
            e:Exception
        ){
            listdata.e = e
            Log.d("Exception",e.toString())
        }

      return listdata
    }




}