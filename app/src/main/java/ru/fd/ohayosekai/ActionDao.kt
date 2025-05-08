package ru.fd.ohayosekai

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ActionDao {
    @Insert
    suspend fun add(action: Action)

    @Delete
    suspend fun delete(action: Action)

    @Update
    suspend fun update(action: Action)

    @Query("SELECT * FROM `Action`")
    suspend fun getAll(): List<Action>
}