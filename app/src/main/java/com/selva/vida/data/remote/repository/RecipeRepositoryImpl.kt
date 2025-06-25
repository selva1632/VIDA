package com.selva.vida.data.remote.repository

import com.selva.vida.data.remote.model.RecipeInfo
import com.selva.vida.data.remote.services.RecipeService
import com.selva.vida.domain.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val apiService: RecipeService): RecipeRepository {
    override suspend fun getAllRecipes(): List<RecipeInfo> {
        val response = apiService.getAllRecipes()
        return response.recipe
    }

    override suspend fun getRecipeById(id: Int): RecipeInfo {
        return apiService.getRecipeById(id)
    }
}