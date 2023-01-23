package com.example.appreceitas

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appreceitas.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button1 = binding.button1
        val button2 = binding.button2

        button1.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        button2.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}