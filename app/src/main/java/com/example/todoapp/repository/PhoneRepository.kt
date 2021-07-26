package com.example.todoapp.repository

import com.example.todoapp.network.ApiServices

class PhoneRepository(private val api: ApiServices) : BaseRepository() {
    suspend fun checkPhone(msisdn: String) = safeApiCall {
        api.checkPhone(msisdn)
    }
}