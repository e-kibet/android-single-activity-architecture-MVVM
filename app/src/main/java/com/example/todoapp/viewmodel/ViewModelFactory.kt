package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.repository.BaseRepository
import com.example.todoapp.repository.PhoneRepository
import java.lang.IllegalArgumentException

class ViewModelFactory (
    private val repository: BaseRepository
): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(PhoneViewModel::class.java)->PhoneViewModel(repository as PhoneRepository) as T
            else -> throw IllegalArgumentException("ViewModel class not found")
        }
    }
}