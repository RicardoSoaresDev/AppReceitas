package com.example.appreceitas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager


class ThirdFragment : Fragment(R.layout.fragment_third) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.idRecyclerView)
        recyclerView.adapter = AdapterRecyclerView(recipes(), context)

        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
    }

    private fun recipes(): List<Model> {
        return listOf(
            Model("hfgghdhd",
                "dfghsdfgdfgf",
            "kkk"),
            Model("dfgdfsgdsfg",
                "dfgdfsgdsfgdfsg",
            "abc"),
            Model("dfgsdfgf",
                "dfgdfsgdfsgfd",
            "def"))
    }
}