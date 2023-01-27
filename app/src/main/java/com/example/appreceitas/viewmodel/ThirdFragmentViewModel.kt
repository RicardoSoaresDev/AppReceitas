package com.example.appreceitas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appreceitas.db.FakeDB
import com.example.appreceitas.model.ModelParent
import com.example.appreceitas.view.adapter.ParentAdapterRecyclerView
import com.example.appreceitas.view.ui.ThirdFragmentDirections

class ThirdFragmentViewModel: ViewModel() {

    val groupedList = MutableLiveData<List<Pair<String, List<ModelParent>>>>()

    fun groupList() {
        groupedList.value = FakeDB.dbObject.groupBy {
            it.type
        }.toList()
    }
}