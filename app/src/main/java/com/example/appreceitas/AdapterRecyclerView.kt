package com.example.appreceitas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class AdapterRecyclerView(private val recipes: MutableList<Model>, private val context: Context?) : Adapter<AdapterRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bindView(recipe)

//        holder.title.text = recipe.title
//        holder.ingredients.text = recipe.ingredients
//        holder.preparationMode.text = recipe.prepMode
    }

    override fun getItemCount(): Int {
        return recipes.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.recipeTitle)
        val ingredients = itemView.findViewById<TextView>(R.id.recipeIngredients)
        val preparationMode = itemView.findViewById<TextView>(R.id.recipePrepMode)

        fun bindView(recipe: Model) {

            title.text = recipe.title
            ingredients.text = recipe.ingredients
            preparationMode.text = recipe.prepMode

        }
    }
}