package com.example.appreceitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.appreceitas.databinding.FragmentFifthBinding
import com.example.appreceitas.databinding.FragmentFourthBinding
import com.example.appreceitas.db.FakeDB
import com.example.appreceitas.model.Model
import com.example.appreceitas.model.ModelParent


class FifthFragment : Fragment() {

    private val args: FifthFragmentArgs by navArgs()

    private var _binding: FragmentFifthBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var title = binding.updateTitle
        var ingredients = binding.updateIngredients
        var prepMode = binding.updateMode

        val updateButton = binding.updateButton
        val updateRadioGroup = binding.updateRadioGroup

        title.setText(args.recipeUpdate.title)
        ingredients.setText(args.recipeUpdate.ingredients)
        prepMode.setText(args.recipeUpdate.prepMode)


        updateButton.setOnClickListener {

            if (title.text.toString().isEmpty()) {
                title.setError("Este campo não pode ficar vazio.")
                !updateButton.isEnabled
            } else if (ingredients.text.toString().isEmpty()) {
                ingredients.setError("Este campo não pode ficar vazio.")
                !updateButton.isEnabled
            } else if (prepMode.text.toString().isEmpty()) {
                prepMode.setError("Este campo não pode ficar vazio.")
                !updateButton.isEnabled
            } else if (updateRadioGroup.checkedRadioButtonId == -1) {
                !updateButton.isEnabled
            } else {

                val radioButton =
                    view.findViewById<RadioButton>(updateRadioGroup.checkedRadioButtonId)

                val updateRecipe = ModelParent(
                    type = radioButton.text.toString(),
                    recipeInfo = FakeDB.createRecipe(
                        Model(
                            title = title.text.toString(),
                            ingredients = ingredients.text.toString(),
                            prepMode = prepMode.text.toString()
                        )
                    )
                )

                FakeDB.dbObject.find {
                    it.recipeInfo[0].title == args.recipeUpdate.title
                }?.let {
                    FakeDB.updateRecipe(it, updateRecipe)
                }


                findNavController().navigate(R.id.action_fifthFragment_to_thirdFragment)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
