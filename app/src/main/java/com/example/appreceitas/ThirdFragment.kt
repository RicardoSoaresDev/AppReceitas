package com.example.appreceitas

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appreceitas.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    var list = FakeDB.dbObject

    private var _binding: FragmentThirdBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val map = list.groupBy {
            it.type
        }.toList()

        // initialize parent adapter
        binding.idRecyclerView.apply {
            adapter = ParentAdapterRecyclerView(map, onClick = {
                val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(it)
                findNavController().navigate(action)
            })
            layoutManager = LinearLayoutManager(context)
        }

//        binding.idRecyclerView.adapter = ParentAdapterRecyclerView(map, onClick = {
//            val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(it)
//            findNavController().navigate(action)
//        })
//        binding.idRecyclerView.layoutManager = LinearLayoutManager(context)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
