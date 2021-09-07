package com.example.teste

import android.app.Application
import com.example.teste.data.AppDataBase
import com.example.teste.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDataBase.getDataBase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}