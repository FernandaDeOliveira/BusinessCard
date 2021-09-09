package com.example.teste.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class BusinessCard(
    //atributos da classe
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name : String,
    val phone : String,
    val company : String,
    val email : String,
    val background : String
)