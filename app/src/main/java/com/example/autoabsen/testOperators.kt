package com.example.autoabsen

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val start by lazy { APIMain().end }

fun main(){
    start.checkRow("ABSCL004")
        .enqueue(object : Callback<Login>{
            override fun onResponse(call: Call<Login>, response: Response<Login>) {
                if(response.isSuccessful){
                    if(response.toString().isNullOrEmpty()){
                        println("Wrong ID")
                    }
                    else{
                        println("Welcome")
                    }
                }
            }

            override fun onFailure(call: Call<Login>, t: Throwable) {}

        })
}