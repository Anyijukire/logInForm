package com.example.schoolregistrationform.api

import com.example.schoolregistrationform.models.RegistrationRequest
import com.example.schoolregistrationform.models.RegistrationResponse
import com.example.schoolregistrationform.models.LogInRequest
import com.example.schoolregistrationform.models.LogInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
   suspend fun registerStudent(@Body registrationRequest: RegistrationRequest):Response<RegistrationResponse>
    @POST("/students/login")
   suspend fun loginStudent(@Body logInRequest: LogInRequest):Response<LogInResponse>
}
