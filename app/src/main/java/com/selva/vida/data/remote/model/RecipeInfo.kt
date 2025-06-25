package com.selva.vida.data.remote.model

import com.google.gson.annotations.SerializedName

data class RecipeInfo(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("instructions") val instructions: List<String>
)
