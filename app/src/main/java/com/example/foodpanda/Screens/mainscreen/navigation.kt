package com.example.foodpanda.Screens.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodpanda.R
import com.example.foodpanda.Screens.Dine_screen.DineScreen
import com.example.foodpanda.Screens.Settings.screens
import com.example.foodpanda.Screens.Categoryviewmodel
import com.example.foodpanda.Screens.category_Screen.Categories
import com.example.foodpanda.Screens.dinescreenviewmodel

@Composable
fun nav(){
val categoryviewmodel = viewModel<Categoryviewmodel>()
    val dinescreenviewmodel  = viewModel<dinescreenviewmodel>()
    val nav = rememberNavController()

val selection = remember {
    mutableStateOf(0)
}
    Scaffold(
        bottomBar = {
NavigationBar(modifier = Modifier
    .padding(0.dp)
    .fillMaxWidth()
    .height(60.dp)
    .clip(RoundedCornerShape(topStartPercent = 25, topEndPercent = 25)), containerColor =  Color.White) {
    Row(modifier = Modifier.padding(7.dp)) {


        NavigationBarItem(
            selected = selection.value == 0,
            onClick = {
                selection.value = 0
                nav.navigate(screens.Categories.name)

            },
            icon = {

                Icon(imageVector = if (selection.value!=0) Icons.Outlined.Home
                    else Icons.Filled.Home
                    , contentDescription = "", modifier = Modifier,)
            })


        NavigationBarItem(
            selected = selection.value == 1,
            onClick = {
                selection.value = 1
                nav.navigate(screens.Dine.name)

            },
            icon = {
               Image(painter = painterResource(id = if (selection.value!=1) R.drawable.dinner__1_
               else R.drawable.food_tray), contentDescription = ""
               ,
               )
            })



        NavigationBarItem(
            selected = selection.value == 2,
            onClick = {
                selection.value = 2
                nav.navigate(screens.Cart.name)
            },
            icon = {
               Icon(imageVector = if (selection.value!=2) Icons.Outlined.ShoppingCart
                   else Icons.Filled.ShoppingCart, contentDescription = "", )
            })

    }

}


        }
    ) {

            paddingValues ->

        NavHost(navController =nav , startDestination = screens.Dine.name, modifier = Modifier.padding(paddingValues) ){

            composable(screens.Categories.name){
                Categories(viemodel = categoryviewmodel)
                selection.value=0
            }
composable(screens.Dine.name){
   selection.value = 1
DineScreen(dinescreenviewmodel,categoryviewmodel)


}
composable(screens.Cart.name){
    Text(text = "Cart")
    selection.value  = 2
}
        }

    }

}