package com.example.schoolregistrationform.models

import com.google.gson.annotations.SerializedName

data class LogInResponse (var access_token:String,
                          var message:String,
                          var student_id:String)
