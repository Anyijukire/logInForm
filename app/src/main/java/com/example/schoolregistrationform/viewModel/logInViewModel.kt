package com.example.schoolregistrationform.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schoolregistrationform.models.RegistrationRequest
import com.example.schoolregistrationform.models.RegistrationResponse
import com.example.schoolregistrationform.models.LogInRequest
import com.example.schoolregistrationform.models.LogInResponse
import com.example.schoolregistrationform.repository.UserRepository
import kotlinx.coroutines.launch

class logInViewModel:ViewModel() {
    var userRepository=UserRepository()

    var logResponseLiveData = MutableLiveData<LogInResponse>()
    var logErrorLiveData = MutableLiveData<String>()


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