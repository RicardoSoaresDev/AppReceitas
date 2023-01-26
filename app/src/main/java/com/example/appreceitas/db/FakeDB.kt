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

//    fun updateRecipe(recipe: ModelParent, position: Int) {
//
//    }

    fun deleteRecipe(recipe: ModelParent) {
        dbObject.remove(recipe)
    }
}