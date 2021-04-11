package com.moneymanager.ui.recordlist

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.moneymanager.manager.RealmManager
import com.moneymanager.model.Record
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import java.util.*


class RecordListViewModel : ViewModel() {

    val recordListLive = MutableLiveData<List<Record>>()

    init {
        println("Get realm")
        var realm = Realm.getDefaultInstance()

        println("Clean and write records")
        realm.executeTransaction {

            realm.deleteAll()

            for (i in 1..20) {
                realm.createObject<Record>(UUID.randomUUID().toString())
            }
        }

        println("Close realm")
        realm.close()
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