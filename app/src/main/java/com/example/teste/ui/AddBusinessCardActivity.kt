package com.example.teste.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.teste.App
import com.example.teste.R
import com.example.teste.data.BusinessCard
import com.example.teste.databinding.ActivityAddBusinessCardBinding
import com.example.teste.databinding.ActivityMainBinding

class AddBusinessCardActivity : AppCompatActivity() {


    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }
    //viewmodel responde p a view
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)// injeta repositorio na viewmodel
    }
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
            val businessCard = BusinessCard(
                //acessando o texto q esta na view - o que o user digita
                name = binding.inputName.editText?.text.toString(),
                phone = binding.inputTelephone.editText?.text.toString(),
                email = binding.inputEmail.editText?.text.toString(),
                company = binding.inputCompany.editText?.text.toString(),
                background = binding.inputColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}