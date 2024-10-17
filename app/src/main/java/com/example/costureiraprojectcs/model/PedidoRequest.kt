package com.example.costureiraprojectcs.model

data class PedidoRequest(
    val pedido: String,
    val medidas: String,
    val valor: Double,
    val quantidade: Int,
    val formaPagamento: String
)


