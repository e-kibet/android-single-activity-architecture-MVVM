package com.example.todoapp.network
import com.example.todoapp.responses.PhoneResponse
import com.example.todoapp.responses.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiServices {
    @POST("/auth/checkphone")
    @FormUrlEncoded
    suspend fun checkPhone(@Field("msisdn") msisdn: String) : PhoneResponse

    @POST("/users")
    @FormUrlEncoded
    suspend fun register(@Field("first_name") first_name: String, @Field("last_name") last_name: String, @Field("msisdn") msisdn: String, @Field("group_id") group_id: String, @Field("password") password: String ): RegisterResponse

}