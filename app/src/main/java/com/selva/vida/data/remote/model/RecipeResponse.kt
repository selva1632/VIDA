package com.selva.vida.data.remote.model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("recipes") val recipe: List<RecipeInfo>
)
