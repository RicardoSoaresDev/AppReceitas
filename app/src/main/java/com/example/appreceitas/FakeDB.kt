package com.example.appreceitas

object FakeDB {
    var dbObject = mutableListOf<Model>()

    fun addRecipe(recipe: Model) {
        dbObject.add(recipe)
    }
}