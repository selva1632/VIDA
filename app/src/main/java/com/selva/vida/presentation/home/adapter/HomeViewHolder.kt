package com.selva.vida.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.selva.vida.data.remote.model.RecipeInfo
import com.selva.vida.databinding.HomeViewHolderBinding

class HomeViewHolder(
    private val binding: HomeViewHolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(info: RecipeInfo, onClick: (Int) -> Unit) {
        binding.bindItem = info

        with(binding.recipeImage) {
            Glide.with(this)
                .load(info.image)
                .transform(RoundedCorners(24))
                .into(this)

            setOnClickListener {
                onClick(info.id)
            }
        }
    }
}