package com.example.costureiraprojectcs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.costureiraprojectcs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializando o view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurando o botão de Login para abrir a tela de login
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

        // Configurando o botão de Registro para abrir a tela de registro
        binding.btnRegistrar.setOnClickListener {
            val intent = Intent(this, registrarActivity::class.java)
            startActivity(intent)
        }
    }
}
