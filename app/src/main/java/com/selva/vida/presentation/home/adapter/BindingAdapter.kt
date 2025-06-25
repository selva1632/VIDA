package com.selva.vida.presentation.home.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.selva.vida.data.remote.model.RecipeInfo

@BindingAdapter("homeItem")
fun bindRecyclerViewItems(recyclerView: RecyclerView, newRecipeInfo: List<RecipeInfo>?) {
    val adapter = recyclerView.adapter as? HomeAdapter
    adapter?.submitList(newRecipeInfo ?: emptyList())
}