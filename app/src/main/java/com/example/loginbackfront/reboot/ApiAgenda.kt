package com.example.loginbackfront.reboot

import com.example.loginbackfront.model.ListAgenda
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiAgenda {
    @GET("agenda/all")
    suspend fun getAll(): Response<ListAgenda>
}