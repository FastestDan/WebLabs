package ru.fd.ohayosekai

import android.content.Context
import androidx.room.Room

object Dep {

    lateinit var context: Context
    lateinit var thebake: Database

    fun initDB(){
        thebake = Room.databaseBuilder(
            context,
            Database::class.java,
            "Data"
        ).build()
    }

}