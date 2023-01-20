package com.example.appreceitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.navArgs

class FourthFragment : Fragment(R.layout.fragment_fourth) {

    private val args: FourthFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = view.findViewById<TextView>(R.id.textViewName)
        val ingredients = view.findViewById<TextView>(R.id.textViewIngredients)
        val mode = view.findViewById<TextView>(R.id.textViewMode)

        title?.text = args.recipe.title
        ingredients?.text = args.recipe.ingredients
        mode?.text = args.recipe.prepMode
    }

}