package com.example.lab_07.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab_07.ui.categories.view.CategoryScreen
import com.example.lab_07.navigation.NavigationState
import com.example.lab_07.ui.meals.view.MealsFilterScreen
import com.example.lab_07.ui.mealsdetail.view.DetailsScreen

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController,
        startDestination = NavigationState.MealsCategories.route,
        modifier = modifier) {

        composable(route = NavigationState.MealsCategories.route) {
            CategoryScreen(navController = navController)
        }
        composable(NavigationState.MealsRecipesList.route,
            arguments = listOf(navArgument("category"){
                type = NavType.StringType
            })){
            backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val categoryName = arguments.getString("category") ?: ""
            Log.d("ARGUMENTNAV", categoryName)
            MealsFilterScreen(navController = navController, category = categoryName)
        }

        composable(
            route = NavigationState.MealDetail.route,
            arguments = listOf(navArgument("mealId") { type = NavType.StringType })
        ) { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId") ?: ""
            DetailsScreen(navController = navController, mealId = mealId)
        }
    }
}