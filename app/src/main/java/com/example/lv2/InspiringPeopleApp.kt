package com.example.lv2

import android.app.Application

class InspiringPeopleApp : Application() {

    companion object{
        lateinit var application: InspiringPeopleApp
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}