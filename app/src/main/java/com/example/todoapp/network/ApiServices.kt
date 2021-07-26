package com.example.todoapp.network
import com.example.todoapp.responses.PhoneResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiServices {

    @POST("/auth/checkphone")
    @FormUrlEncoded
    suspend fun checkPhone(
        @Field("msisdn") msisdn: String
    ) : PhoneResponse
}