package com.example.appreceitas.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.fragment.findNavController
import com.example.appreceitas.R
import com.example.appreceitas.databinding.FragmentSecondBinding
import com.example.appreceitas.db.FakeDB
import com.example.appreceitas.model.Model
import com.example.appreceitas.model.ModelParent

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = binding.editTextName
        val ingredients = binding.editTextIngredients
        val preparationMode = binding.editTextMode
        val radioGroup = binding.radioGroup
        val button3 = binding.button3

        button3.setOnClickListener {

            // view model







//            if (name.text.toString().isEmpty()) {
//                name.setError("Este campo não pode ficar vazio.")
//                !button3.isEnabled
//            } else if (ingredients.text.toString().isEmpty()) {
//                ingredients.setError("Este campo não pode ficar vazio.")
//                !button3.isEnabled
//            } else if (preparationMode.text.toString().isEmpty()) {
//                preparationMode.setError("Este campo não pode ficar vazio.")
//                !button3.isEnabled
//            } else if (radioGroup.checkedRadioButtonId == -1) {
//                !button3.isEnabled
//            } else {
//                val radioButton = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
//
//                FakeDB.addRecipe(
//                    ModelParent(
//                        type = radioButton.text.toString(),
//                        recipeInfo = FakeDB.createModel(
//                            Model(
//                                title = name.text.toString(),
//                                ingredients = ingredients.text.toString(),
//                                prepMode = preparationMode.text.toString()
//                            )
//                        )
//                    )
//                )
//                findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
//            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}