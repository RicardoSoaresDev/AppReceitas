package com.example.appreceitas.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appreceitas.databinding.FragmentThirdBinding
import com.example.appreceitas.db.FakeDB
import com.example.appreceitas.view.adapter.ParentAdapterRecyclerView
import com.example.appreceitas.viewmodel.ThirdFragmentViewModel


class ThirdFragment : Fragment() {

    var list = FakeDB.dbObject

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ThirdFragmentViewModel

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

        val idRecyclerView = binding.idRecyclerView

        viewModel = ViewModelProvider(this)[ThirdFragmentViewModel::class.java]

        viewModel.initParentAdapter(list = this.list, idRecyclerView = idRecyclerView)
        
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


//        val map = list.groupBy {
//            it.type
//        }.toList()
//
//        // initialize parent adapter
//        binding.idRecyclerView.apply {
//            adapter = ParentAdapterRecyclerView(map, onClick = {
//                val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(it)
//                findNavController().navigate(action)
//            })
//            layoutManager = LinearLayoutManager(context)
//        }
