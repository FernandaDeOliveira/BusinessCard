package com.example.teste.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [BusinessCard::class],version = 1)
abstract class AppDataBase : RoomDatabase(){
    //gerencia o DB
    abstract fun businessDao() : BusinessCardDao

    companion object{
        @Volatile
        private var INSTANCE : AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase{
            return INSTANCE ?: synchronized(this){
                val instance  = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "businesscard_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}