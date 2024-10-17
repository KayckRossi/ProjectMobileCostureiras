package com.example.costureiraprojectcs.model

data class ProdutoResponse(
    val id: Int,
    val nome: String,
    val descricao: String?,
    val preco: Double
)