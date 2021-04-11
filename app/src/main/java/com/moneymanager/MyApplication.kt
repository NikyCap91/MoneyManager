package com.moneymanager

import android.app.Application
import com.moneymanager.manager.RealmManager

class  MyApplication : Application() {

    private lateinit var realmManager : RealmManager

    init {
        println("Init MyApplication")
    }

    override fun onCreate() {
        super.onCreate()
        
        println("Create MyApplication")
        initManagers()
    }

    private fun initManagers(){

        realmManager = RealmManager.getInstance(applicationContext)
    }
}