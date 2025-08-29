package com.example.cashmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up) // Make sure XML is renamed if needed

        val emailEt = findViewById<EditText>(R.id.emailEt)
        val passEt = findViewById<EditText>(R.id.passET)
        val confirmPassEt = findViewById<EditText>(R.id.confirmPassEt)
        val button = findViewById<Button>(R.id.button)
        val SignInText = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            val email = emailEt.text.toString().trim()
            val password = passEt.text.toString()
            val confirmPassword = confirmPassEt.text.toString()

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // Save to SharedPreferences
                val sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("email", email)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Registered successfully!", Toast.LENGTH_SHORT).show()

                // Navigate to SignIn activity
                val intent = Intent(this, SignIn::class.java)
                startActivity(intent)
                finish() // Optional: finish SignUp so user can't go back
            }

            SignInText.setOnClickListener {
                val intent = Intent(this, SignUp::class.java)
                startActivity(intent)
            }
        }
    }
}
