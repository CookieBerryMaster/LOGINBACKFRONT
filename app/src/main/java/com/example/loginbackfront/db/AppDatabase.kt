package com.example.loginbackfront.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.loginbackfront.dao.AgendaDao
import com.example.loginbackfront.entity.Agenda


@Database(
    entities = [Agenda::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun agendaDAO():AgendaDao

    companion object{
        @Volatile
        private var INSTANCE :AppDatabase?=null

        fun getDatabase(context : Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "AgendaDb"
                ).build()
                INSTANCE = instance
                instance

            }
        }
    }
}