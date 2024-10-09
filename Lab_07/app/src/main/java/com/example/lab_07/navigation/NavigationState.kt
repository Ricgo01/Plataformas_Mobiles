package com.example.lab_07.navigation

sealed class NavigationState (val route: String) {
    data object MealsCategories: NavigationState("categories")

    data object MealsRecipesList: NavigationState("categories/{category}"){
        fun createRoute(category: String) = "categories/$category"
    }

    data object MealDetail : NavigationState("meal/{mealId}") {
        fun createRoute(mealId: String) = "meal/$mealId"
    }

}