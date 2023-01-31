package com.example.appreceitas.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.appreceitas.R
import com.example.appreceitas.databinding.FragmentFifthBinding
import com.example.appreceitas.viewmodel.FifthFragmentViewModel


class FifthFragment : Fragment() {

    private val args: FifthFragmentArgs by navArgs()

    private var _binding: FragmentFifthBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: FifthFragmentViewModel

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

        val title = binding.updateTitle
        val ingredients = binding.updateIngredients
        val prepMode = binding.updateMode

        val updateButton = binding.updateButton
        val updateRadioGroup = binding.updateRadioGroup

        title.setText(args.recipeUpdate.title)
        ingredients.setText(args.recipeUpdate.ingredients)
        prepMode.setText(args.recipeUpdate.prepMode)


        updateButton.setOnClickListener {

            viewModel = ViewModelProvider(this)[FifthFragmentViewModel::class.java]

            viewModel.isValidUpdate(view, args, title, ingredients, prepMode, updateRadioGroup, updateButton)

            if (viewModel.statusUpdate) {
                findNavController().navigate(R.id.action_fifthFragment_to_thirdFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
