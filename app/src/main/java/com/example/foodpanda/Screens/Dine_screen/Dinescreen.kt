package com.example.foodpanda.Screens.Dine_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.ViewModel
import coil.compose.rememberImagePainter
import com.example.foodpanda.Screens.Categoryviewmodel
import com.example.foodpanda.Screens.dinescreenviewmodel
import com.example.foodpanda.components.textchange
import com.example.foodpanda.model.by_first_letter.Meal


@Composable
fun DineScreen(viewmodel:dinescreenviewmodel,viewmodel1:Categoryviewmodel) {
    val textList = listOf("Pork", "Chicken", "Veg")
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Top) {
            SearchBar(textList)

            val x =viewmodel.listStateFlow.collectAsState()

            LazyColumnContent(viewmodel, x.value.flatten())
        }
    }
}


@Composable
fun SearchBar(textList: List<String>) {
    androidx.compose.material3.Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        color = Color.White,
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "",
                modifier = Modifier.padding(end = 5.dp),
                tint = Color.Red,
            )
            Text(
                text = "Search for ",
                fontWeight = FontWeight.Light
            )
            textchange(texts = textList)
        }
    }
}

@Composable
fun LazyColumnContent(viewModel: ViewModel, data: List<Meal>?, ) {
    if (data != null) {
        LazyColumn(state = rememberLazyListState(),
            modifier = Modifier.padding(top = 5.dp)) {
            items(data) { meal ->
                ReproducingList(meal = meal)
            }
        }
    }
}


@Composable
fun ReproducingList(meal: Meal) {
    Surface(
        modifier = Modifier.padding(10.dp),
        shadowElevation = 20.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {
            Image(
                painter = rememberImagePainter(data = meal.strMealThumb),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            )
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = meal.strMeal,
                        fontSize = 3.5.em
                    )
                    Text(
                        text = meal.strArea,
                        fontSize = 2.5.em,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = "Ingredients -",
                        fontSize = 2.5.em,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}