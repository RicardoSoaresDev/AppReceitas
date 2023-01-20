package com.example.appreceitas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_third.*


class ThirdFragment : Fragment(R.layout.fragment_third) {

    var list = FakeDB.dbObject

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val map = list.groupBy {
            it.type
        }.toList()

        // initialize parent adapter
        idRecyclerView.adapter = ParentAdapterRecyclerView(map, onClick = {
            val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(it)
            findNavController().navigate(action)
        })
        idRecyclerView.layoutManager = LinearLayoutManager(context)

    }

}
