package com.moneymanager.manager

import android.content.Context
import com.moneymanager.MyApplication
import com.moneymanager.utils.SingletonHolder
import io.realm.DynamicRealm
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration

class RealmManager private constructor(context: Context) {

    private lateinit var config: RealmConfiguration

    companion object : SingletonHolder<RealmManager, Context>(::RealmManager) {
        const val REALM_PATH = "moneymanager.realm"
    }

    init {

        initRealmConfiguration(context)
        initRawData()
    }

    private fun initRealmConfiguration(context: Context) {

        println("Realm manager init")
        Realm.init(context)

        println("Realm manager config")
        config = RealmConfiguration.Builder()
                .name(REALM_PATH)
                .schemaVersion(1)
                .migration(MyRealmMigration())
                .build()

        println("Realm manager set config")
        Realm.setDefaultConfiguration(config)
    }

    private fun initRawData() {

        val listOfRecords = CsvReader.getData(MyApplication.getMyApplicationContext())
    }

    private class MyRealmMigration : RealmMigration {

        override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {

            var oldVersion = oldVersion
            val schema = realm.schema

            if (oldVersion == 0L) {
                schema.get("Record")!!
                        .renameField("id", "uniqueId")
                oldVersion++
            }
        }
    }


}