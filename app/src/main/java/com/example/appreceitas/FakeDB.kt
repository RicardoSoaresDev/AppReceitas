package com.example.appreceitas

object FakeDB {
    var dbObject = mutableListOf<ModelParent>()

    fun addRecipe(recipe: ModelParent) {
        dbObject.add(recipe)
    }

    fun createModel(model: Model) : List<Model> {
        return listOf(model)
    }
}