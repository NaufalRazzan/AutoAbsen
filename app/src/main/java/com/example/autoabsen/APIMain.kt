package com.example.autoabsen

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIMain {
    val end: APInterface
    get(){
        val intercept = HttpLoggingInterceptor()
        intercept.level = HttpLoggingInterceptor.Level.BODY

        val makeClient = OkHttpClient.Builder()
            .addInterceptor(intercept)
            .build()

        val ret = Retrofit.Builder()
            .baseUrl("http://192.168.252.234/HelperAndroid/AutoAbsen/")
            .client(makeClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return ret.create(APInterface::class.java)
    }
}