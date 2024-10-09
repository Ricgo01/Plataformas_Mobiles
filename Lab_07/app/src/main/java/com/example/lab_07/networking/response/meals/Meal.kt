package com.example.lab_07.networking.response.meals

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val urlImage: String,
    @SerializedName("strArea") val area: String

)