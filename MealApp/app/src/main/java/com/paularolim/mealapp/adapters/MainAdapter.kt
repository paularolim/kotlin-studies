package com.paularolim.mealapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.paularolim.mealapp.data.Category
import com.paularolim.mealapp.databinding.CategoryItemBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var categories = mutableListOf<Category>()

    fun setCategoryList(categories: List<Category>) {
        this.categories = categories.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CategoryItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val category = categories[position]
        holder.binding.categoryName.text = category.category
        Glide.with(holder.itemView.context).load(category.image).into(holder.binding.categoryImage)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class MainViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
