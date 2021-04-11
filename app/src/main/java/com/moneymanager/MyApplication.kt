package com.moneymanager

import android.app.Application
import android.content.Context
import com.moneymanager.manager.CsvReader
import com.moneymanager.manager.RealmManager

class  MyApplication : Application() {

    private lateinit var realmManager : RealmManager

    companion object {

        private lateinit var myContext : Context

        fun getMyApplicationContext() = myContext
    }

    init {
        println("Init MyApplication")
    }

    override fun onCreate() {
        super.onCreate()

        println("Create MyApplication")
        myContext = applicationContext

        initManagers()
    }

    private fun initManagers() {

        realmManager = RealmManager.getInstance(applicationContext)
    }
}