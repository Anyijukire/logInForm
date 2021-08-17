package com.example.schoolregistrationform.repository

import com.example.schoolregistrationform.api.ApiClient
import com.example.schoolregistrationform.api.ApiInterface
import com.example.schoolregistrationform.models.RegistrationRequest
import com.example.schoolregistrationform.models.RegistrationResponse
import com.example.schoolregistrationform.models.LogInRequest
import com.example.schoolregistrationform.models.LogInResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var retrofit= ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerUser(registrationRequest: RegistrationRequest):Response<RegistrationResponse>{
      return  withContext(Dispatchers.IO){
            val response= retrofit.registerStudent(registrationRequest)
            return@withContext response
        }
    }

    suspend fun logInuser(logInRequest: LogInRequest):Response<LogInResponse> {
        return withContext(Dispatchers.IO){
            val resp=retrofit.loginStudent(logInRequest)
            return@withContext resp
        }
    }

}