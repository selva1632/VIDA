package com.selva.vida.presentation.detail

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
class DetailViewModel @Inject constructor(private val repository: RecipeRepository): ViewModel() {
    private val _recipeDetails = MutableLiveData<RecipeInfo>()
    val recipeDetails = _recipeDetails

    fun fetchRecipeById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getRecipeById(id)
            recipeDetails.postValue(response)
        }
    }
}