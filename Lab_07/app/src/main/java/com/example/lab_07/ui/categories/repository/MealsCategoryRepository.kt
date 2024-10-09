package com.example.lab_07.ui.categories.repository

import com.example.lab_07.networking.response.categories.Categories
import com.example.lab_07.networking.webservices.MealsWebServices

class MealsCategoryRepository(private val webService: MealsWebServices = MealsWebServices()) {

    suspend fun getMealsCategories(): List<Categories> {
        return webService.getMealsCategories().categories
    }
}