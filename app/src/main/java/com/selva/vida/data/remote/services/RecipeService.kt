package com.selva.vida.data.remote.services

import com.selva.vida.data.remote.model.RecipeInfo
import com.selva.vida.data.remote.model.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeService {
    @GET("recipes?limit=20")
    suspend fun getAllRecipes(): RecipeResponse

    @GET("recipes/{id}")
    suspend fun getRecipeById(@Path("id") id: Int): RecipeInfo

    companion object {
        const val BASE_URL = "https://dummyjson.com/"
    }
}