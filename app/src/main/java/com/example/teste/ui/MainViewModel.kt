package com.example.teste.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.teste.data.BusinessCard
import com.example.teste.data.BusinessCardRepository
import java.lang.IllegalArgumentException

class MainViewModel(private val businessCardRepository: BusinessCardRepository) : ViewModel() {
    //trafega os dados do repository c a tela

    fun insert(businessCard : BusinessCard) {
        businessCardRepository.insert(businessCard)
    }
    fun getAll() : LiveData<List<BusinessCard>>{
        return businessCardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: BusinessCardRepository) : ViewModelProvider.Factory {
    //cria uma intancia da viewmodel
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("Unchecked")
            return MainViewModelFactory(repository) as T
        }
           throw IllegalArgumentException("Unknown Viewmodel class")
    }
}