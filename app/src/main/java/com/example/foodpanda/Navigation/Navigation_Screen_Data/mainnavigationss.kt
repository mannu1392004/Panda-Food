package com.example.foodpanda.Navigation.Navigation_Screen_Data

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodpanda.Screens.Detail_Screen.DetailScreen
import com.example.foodpanda.Screens.categorydetail_screen.categorydetail
import com.example.foodpanda.Screens.mainscreen.nav
import com.example.foodpanda.Screens.orderplaced.orderplaced
import com.example.foodpanda.Viewmoels.cartviewmodel
import com.example.foodpanda.Viewmoels.Categorydetailscreenviewmodel
import com.example.foodpanda.Viewmoels.Categoryviewmodel
import com.example.foodpanda.Viewmoels.Continentaldetailviewmodel
import com.example.foodpanda.Viewmoels.Detailscreenviewmodel
import com.example.foodpanda.Viewmoels.Dinescreenviewmodel

@Composable
fun mainnav(){
    val nav = rememberNavController()
    val detail = rememberNavController()
    val detailscreenviewmodel = viewModel<Detailscreenviewmodel>()
    val categoryviewmodel = viewModel<Categoryviewmodel>()
    val dinescreenviewmodel  = viewModel<Dinescreenviewmodel>()
    val Categorydetailscreenviewmodel = viewModel<Categorydetailscreenviewmodel>()
    val Continentaldetailviewmodel = viewModel<Continentaldetailviewmodel>()
    val Cartviewmodel = viewModel<cartviewmodel>()

    NavHost(navController = detail, startDestination = screens.Mainscreen.name ){


        composable(route= screens.Mainscreen.name){
            nav(detail,nav,categoryviewmodel,dinescreenviewmodel,detailscreenviewmodel,Cartviewmodel)
        }





        val detailroute = screens.Detailscreen.name
        composable(route = "$detailroute/{id}", arguments = listOf(navArgument("id"){
            type = NavType.StringType
        })
        ) {
            it.arguments?.getString("id").let {
                DetailScreen(detailscreenviewmodel = detailscreenviewmodel, nav,it,detail)
            }
        }







        val continentalroute = screens.Categorydetailscreen.name

        composable(route = "$continentalroute/{name}/{type}" , arguments = listOf(
            navArgument("name"){type = NavType.StringType }, navArgument("type"){type = NavType.StringType}
        )){
                backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val type = backStackEntry.arguments?.getString("type")
        if (name!=null&&type!=name) {

            categorydetail(
                viewmodel = Categorydetailscreenviewmodel,
                Continentaldetailviewmodel,
                detail,type,name
            )
        }}

composable(route = screens.orderplaced.name){
    orderplaced(detail,nav)

 }


    }

}