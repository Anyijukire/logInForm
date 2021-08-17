package com.example.schoolregistrationform.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import com.example.schoolregistrationform.databinding.ActivityMainBinding
import com.example.schoolregistrationform.models.RegistrationRequest
import com.example.schoolregistrationform.viewModel.UserViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setUpSpinner()
        binding.btnRegister.setOnClickListener {
            val name = binding.etJin.text.toString()
            if (name.isEmpty()) {
                binding.etJin.setError("enter name")

            }
            val nationality = binding.spinner.selectedItem.toString().toUpperCase()
            if (nationality.isEmpty()) {

            }

            val dob = binding.etDob.text.toString()
            if (dob.isEmpty()) {
                binding.etJin.setError("enter Date of birth")
            }

            val IdNumber = binding.etId.text.toString()
            if (IdNumber.isEmpty()) {
                binding.etId.setError("Enter Id number")
            }
            val phoneNumber = binding.etPhone.text.toString()
            if (phoneNumber.isEmpty()) {
                binding.etPhone.setError("Enter phone number")
            }
            val email = binding.etEmail.text.toString()
            if (email.isEmpty()) {
                binding.etEmail.setError("enter email")
            }
            val intent = Intent(baseContext, LogInActivity::class.java)
            startActivity(intent)
            val regRequest = RegistrationRequest(
                name = name, password = IdNumber, phoneNumber = phoneNumber, email = email,
                DOB = dob, nationality = nationality
            )
            userViewModel.registerStudent(regRequest)
        }

    }
            fun setUpSpinner() {


                val nationalities =
                    arrayListOf(
                        "Kenyan",
                        "Rwandan",
                        "SouthSudanese",
                        "Sudanese",
                        "Rwandan",
                        "Ugandan"
                    )
                val nationalitiesAdapter =
                    ArrayAdapter(
                        baseContext,
                        android.R.layout.simple_spinner_dropdown_item,
                        nationalities
                    )
                nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinner.adapter = nationalitiesAdapter


            }

    override fun onResume() {
        super.onResume()
        userViewModel.regResponseLiveData.observe(this, { regResponse ->
            binding.progressBar.visibility= View.GONE
            if (!regResponse.studentId.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regErrorLiveData.observe(this, { error ->
            Toast.makeText(baseContext, "error", Toast.LENGTH_SHORT).show()
        })
    }


    }
