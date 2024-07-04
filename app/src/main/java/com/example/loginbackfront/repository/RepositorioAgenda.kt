package com.example.loginbackfront.repository

import android.util.Log
import com.example.loginbackfront.model.ListAgenda
import com.example.loginbackfront.reboot.ApiAdapter
import com.example.loginbackfront.reboot.ApiAgenda
import com.example.loginbackfront.reboot.ApiUsuario
import retrofit2.Response

class RepositorioAgenda {
    val apiAgenda : ApiAgenda by lazy {
        ApiAdapter.getInstance().create(ApiAgenda :: class.java)
    }

    suspend fun getAll() : Result<ListAgenda> {
        val retorno : ListAgenda
        return try {
            val response : Response<ListAgenda> = apiAgenda.getAll()
            retorno = response.body() as ListAgenda
            Log.d("OK", "${retorno}")
            Result.success(retorno)
        } catch (e : Exception) {
            Log.d("error", "${e.message}")
            Result.failure(e)
        }
    }
}