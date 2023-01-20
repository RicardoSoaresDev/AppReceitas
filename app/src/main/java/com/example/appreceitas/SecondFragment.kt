package com.example.appreceitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<EditText>(R.id.editTextName)
        val ingredients = view.findViewById<EditText>(R.id.editTextIngredients)
        val preparationMode = view.findViewById<EditText>(R.id.editTextMode)
        val button3 = view.findViewById<Button>(R.id.button3)

        button3.setOnClickListener {

            if (name.text.toString().isEmpty()) {
                name.setError("Este campo não pode ficar vazio.")
                !button3.isEnabled
            } else if (ingredients.text.toString().isEmpty()) {
                ingredients.setError("Este campo não pode ficar vazio.")
                !button3.isEnabled
            } else if (preparationMode.text.toString().isEmpty()) {
                preparationMode.setError("Este campo não pode ficar vazio.")
                !button3.isEnabled
            } else if (radioGroup.checkedRadioButtonId == -1) {
                !button3.isEnabled
            } else {
                val radioButton = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

                FakeDB.addRecipe(
                    ModelParent(
                        type = radioButton.text.toString(),
                        recipeInfo = FakeDB.createModel(
                            Model(
                                name.text.toString(),
                                ingredients.text.toString(),
                                preparationMode.text.toString()
                            )
                        )
                    )
                )
                findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            }
        }
    }
}