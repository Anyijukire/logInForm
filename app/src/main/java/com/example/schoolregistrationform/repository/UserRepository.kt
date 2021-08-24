package com.example.schoolregistrationform.repository

import android.provider.SyncStateContract
import com.example.schoolregistrationform.Constants
import com.example.schoolregistrationform.api.ApiClient
import com.example.schoolregistrationform.api.ApiInterface
import com.example.schoolregistrationform.models.*
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

    suspend fun getCourses(): Response<List<Course>>{
        return withContext(Dispatchers.IO){
            val res=retrofit.fetchCourses(Constants.ACCESS_TOKEN)
            return@withContext res
        }
    }

}