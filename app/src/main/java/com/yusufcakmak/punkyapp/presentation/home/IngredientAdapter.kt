package com.yusufcakmak.punkyapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yusufcakmak.punkyapp.R
import com.yusufcakmak.punkyapp.databinding.ItemIngredientBinding

class IngredientAdapter : RecyclerView.Adapter<IngredientAdapter.ViewHolder>() {

    private val ingredientList = mutableListOf<String?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemIngredientBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_ingredient, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ingredientList[position])
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    fun appendList(list: List<String?>) {
        ingredientList.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemIngredientBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String?) {
            binding.tvIngredient.text = item
        }
    }
}