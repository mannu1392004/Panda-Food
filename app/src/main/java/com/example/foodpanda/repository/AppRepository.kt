package com.example.foodpanda.repository

import android.util.Log
import com.example.foodpanda.data.DataOrException

import com.example.foodpanda.model.Detailmeal.mealdetail
import com.example.foodpanda.model.by_first_letter.Meal
import com.example.foodpanda.model.categories.Category
import com.example.foodpanda.model.categorydetail.categorydetail
import com.example.foodpanda.network.Category_Api
import com.example.foodpanda.network.List_by_continents
import com.example.foodpanda.network.Meal_by_Id_api
import com.example.foodpanda.network.list_api
import com.example.foodpanda.network.list_by_category
import javax.inject.Inject
import kotlin.math.log

class AppRepository @Inject constructor(private val categoryApi: Category_Api,
                                        private val listApi: list_api,
                                        private val MealApi:Meal_by_Id_api,
                                        private val listByCategory: list_by_category,
                                        private val listByContinents: List_by_continents) {




    private val Categorydata = DataOrException<List<Category>,Boolean,Exception>()
// getting categorydata
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



//getting listof meals

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




// getting details of meal

    private val getmealdetail = DataOrException<mealdetail,Boolean,Exception>()

    suspend fun getmealdetail(id:String):DataOrException<mealdetail,Boolean,Exception>{
        try {
            getmealdetail.loading  = true
            getmealdetail.data  =  MealApi.getmealdetail(id)
            if (getmealdetail.data!=null) {getmealdetail.loading=false}

        }
        catch (E:Exception){
            getmealdetail.e =E
            Log.d("Exception",E.toString())
        }

        return getmealdetail
    }




    // getting categorydata
    private val getcategorydetail = DataOrException<categorydetail,Boolean,Exception>()

    suspend fun getcategorydetail(category:String):DataOrException<categorydetail,Boolean,Exception>{
        try {
            getcategorydetail.loading = true
            getcategorydetail.data = listByCategory.categorydata(category)
            getcategorydetail.loading = false
        }
        catch (e:Exception){
            getcategorydetail.e  = e
            Log.d("exception",e.toString())
        }

      return getcategorydetail
    }


    //getting continetal

    private val getcontinentaldetail = DataOrException<categorydetail,Boolean,Exception>()
    suspend fun getcontinentaldetail(category:String):DataOrException<categorydetail,Boolean,Exception>{
        try {
            getcontinentaldetail.loading = true

            getcontinentaldetail.data = listByContinents.getcontinentaldetail(category)
            getcontinentaldetail.loading = false
        }
        catch (e:Exception){
            getcontinentaldetail.e  = e
            Log.d("exception",e.toString())
        }

        return getcontinentaldetail
    }




}