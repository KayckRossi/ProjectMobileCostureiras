package com.example.costureiraprojectcs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.costureiraprojectcs.network.RetrofitClient
import com.example.costureiraprojectcs.network.ApiService
import com.example.costureiraprojectcs.model.LoginRequest
import com.example.costureiraprojectcs.model.LoginResponse

class LoginActivity : AppCompatActivity() {

    private lateinit var editCpf: EditText
    private lateinit var editSenha: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editCpf = findViewById(R.id.editCpf)
        editSenha = findViewById(R.id.editSenha)
        btnLogin = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            realizarLogin()
        }
    }

    private fun realizarLogin() {
        val cpf = editCpf.text.toString()
        val senha = editSenha.text.toString()

        if (cpf.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            return
        }

        val loginRequest = LoginRequest(cpf, senha)

        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val loginResponse = response.body()
                Log.d("LoginActivity", "Resposta da API: ${response.body()}")
                if (response.isSuccessful && loginResponse?.message == "success") {
                    Toast.makeText(this@LoginActivity, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()

                    // Navega para a tela home
                    val intent = Intent(this@LoginActivity, homeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@LoginActivity, "Falha no login! Verifique seu CPF e senha.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
