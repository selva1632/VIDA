package com.selva.vida.presentation.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.selva.vida.data.remote.model.RecipeInfo
import com.selva.vida.databinding.HomeViewHolderBinding

class HomeAdapter(private val onclick: (Int) -> Unit) : RecyclerView.Adapter<HomeViewHolder>() {

    private val items = mutableListOf<RecipeInfo>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newList: List<RecipeInfo>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            HomeViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(items[position], onclick)
    }
}