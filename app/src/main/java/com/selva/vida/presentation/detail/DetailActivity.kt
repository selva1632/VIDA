package com.selva.vida.presentation.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.selva.vida.databinding.ActivityDetailBinding
import com.selva.vida.presentation.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipeId = intent.getIntExtra(HomeActivity.KEY_RECIPE, 0)
        viewModel.fetchRecipeById(recipeId)

        viewModel.recipeDetails.observe(this) {
            with(binding) {
                detailName.text = it.name
                Glide.with(detailImage).load(it.image).into(detailImage)
                detailInstruction.text = it.instructions.joinToString(separator = "\n") {"- $it"}
            }
        }
    }
}