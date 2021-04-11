package com.moneymanager.manager

import android.content.Context
import com.moneymanager.MyApplication
import com.moneymanager.model.Record
import com.moneymanager.utils.SingletonHolder
import io.realm.DynamicRealm
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration
import io.realm.kotlin.createObject
import java.util.*

class RealmManager private constructor(context: Context){

    private lateinit var config: RealmConfiguration
    companion object : SingletonHolder<RealmManager, Context>(::RealmManager)

    init {

        initRealmConfiguration(context)
        initMockData()
        initRawData()
    }

    private fun initRealmConfiguration(context: Context) {

        println("Realm manager init")
        Realm.init(context)

        println("Realm manager config")
        config = RealmConfiguration.Builder()
            .name("moneymanager.realm")
            .schemaVersion(1)
            .migration(MyRealmMigration())
            .build()

        println("Realm manager set config")
        Realm.setDefaultConfiguration(config)
    }

    private fun initMockData(){

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

    private fun initRawData() {

        val listOfRecords = CsvReader.getData(MyApplication.getMyApplicationContext())
        


    }

    private class MyRealmMigration : RealmMigration {

        override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {

            var oldVersion = oldVersion
            val schema = realm.schema

            if(oldVersion == 0L) {
                schema.get("Record")!!
                    .renameField("id","uniqueId")
                oldVersion++
            }
        }
    }


}