package com.example.loginbackfront.reboot

import com.example.loginbackfront.util.Global
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//para conectarlo a backend
object ApiAdapter {

    val okHttpClient = OkHttpClient.Builder().build()
    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(Global.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}