package com.example.costureiraprojectcs.network

import com.example.costureiraprojectcs.model.LoginRequest
import com.example.costureiraprojectcs.model.LoginResponse
import com.example.costureiraprojectcs.model.CadastroRequest
import com.example.costureiraprojectcs.model.CadastroResponse
import com.example.costureiraprojectcs.model.PedidoRequest
import com.example.costureiraprojectcs.model.PedidoResponse
import com.example.costureiraprojectcs.model.ProdutoResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET

interface ApiService {
    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("cadastro")
    fun cadastro(@Body request: CadastroRequest): Call<CadastroResponse>

    @POST("cadastrarPedido")
    fun cadastrarPedido(@Body request: PedidoRequest): Call<PedidoResponse>

    @GET("produtos")
    fun obterProdutos(): Call<List<ProdutoResponse>>

}

//51603220003