package com.example.schoolregistrationform.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.schoolregistrationform.R
import com.example.schoolregistrationform.databinding.ActivityLogInBinding
import com.example.schoolregistrationform.models.LogInRequest
import com.example.schoolregistrationform.viewModel.UserViewModel


class LogInActivity : AppCompatActivity() {

    lateinit var bindin: ActivityLogInBinding
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        bindin = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(bindin.root)


        bindin.button.setOnClickListener {
            val email = bindin.emaill.text.toString()
            if (email.isEmpty()) {
                bindin.emaill.setError("enter name")
            }
            val pass = bindin.passs.text.toString()
            if (pass.isEmpty()) {
                bindin.passs.setError("enter name")
            }
            val logRequest =
                LogInRequest(
                    email = email, password = pass
                )
            val intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)

            userViewModel.logInStudent(logRequest)
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.logResponseLiveData.observe(this, { logResponse ->
            if (!logResponse.studentId.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Log in successful", Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.logErrorLiveData.observe(this, { error ->
            Toast.makeText(baseContext, "error", Toast.LENGTH_SHORT).show()
        })

    }
}
