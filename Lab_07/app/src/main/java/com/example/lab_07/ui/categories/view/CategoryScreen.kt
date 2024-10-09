package com.example.lab_07.ui.categories.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab_07.navigation.AppBar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab_07.ui.categories.viewmodel.MealsCategoriesViewModel
import com.example.lab_07.ui.theme.Lab_07Theme
import androidx.compose.ui.Modifier

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CategoryScreen(navController: NavController){
    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.mealsState.value

    Scaffold(topBar = {
        AppBar(titulo = "Categories", navController = navController)
    }) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(70.dp))

            LazyColumn(contentPadding = PaddingValues(16.dp)){
                items(meals) { meal ->
                    CardMealCategory(meal, navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview(){
    Lab_07Theme {
        CategoryScreen(navController = rememberNavController())
    }
}