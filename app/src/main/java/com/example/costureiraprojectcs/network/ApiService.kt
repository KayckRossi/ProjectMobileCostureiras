package com.example.costureiraprojectcs.network

import com.example.costureiraprojectcs.model.LoginRequest
import com.example.costureiraprojectcs.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}

//51603220003