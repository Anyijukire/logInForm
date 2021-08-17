package com.example.schoolregistrationform.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schoolregistrationform.models.RegistrationRequest
import com.example.schoolregistrationform.models.RegistrationResponse
import com.example.schoolregistrationform.models.LogInRequest
import com.example.schoolregistrationform.models.LogInResponse
import com.example.schoolregistrationform.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    var userRepository=UserRepository()
    var regResponseLiveData = MediatorLiveData<RegistrationResponse>()
    var regErrorLiveData = MediatorLiveData<String>()

    var logResponseLiveData = MediatorLiveData<LogInResponse>()
    var logErrorLiveData = MediatorLiveData<String>()

    fun registerStudent(registrationRequest: RegistrationRequest){
    viewModelScope.launch {
        val response = userRepository.registerUser(registrationRequest)
        if (response.isSuccessful){
            regResponseLiveData.postValue(response.body())
        }
        else{
            regErrorLiveData.postValue(response.errorBody()?.string())
        }
    }
    }
    fun logInStudent(logInRequest: LogInRequest){
        viewModelScope.launch {
            val resp = userRepository.logInuser(logInRequest)
                    if (resp.isSuccessful){
                        logResponseLiveData.postValue(resp.body())
                    }
                    else{
                        logErrorLiveData.postValue(resp.errorBody()?.string())
                    }
                }

            }




}