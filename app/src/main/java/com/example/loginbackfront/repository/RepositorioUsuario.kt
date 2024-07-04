package com.example.loginbackfront.repository

import android.util.Log
import com.example.loginbackfront.reboot.ApiAdapter
import com.example.loginbackfront.reboot.ApiUsuario
import retrofit2.Response

class RepositorioUsuario {

    val apiUsuario : ApiUsuario by lazy {
        ApiAdapter.getInstance().create(ApiUsuario :: class.java)
    }

    suspend fun login(email:String,password:String) : Result<Int>{
        val retorno :Int
        return  try {
            val response : Response<Int> = apiUsuario.login(email,password)
            retorno = response.body() as Int
            Log.d("OK", "${retorno}")
            Result.success(retorno)
        }catch (e : Exception){
            Log.d("error", "${e.message}")
            Result.failure(e)
        }
    }
}