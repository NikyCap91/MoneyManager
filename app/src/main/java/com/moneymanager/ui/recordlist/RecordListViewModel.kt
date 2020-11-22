package com.moneymanager.ui.recordlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moneymanager.model.Record


class RecordListViewModel : ViewModel() {

    val recordListLive = MutableLiveData<List<Record>>()

    fun fetchRecordList(){

        val list = mutableListOf<Record>()

        for (i in 1..20) {
           list.add(createRecord(i))
        }

        recordListLive.value = list.toList()
    }

    private fun createRecord(position: Int) : Record{
           return Record(position.toString(),"Record " + position,"")
    }
}