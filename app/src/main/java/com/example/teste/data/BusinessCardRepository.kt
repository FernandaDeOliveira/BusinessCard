package com.example.teste.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository (private  val dao: BusinessCardDao){

    //funcoes do model p com DB

    fun insert(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO){
            dao.insert(businessCard)
        }
    }

    fun getAll() = dao.getAll()

}