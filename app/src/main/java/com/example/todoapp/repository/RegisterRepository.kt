package com.example.todoapp.repository

import com.example.todoapp.network.ApiServices

class RegisterRepository(private val api: ApiServices) : BaseRepository (){
    suspend fun register(first_name: String, last_name: String, msisdn: String, group_id: String, password: String) {
        api.register(first_name, last_name, msisdn, group_id, password)
    }
}