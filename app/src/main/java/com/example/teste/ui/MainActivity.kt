package com.example.teste.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.teste.App
import com.example.teste.R
import com.example.teste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    //viewmodel responde p a view
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)// injeta repositorio na viewmodel
    }
    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListener()
    }

    private fun insertListener(){
        binding.addCard.setOnClickListener {
            //isso aqui é uma intencao, diz que ao clicar no botao da main vai puxar a de add
            val intent = Intent(this@MainActivity, AddBusinessCardActivity ::class.java)
            startActivity(intent)
        }
    }

    private fun getAllBusinessCard(){
        //busca alteraçoes dos cartoes
        mainViewModel.getAll().observe(this,{ businessCards ->
            adapter.submitList(businessCards)
        })
    }
}