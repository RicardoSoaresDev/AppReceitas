package com.example.appreceitas

import android.widget.RadioGroup
import java.io.Serializable

data class Model(
    val title: String,
    val ingredients: String,
    val prepMode: String,
    val type: Int): Serializable