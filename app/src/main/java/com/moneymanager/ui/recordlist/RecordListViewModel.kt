package com.moneymanager.ui.recordlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moneymanager.model.Record
import io.realm.Realm
import io.realm.kotlin.where


class RecordListViewModel : ViewModel() {

    val recordListLive = MutableLiveData<List<Record>>()

    init {

    }

    fun fetchRecordList(){

        var realm = Realm.getDefaultInstance()

        val list = realm.where<Record>().findAll()
        val copyList = realm.copyFromRealm(list)

        recordListLive.value = copyList

        realm.close()
    }

    private fun createRecord(position: Int) : Record{
           return Record()
    }
}