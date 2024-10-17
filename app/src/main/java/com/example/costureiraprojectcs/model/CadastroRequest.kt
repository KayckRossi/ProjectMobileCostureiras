package com.example.costureiraprojectcs.model

data class CadastroRequest(
    val cpf: String,
    val senha: String,
    val telefone: String,
    val endereco: String
)
