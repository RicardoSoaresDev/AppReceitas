package com.example.appreceitas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager


class ThirdFragment : Fragment(R.layout.fragment_third) {

    var list = FakeDB.dbObject

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.idRecyclerView)
//        recyclerView.adapter = AdapterRecyclerView(list, context, onClick = {
//            findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
//        })

        recyclerView.adapter = AdapterRecyclerView(list, context, onClick = {
            val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(it)
            findNavController().navigate(action)
        })

        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
    }

}
