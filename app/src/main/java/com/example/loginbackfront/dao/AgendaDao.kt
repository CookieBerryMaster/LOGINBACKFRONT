package com.example.loginbackfront.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.loginbackfront.entity.Agenda

@Dao
interface AgendaDao {
    //que consulta ejecutara
    @Query("SELECT * FROM AGENDA")
    suspend fun getAll():List<Agenda>

    @Insert
    suspend fun insertObj(obj:Agenda)

    @Insert
    suspend fun insertList(obj:List<Agenda>)

    @Update
    suspend fun updateObj(obj: Agenda)

    @Delete
    suspend fun deleteObj(obj: Agenda)

    @Delete
    suspend fun deleteList(obj:List<Agenda>)

    @Query("SELECT * FROM AGENDA WHERE id = :pid")
    suspend fun getByID(pid : String)
}