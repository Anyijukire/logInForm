package com.example.schoolregistrationform.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolregistrationform.models.Course
import com.example.schoolregistrationform.R
import com.example.schoolregistrationform.databinding.ActivityCoursesBinding

class CoursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoursesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courseList= listOf(
            Course("Kotlin","John",34, "building Android applications"),
            Course("python","James",24,"Making the backend"),
            Course("Javascript","Purity Maina",41,"Making Websites' Backend and frontend"),
            Course("IoT","Barre Yasin",242,"Building Internet of things using C++"),
            Course("research","Joy",43,"Making a good understanding of the problem by knowing what the users want"),
            Course("BIOS","Janet Anyijukire",45,"Basic Input Output System studies"),
            Course("Algorithms","Derek Mugisha",14,"Self learning something to make" +
                    " one different how well you study is determined by how well you learn by your self"),
            Course("Design","Peruth Nowamani",47,"Making good ui interfaces by producing good designs have fun"),
            Course("AWS","Ruth Niwamanya",40,"Some thing different. Get to be exposed come prepared wooo"),
            Course("Content writing","Frank Rwamatungu",74,"Learn how to document your work its helpful oh, " +
                    "Have fun learning new content")
        )
        binding.rvCourses.layoutManager = LinearLayoutManager(baseContext)
        val recyclerAdapter = CoursesAdapter(courseList)
        binding.rvCourses.adapter = recyclerAdapter
    }
}
