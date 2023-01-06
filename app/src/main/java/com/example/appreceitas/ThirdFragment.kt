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

    var list = FakeDB.dbObject

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.idRecyclerView)
//        recyclerView.adapter = AdapterRecyclerView(recipes(), context)
        recyclerView.adapter = AdapterRecyclerView(list, context)

        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
    }

//    private fun recipes(): MutableList<Model> {
//        return mutableListOf(
//            Model("Pizza Calabresa",
//                "1- calabresa \n2- mussarela \n3- orégano ",
//                "..."),
//            Model("Strogonoff",
//                "1- carne picada \n2- molho branco \n3- alho \n4- sal \n5- cebola",
//            "..."),
//            Model("dfgsdfgf",
//                "dfgdfsgdfsgfd",
//            "def"))
//    }


}