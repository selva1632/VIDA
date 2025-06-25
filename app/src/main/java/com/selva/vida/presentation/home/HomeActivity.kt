package com.selva.vida.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.selva.vida.databinding.ActivityHomeBinding
import com.selva.vida.presentation.detail.DetailActivity
import com.selva.vida.presentation.home.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewmodel by viewModels<RecipeViewModel>()
    private val adapter by lazy {
        HomeAdapter(::launchDetailActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            homeRecyclerView.adapter = adapter
            homeRecyclerView.layoutManager = GridLayoutManager(this@HomeActivity, 2)
            lifecycleOwner = this@HomeActivity
            vm = viewmodel
        }
    }

    private fun launchDetailActivity(id: Int) {
        Intent(this, DetailActivity::class.java).apply {
            putExtra(KEY_RECIPE, id)
        }.also {
            startActivity(it)
        }
    }

    companion object {
        const val KEY_RECIPE = "recipe_key"
    }
}