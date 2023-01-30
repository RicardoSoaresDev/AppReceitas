package com.example.appreceitas.db

import com.example.appreceitas.model.Model
import com.example.appreceitas.model.ModelParent

object FakeDB {
    var dbObject = mutableListOf<ModelParent>()

    fun addRecipe(recipe: ModelParent) {
        dbObject.add(recipe)
    }

    fun createRecipe(model: Model) : List<Model> {
        return listOf(model)
    }

    fun updateRecipe(recipe: ModelParent, updatedRecipe: ModelParent) {
        recipe.type = updatedRecipe.type
        recipe.recipeInfo[0].title = updatedRecipe.recipeInfo[0].title
        recipe.recipeInfo[0].ingredients = updatedRecipe.recipeInfo[0].ingredients
        recipe.recipeInfo[0].prepMode = updatedRecipe.recipeInfo[0].prepMode
    }

    fun deleteRecipe(recipe: ModelParent) {
        dbObject.remove(recipe)
    }
}