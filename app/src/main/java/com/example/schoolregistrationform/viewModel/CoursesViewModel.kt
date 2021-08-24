package com.example.schoolregistrationform.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.schoolregistrationform.models.*
import com.example.schoolregistrationform.repository.UserRepository
import kotlinx.coroutines.launch

class CoursesViewModel:ViewModel() {
    var userRepository=UserRepository()
    var courseResponseLiveData = MutableLiveData<List<Course>>()
    var courseErrorLiveData = MutableLiveData<String>()



    fun showCourses(list: List<Course>){
        viewModelScope.launch {
            val response = userRepository.getCourses()
            if (response.isSuccessful){
                courseResponseLiveData.postValue(response.body())
            }
            else{
                courseErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}