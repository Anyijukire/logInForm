package com.example.schoolregistrationform.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolregistrationform.Constants
import com.example.schoolregistrationform.models.Course
import com.example.schoolregistrationform.R
import com.example.schoolregistrationform.api.ApiClient
import com.example.schoolregistrationform.api.ApiInterface
import com.example.schoolregistrationform.databinding.ActivityCoursesBinding
import com.example.schoolregistrationform.viewModel.CoursesViewModel
import com.example.schoolregistrationform.viewModel.UserViewModel

class CoursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoursesBinding
    lateinit var sharedprefs: SharedPreferences
    val courseViewModel: CoursesViewModel by viewModels()
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

    binding.rvCourses.layoutManager=LinearLayoutManager(baseContext)


    }
    override fun onResume() {
        super.onResume()
        courseViewModel.courseResponseLiveData.observe(this, { courseResponse ->
           if (!courseResponse.isNullOrEmpty()) {
               binding.progressBar3.visibility = View.GONE
               var courseList=courseResponse
               binding.rvCourses.adapter = CoursesAdapter(courseList)


               Toast.makeText(baseContext, courseResponse.size, Toast.LENGTH_LONG).show()
               val intent = Intent(baseContext, MainActivity::class.java)
               startActivity(intent)
           }
        })
        courseViewModel.courseErrorLiveData.observe(this, { error ->
            binding.progressBar3.visibility= View.GONE
            Toast.makeText(baseContext, error, Toast.LENGTH_SHORT).show()
        })

    }

//    Use the MVVM pattern to fetch and display the courses from the API in a
//    recyclerview. Your app should also be able to “remember” a logged in user and not
//    request them to log in again each time they open the app.
}
