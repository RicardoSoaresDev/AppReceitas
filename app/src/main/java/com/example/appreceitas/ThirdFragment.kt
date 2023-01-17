package com.example.appreceitas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_third.*


class ThirdFragment : Fragment(R.layout.fragment_third) {

    var list = FakeDB.dbObject

    var listSections = mutableListOf<String>("Seção 1", "Seção 2", "Seção 3")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initialize parent adapter
        idRecyclerView.adapter = ParentAdapterRecyclerView(listSections, list, context)
        idRecyclerView.layoutManager = LinearLayoutManager(context)

    }

}
