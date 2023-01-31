package com.example.appreceitas.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.appreceitas.R
import com.example.appreceitas.databinding.FragmentSecondBinding
import com.example.appreceitas.db.FakeDB
import com.example.appreceitas.viewmodel.SecondFragmentViewModel

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SecondFragmentViewModel

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

//        val dbSizeBefore = FakeDB.dbObject.size

        button3.setOnClickListener {

            viewModel = ViewModelProvider(this)[SecondFragmentViewModel::class.java]

            viewModel.isValidInput(view, name, ingredients, preparationMode, radioGroup, button3)

            if (viewModel.statusCreate) {
                findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            }

//            if (dbSizeBefore < FakeDB.dbObject.size) {
//                findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
//            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}