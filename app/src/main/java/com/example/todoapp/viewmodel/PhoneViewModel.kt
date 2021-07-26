package com.example.todoapp.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.network.Resource
import com.example.todoapp.repository.PhoneRepository
import com.example.todoapp.responses.PhoneResponse
import kotlinx.coroutines.launch


class PhoneViewModel(
    private val repository: PhoneRepository
) : ViewModel() {
    private val _phoneResponse : MutableLiveData<Resource<PhoneResponse>> = MutableLiveData()
    val checkPhoneResponse: LiveData<Resource<PhoneResponse>>
    get() = _phoneResponse

    fun checkPhone(
        msisdn: String
    ) = viewModelScope.launch {
        _phoneResponse.value = repository.checkPhone(msisdn)
    }

}