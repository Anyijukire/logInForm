package com.example.schoolregistrationform.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.schoolregistrationform.Constants
import com.example.schoolregistrationform.R
import com.example.schoolregistrationform.databinding.ActivityLogInBinding
import com.example.schoolregistrationform.models.LogInRequest
import com.example.schoolregistrationform.viewModel.UserViewModel
import com.example.schoolregistrationform.viewModel.logInViewModel


class LogInActivity : AppCompatActivity() {

    lateinit var bindin: ActivityLogInBinding
    lateinit var sharedPrefs:SharedPreferences
    val logViewModel: logInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        bindin = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(bindin.root)


        sharedPrefs=getSharedPreferences(Constants.PREFS_FILE, Context.MODE_PRIVATE)

        bindin.button.setOnClickListener {
            bindin.progressBar2.visibility= View.VISIBLE

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
            logViewModel.logInStudent(logRequest)


        }
    }
    //george.odenyo@actuatedigital.co.ke

    override fun onResume() {
        super.onResume()
        logViewModel.logResponseLiveData.observe(this, { logResponse ->
//            if (!logResponse.student_id.isNullOrEmpty()) {
            bindin.progressBar2.visibility= View.GONE
            var editor=sharedPrefs.edit()
            editor.putString(Constants.ACCESS_TOKEN, logResponse.access_token)
            editor.putString(Constants.STUDENT_ID, logResponse.student_id)
            editor.apply()
            Toast.makeText(baseContext, logResponse.message, Toast.LENGTH_LONG).show()
            val intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)

//            }
        })
        logViewModel.logErrorLiveData.observe(this, { error ->
            bindin.progressBar2.visibility= View.GONE
            Toast.makeText(baseContext, error, Toast.LENGTH_SHORT).show()
        })

    }
}
