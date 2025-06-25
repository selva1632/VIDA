package com.selva.vida.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selva.vida.data.remote.model.RecipeInfo
import com.selva.vida.domain.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val repository: RecipeRepository): ViewModel(){
    private val _recipes = MutableLiveData<List<RecipeInfo>>()
    val recipes: LiveData<List<RecipeInfo>>
        get() = _recipes

    init {
        fetchRecipe()
    }

    private fun fetchRecipe() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllRecipes()
            _recipes.postValue(response)
        }
    }
}