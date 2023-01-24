package com.example.appreceitas.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appreceitas.model.ModelParent
import com.example.appreceitas.view.adapter.ParentAdapterRecyclerView
import com.example.appreceitas.view.ui.ThirdFragmentDirections

class ThirdFragmentViewModel: ViewModel() {

    fun initParentAdapter(list: MutableList<ModelParent>, idRecyclerView: RecyclerView) {

        val map = list.groupBy {
            it.type
        }.toList()

        // initialize parent adapter
        idRecyclerView.apply {
            adapter = ParentAdapterRecyclerView(map, onClick = {
                val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(it)
                findNavController().navigate(action)
            })
            layoutManager = LinearLayoutManager(context)
        }
    }
}