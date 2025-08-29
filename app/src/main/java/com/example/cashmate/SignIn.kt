package com.example.cashmate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cashmate.ui.passcode.PasscodeActivity

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val emailEt = findViewById<EditText>(R.id.emailEt)
        val passEt = findViewById<EditText>(R.id.passET)
        val button = findViewById<Button>(R.id.button)
        val SignUpTxt = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            val email = emailEt.text.toString().trim()
            val password = passEt.text.toString()

            val sharedPref = getSharedPreferences("User", Context.MODE_PRIVATE)
            val savedEmail = sharedPref.getString("email", "")
            val savedPassword = sharedPref.getString("password", "")

            if (email == savedEmail && password == savedPassword) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PasscodeActivity::class.java)
                startActivity(intent)
                // Proceed to home or next screen
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
        SignUpTxt.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}
