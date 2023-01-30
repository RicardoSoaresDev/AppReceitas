package com.example.appreceitas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appreceitas.db.FakeDB
import com.example.appreceitas.model.ModelParent

class ThirdFragmentViewModel: ViewModel() {

    val groupedList = MutableLiveData<List<Pair<String, List<ModelParent>>>>()

    fun groupList() {
        groupedList.value = FakeDB.dbObject.groupBy {
            it.type
        }.toList()
    }
}