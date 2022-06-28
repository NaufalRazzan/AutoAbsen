package com.example.autoabsen

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APInterface {
    @FormUrlEncoded
    @POST("checkRow.php")
    fun checkRow(
        @Field("post_id") post_id : String
    ) : Call<Login>
}