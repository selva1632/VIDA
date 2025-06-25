package com.selva.vida.domain

import com.selva.vida.data.remote.model.RecipeInfo

interface RecipeRepository {
    suspend fun getAllRecipes(): List<RecipeInfo>
    suspend fun getRecipeById(id: Int): RecipeInfo
}