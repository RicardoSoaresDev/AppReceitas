package com.example.appreceitas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appreceitas.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
    }
}