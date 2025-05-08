package ru.fd.ohayosekai

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Dep.context = applicationContext
        Dep.initDB()
    }

}