package com.example.appreceitas.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appreceitas.databinding.LayoutCardBinding
import com.example.appreceitas.model.Model
import com.example.appreceitas.model.ModelParent


class ChildAdapterRecyclerView(private val recipes: List<ModelParent>,
                               private val onClick: (Model) -> Unit) : RecyclerView.Adapter<ChildAdapterRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        recipe.recipeInfo.forEach {
            model ->  holder.bindView(model, onClick)
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }


    class ViewHolder(binding: LayoutCardBinding) : RecyclerView.ViewHolder(binding.root) {

        val title = binding.recipeTitle
        val ingredients = binding.recipeIngredients
        val preparationMode = binding.recipePrepMode

        fun bindView(recipe: Model, onClick: (Model) -> Unit) {

            title.text = recipe.title
            ingredients.text = recipe.ingredients
            preparationMode.text = recipe.prepMode

            itemView.setOnClickListener {
                onClick(recipe)
            }
        }
    }
}