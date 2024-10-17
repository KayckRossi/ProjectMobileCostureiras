package com.example.costureiraprojectcs

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.costureiraprojectcs.network.RetrofitClient
import com.example.costureiraprojectcs.network.ApiService
import com.example.costureiraprojectcs.model.CadastroRequest
import com.example.costureiraprojectcs.model.CadastroResponse

class registrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        val btnConfirmar = findViewById<AppCompatButton>(R.id.btn_Registrar_confirmar)
        btnConfirmar.setOnClickListener {
            val cpf = findViewById<EditText>(R.id.edit_Registrar_Cpf).text.toString()
            val senha = findViewById<EditText>(R.id.edit_Registrar_Senha).text.toString()
            val telefone = findViewById<EditText>(R.id.edit_Registrar_Telefone).text.toString()
            val endereco = findViewById<EditText>(R.id.edit_Registrar_Endereco).text.toString()

            Log.d("registrarActivity", "Dados de cadastro: CPF = $cpf, Telefone = $telefone, Endereço = $endereco")

            val request = CadastroRequest(cpf, senha, telefone, endereco)
            val apiService = RetrofitClient.instance.create(ApiService::class.java)

            apiService.cadastro(request).enqueue(object : Callback<CadastroResponse> {
                override fun onResponse(call: Call<CadastroResponse>, response: Response<CadastroResponse>) {
                    Log.d("registrarActivity", "Resposta recebida da API. Código: ${response.code()}")
                    if (response.isSuccessful) {
                        Log.d("registrarActivity", "Cadastro realizado com sucesso! Resposta: ${response.body()}")
                        Toast.makeText(this@registrarActivity, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    } else {
                        Log.d("registrarActivity", "Erro ao realizar cadastro. Código de erro: ${response.code()}")
                        Toast.makeText(this@registrarActivity, "Erro no cadastro.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<CadastroResponse>, t: Throwable) {
                    Log.e("registrarActivity", "Falha na conexão: ${t.message}")
                    Toast.makeText(this@registrarActivity, "Falha na conexão.", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
