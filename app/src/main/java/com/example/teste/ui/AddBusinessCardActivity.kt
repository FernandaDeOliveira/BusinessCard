package com.example.teste.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teste.databinding.ActivityAddBusinessCardBinding
import com.example.teste.databinding.ActivityMainBinding

class AddBusinessCardActivity : AppCompatActivity() {


    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener(){
        binding.btnClose.setOnClickListener {
            finish()
            //fecha activity ao clicar
        }
        binding.btnSave.setOnClickListener {

        }
    }
}