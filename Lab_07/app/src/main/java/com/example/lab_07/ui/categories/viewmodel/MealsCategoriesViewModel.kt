package com.example.lab_07.ui.categories.viewmodel
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_07.networking.response.categories.Categories
import com.example.lab_07.ui.categories.repository.MealsCategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel (private val repository: MealsCategoryRepository = MealsCategoryRepository()): ViewModel() {

    val mealsState: MutableState<List<Categories>> = mutableStateOf(emptyList<Categories>())
    init {
        Log.d("CORRUTINAS", "Apunto de lanzar la corrutina")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("CORRUTINAS", "Lanzando la corrutina")
            val meals = getMealsCategories()
            Log.d("CORRUTINAS", "Se recibio informacion")
            mealsState.value = meals

        }
        Log.d("CORRUTINAS", "Otro trabajo")
    }

    private suspend fun getMealsCategories(): List<Categories> {
        return repository.getMealsCategories()
    }
}