package com.example.appreceitas

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.appreceitas.databinding.FragmentFourthBinding

class FourthFragment : Fragment(R.layout.fragment_fourth) {

    private val args: FourthFragmentArgs by navArgs()

    private var _binding: FragmentFourthBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = binding.textViewName
        val ingredients = binding.textViewIngredients
        val mode = binding.textViewMode

        title?.text = args.recipe.title
        ingredients?.text = args.recipe.ingredients
        mode?.text = args.recipe.prepMode
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}