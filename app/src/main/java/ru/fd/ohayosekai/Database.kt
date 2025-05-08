package ru.fd.ohayosekai

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Action::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun getActionDao(): ActionDao

}