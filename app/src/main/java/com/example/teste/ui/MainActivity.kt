package com.example.teste.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teste.R
import com.example.teste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener(){
        binding.addCard.setOnClickListener {
            //isso aqui é uma intencao, diz que ao clicar no botao da main vai puxar a de add
            val intent = Intent(this@MainActivity, AddBusinessCardActivity ::class.java)
            startActivity(intent)
        }
    }
}