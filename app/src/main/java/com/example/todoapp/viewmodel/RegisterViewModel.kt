package com.example.todoapp.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.network.Resource
import com.example.todoapp.repository.RegisterRepository
import com.example.todoapp.responses.RegisterResponse
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val registerRepository: RegisterRepository
    ) : ViewModel() {
    private val _registerResponse: MutableLiveData<Resource<RegisterResponse>> = MutableLiveData()
    val registerResponse: LiveData<Resource<RegisterResponse>>
    get() = _registerResponse

    fun makeRegisterRequest(first_name: String, last_name: String, msisdn: String, group_id: String, password: String) {
        viewModelScope.launch {
               _registerResponse.value =  registerRepository.register(first_name, last_name, msisdn, group_id , password)
        }
    }
}
