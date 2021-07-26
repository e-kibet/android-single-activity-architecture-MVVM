package com.example.todoapp.responses

data class PhoneResponse(
    val `data`: Data,
    val status: Boolean,
    val status_code: Int,
    val status_message: String
)