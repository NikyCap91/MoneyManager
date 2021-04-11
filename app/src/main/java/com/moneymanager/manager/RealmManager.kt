package com.moneymanager.manager

import android.content.Context
import com.moneymanager.utils.SingletonHolder
import io.realm.DynamicRealm
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration

class RealmManager private constructor(context: Context){

    private var config: RealmConfiguration
    companion object : SingletonHolder<RealmManager, Context>(::RealmManager)

    init {

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