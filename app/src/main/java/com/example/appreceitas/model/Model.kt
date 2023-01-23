package com.example.appreceitas.model

import java.io.Serializable

data class Model(
    val title: String,
    val ingredients: String,
    val prepMode: String,
    ): Serializable